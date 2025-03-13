package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class device extends Activity implements B4AActivity{
	public static device mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.device");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (device).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.device");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.device", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (device) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (device) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return device.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (device) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (device) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            device mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (device) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static int _limit = 0;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _scrollviewpanel = null;
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public static int _num = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel3 = null;
public static int _pageno = 0;
public anywheresoftware.b4a.objects.LabelWrapper _pagelabel = null;
public static String _phpurl = "";
public static int _panelwidth = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _branches = null;
public anywheresoftware.b4a.objects.LabelWrapper _devices = null;
public anywheresoftware.b4a.objects.LabelWrapper _home = null;
public static int _tdleftpos = 0;
public anywheresoftware.b4a.objects.LabelWrapper _totallabel = null;
public b4a.example.main _main = null;
public b4a.example.branch _branch = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.PanelWrapper _tablelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _idlabel = null;
anywheresoftware.b4a.objects.LabelWrapper _devicelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _seriallabel = null;
anywheresoftware.b4a.objects.LabelWrapper _sale1label = null;
anywheresoftware.b4a.objects.LabelWrapper _sale2label = null;
anywheresoftware.b4a.objects.LabelWrapper _sale3label = null;
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient = null;
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Activity.LoadLayout(\"Device\")";
mostCurrent._activity.LoadLayout("Device",mostCurrent.activityBA);
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="ScrollView1.Width = 100%x";
mostCurrent._scrollview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="ScrollViewPanel.Initialize(\"\")";
mostCurrent._scrollviewpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._scrollviewpanel.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="TableDetails.Initialize";
mostCurrent._tabledetails.Initialize();
RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="Dim tableLabel As Panel";
_tablelabel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="tableLabel.Initialize(\"deviceTitle\")";
_tablelabel.Initialize(mostCurrent.activityBA,"deviceTitle");
RDebugUtils.currentLine=3538965;
 //BA.debugLineNum = 3538965;BA.debugLine="tableLabel.Color = Colors.Black";
_tablelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3538966;
 //BA.debugLineNum = 3538966;BA.debugLine="Panel1.AddView(tableLabel, 0, Panel2.Height+Panel";
mostCurrent._panel1.AddView((android.view.View)(_tablelabel.getObject()),(int) (0),(int) (mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=3538968;
 //BA.debugLineNum = 3538968;BA.debugLine="ScrollView1.Top = tableLabel.Height + Panel2.Heig";
mostCurrent._scrollview1.setTop((int) (_tablelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=3538970;
 //BA.debugLineNum = 3538970;BA.debugLine="panelWidth = tableLabel.Width /6";
_panelwidth = (int) (_tablelabel.getWidth()/(double)6);
RDebugUtils.currentLine=3538972;
 //BA.debugLineNum = 3538972;BA.debugLine="Dim idLabel As Label";
_idlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3538973;
 //BA.debugLineNum = 3538973;BA.debugLine="idLabel.Initialize(\"\")";
_idlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3538974;
 //BA.debugLineNum = 3538974;BA.debugLine="idLabel.Text = \"ID\"";
_idlabel.setText(BA.ObjectToCharSequence("ID"));
RDebugUtils.currentLine=3538975;
 //BA.debugLineNum = 3538975;BA.debugLine="idLabel.TextColor= Colors.White";
_idlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3538976;
 //BA.debugLineNum = 3538976;BA.debugLine="idLabel.Gravity = Gravity.CENTER_VERTICAL";
_idlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3538977;
 //BA.debugLineNum = 3538977;BA.debugLine="idLabel.Typeface = Typeface.MONOSPACE";
_idlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3538978;
 //BA.debugLineNum = 3538978;BA.debugLine="tableLabel.AddView(idLabel,tdleftPos,0dip,panelWi";
_tablelabel.AddView((android.view.View)(_idlabel.getObject()),_tdleftpos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3538980;
 //BA.debugLineNum = 3538980;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3538981;
 //BA.debugLineNum = 3538981;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3538982;
 //BA.debugLineNum = 3538982;BA.debugLine="deviceLabel.Text = \"NAME\"";
_devicelabel.setText(BA.ObjectToCharSequence("NAME"));
RDebugUtils.currentLine=3538983;
 //BA.debugLineNum = 3538983;BA.debugLine="deviceLabel.TextColor= Colors.White";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3538984;
 //BA.debugLineNum = 3538984;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3538985;
 //BA.debugLineNum = 3538985;BA.debugLine="deviceLabel.Typeface = Typeface.MONOSPACE";
_devicelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3538986;
 //BA.debugLineNum = 3538986;BA.debugLine="tableLabel.AddView(deviceLabel,panelWidth,0,panel";
_tablelabel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3538988;
 //BA.debugLineNum = 3538988;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3538989;
 //BA.debugLineNum = 3538989;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3538990;
 //BA.debugLineNum = 3538990;BA.debugLine="serialLabel.Text = \"SERIAL NUMBER\"";
_seriallabel.setText(BA.ObjectToCharSequence("SERIAL NUMBER"));
RDebugUtils.currentLine=3538991;
 //BA.debugLineNum = 3538991;BA.debugLine="serialLabel.TextSize = 11";
_seriallabel.setTextSize((float) (11));
RDebugUtils.currentLine=3538992;
 //BA.debugLineNum = 3538992;BA.debugLine="serialLabel.TextColor= Colors.White";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3538993;
 //BA.debugLineNum = 3538993;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3538994;
 //BA.debugLineNum = 3538994;BA.debugLine="serialLabel.Typeface = Typeface.MONOSPACE";
_seriallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3538995;
 //BA.debugLineNum = 3538995;BA.debugLine="tableLabel.AddView(serialLabel,panelWidth*2,0,pan";
_tablelabel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3538997;
 //BA.debugLineNum = 3538997;BA.debugLine="Dim sale1Label As Label";
_sale1label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3538998;
 //BA.debugLineNum = 3538998;BA.debugLine="sale1Label.Initialize(\"\")";
_sale1label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3538999;
 //BA.debugLineNum = 3538999;BA.debugLine="sale1Label.Text = \"FIRST SALE\"";
_sale1label.setText(BA.ObjectToCharSequence("FIRST SALE"));
RDebugUtils.currentLine=3539000;
 //BA.debugLineNum = 3539000;BA.debugLine="sale1Label.TextColor= Colors.White";
_sale1label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3539001;
 //BA.debugLineNum = 3539001;BA.debugLine="sale1Label.TextSize = 11";
_sale1label.setTextSize((float) (11));
RDebugUtils.currentLine=3539002;
 //BA.debugLineNum = 3539002;BA.debugLine="sale1Label.Gravity = Gravity.CENTER_VERTICAL";
_sale1label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3539003;
 //BA.debugLineNum = 3539003;BA.debugLine="sale1Label.Typeface = Typeface.MONOSPACE";
_sale1label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3539004;
 //BA.debugLineNum = 3539004;BA.debugLine="tableLabel.AddView(sale1Label,panelWidth*3,0,pane";
_tablelabel.AddView((android.view.View)(_sale1label.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3539006;
 //BA.debugLineNum = 3539006;BA.debugLine="Dim sale2Label As Label";
_sale2label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3539007;
 //BA.debugLineNum = 3539007;BA.debugLine="sale2Label.Initialize(\"\")";
_sale2label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3539008;
 //BA.debugLineNum = 3539008;BA.debugLine="sale2Label.Text = \"SECOND SALE\"";
_sale2label.setText(BA.ObjectToCharSequence("SECOND SALE"));
RDebugUtils.currentLine=3539009;
 //BA.debugLineNum = 3539009;BA.debugLine="sale2Label.TextColor= Colors.White";
_sale2label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3539010;
 //BA.debugLineNum = 3539010;BA.debugLine="sale2Label.TextSize = 11";
_sale2label.setTextSize((float) (11));
RDebugUtils.currentLine=3539011;
 //BA.debugLineNum = 3539011;BA.debugLine="sale2Label.Gravity = Gravity.CENTER_VERTICAL";
_sale2label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3539012;
 //BA.debugLineNum = 3539012;BA.debugLine="sale2Label.Typeface = Typeface.MONOSPACE";
_sale2label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3539013;
 //BA.debugLineNum = 3539013;BA.debugLine="tableLabel.AddView(sale2Label,panelWidth*4,0,pane";
_tablelabel.AddView((android.view.View)(_sale2label.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3539015;
 //BA.debugLineNum = 3539015;BA.debugLine="Dim sale3Label As Label";
_sale3label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3539016;
 //BA.debugLineNum = 3539016;BA.debugLine="sale3Label.Initialize(\"\")";
_sale3label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3539017;
 //BA.debugLineNum = 3539017;BA.debugLine="sale3Label.Text = \"THIRD SALE\"";
_sale3label.setText(BA.ObjectToCharSequence("THIRD SALE"));
RDebugUtils.currentLine=3539018;
 //BA.debugLineNum = 3539018;BA.debugLine="sale3Label.TextSize = 11";
_sale3label.setTextSize((float) (11));
RDebugUtils.currentLine=3539019;
 //BA.debugLineNum = 3539019;BA.debugLine="sale3Label.TextColor= Colors.White";
_sale3label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3539020;
 //BA.debugLineNum = 3539020;BA.debugLine="sale3Label.Gravity = Gravity.CENTER_VERTICAL";
_sale3label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3539021;
 //BA.debugLineNum = 3539021;BA.debugLine="sale3Label.Typeface = Typeface.MONOSPACE";
_sale3label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3539022;
 //BA.debugLineNum = 3539022;BA.debugLine="tableLabel.AddView(sale3Label,panelWidth*5,0,pane";
_tablelabel.AddView((android.view.View)(_sale3label.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3539025;
 //BA.debugLineNum = 3539025;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=3539026;
 //BA.debugLineNum = 3539026;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=3539027;
 //BA.debugLineNum = 3539027;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3539028;
 //BA.debugLineNum = 3539028;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3539029;
 //BA.debugLineNum = 3539029;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3539030;
 //BA.debugLineNum = 3539030;BA.debugLine="home.TextSize = 16 '";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=3539031;
 //BA.debugLineNum = 3539031;BA.debugLine="Panel4.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=3539032;
 //BA.debugLineNum = 3539032;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=3539034;
 //BA.debugLineNum = 3539034;BA.debugLine="branches.Initialize(\"branch\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"branch");
RDebugUtils.currentLine=3539035;
 //BA.debugLineNum = 3539035;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=3539036;
 //BA.debugLineNum = 3539036;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3539037;
 //BA.debugLineNum = 3539037;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3539038;
 //BA.debugLineNum = 3539038;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=3539039;
 //BA.debugLineNum = 3539039;BA.debugLine="branches.TextColor = Colors.Black";
mostCurrent._branches.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3539040;
 //BA.debugLineNum = 3539040;BA.debugLine="Panel4.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (210)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=3539043;
 //BA.debugLineNum = 3539043;BA.debugLine="devices.Initialize(\"device\")";
mostCurrent._devices.Initialize(mostCurrent.activityBA,"device");
RDebugUtils.currentLine=3539044;
 //BA.debugLineNum = 3539044;BA.debugLine="devices.Text = \"Devices\"";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices"));
RDebugUtils.currentLine=3539045;
 //BA.debugLineNum = 3539045;BA.debugLine="devices.Typeface = Typeface.MONOSPACE";
mostCurrent._devices.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3539046;
 //BA.debugLineNum = 3539046;BA.debugLine="devices.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._devices.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3539047;
 //BA.debugLineNum = 3539047;BA.debugLine="devices.TextSize = 16";
mostCurrent._devices.setTextSize((float) (16));
RDebugUtils.currentLine=3539048;
 //BA.debugLineNum = 3539048;BA.debugLine="Panel4.AddView(devices, branches.Left + branches.";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._devices.getObject()),(int) (mostCurrent._branches.getLeft()+mostCurrent._branches.getWidth()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=3539049;
 //BA.debugLineNum = 3539049;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=3539051;
 //BA.debugLineNum = 3539051;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=3539052;
 //BA.debugLineNum = 3539052;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=3539053;
 //BA.debugLineNum = 3539053;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=3539055;
 //BA.debugLineNum = 3539055;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=3539056;
 //BA.debugLineNum = 3539056;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="PHPURL = \"https://192.168.8.117/Company/fetch.php";
mostCurrent._phpurl = "https://192.168.8.117/Company/fetch.php?action=get_device&id="+mostCurrent._branch._branch_selected /*String*/ +"&page="+BA.NumberToString(_pageno)+"&limit="+BA.NumberToString(_limit);
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Log(PHPURL)";
anywheresoftware.b4a.keywords.Common.LogImpl("53670018",mostCurrent._phpurl,0);
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="Job1.Initialize(\"\", Me)";
_job1._initialize /*String*/ (null,processBA,"",device.getObject());
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="device";
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Private Sub backBtn_Click";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="If pageNo > 1 Then";
if (_pageno>1) { 
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="pageNo = pageNo - 1";
_pageno = (int) (_pageno-1);
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="num = 1";
_num = (int) (1);
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 };
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="End Sub";
return "";
}
public static String  _branch_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "branch_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "branch_click", null));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Private Sub branch_Click";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _ypos = 0;
int _margin = 0;
int _totalheight = 0;
int _totaldevices = 0;
int _tdfontsize = 0;
anywheresoftware.b4a.objects.collections.Map _record = null;
String _serial_num = "";
String _sales1 = "";
String _sales2 = "";
String _sales3 = "";
int _id = 0;
String _comname = "";
anywheresoftware.b4a.objects.PanelWrapper _itempanel = null;
anywheresoftware.b4a.objects.LabelWrapper _number = null;
anywheresoftware.b4a.objects.LabelWrapper _devicelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _seriallabel = null;
anywheresoftware.b4a.objects.LabelWrapper _sale = null;
anywheresoftware.b4a.objects.LabelWrapper _sale1 = null;
anywheresoftware.b4a.objects.LabelWrapper _sale2 = null;
anywheresoftware.b4a.objects.LabelWrapper _backbtn = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
anywheresoftware.b4a.objects.LabelWrapper _nxtlabel = null;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="Try";
try {RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="ScrollViewPanel.RemoveAllViews";
mostCurrent._scrollviewpanel.RemoveAllViews();
RDebugUtils.currentLine=3866633;
 //BA.debugLineNum = 3866633;BA.debugLine="Dim YPos As Int = 0";
_ypos = (int) (0);
RDebugUtils.currentLine=3866634;
 //BA.debugLineNum = 3866634;BA.debugLine="Dim Margin As Int = 0dip";
_margin = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0));
RDebugUtils.currentLine=3866635;
 //BA.debugLineNum = 3866635;BA.debugLine="Dim TotalHeight As Int = 0";
_totalheight = (int) (0);
RDebugUtils.currentLine=3866636;
 //BA.debugLineNum = 3866636;BA.debugLine="Dim totalDevices As Int = 0";
_totaldevices = (int) (0);
RDebugUtils.currentLine=3866637;
 //BA.debugLineNum = 3866637;BA.debugLine="YPos = YPos + 0%y + Margin";
_ypos = (int) (_ypos+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA)+_margin);
RDebugUtils.currentLine=3866638;
 //BA.debugLineNum = 3866638;BA.debugLine="Dim tdFontSize As Int = 13";
_tdfontsize = (int) (13);
RDebugUtils.currentLine=3866640;
 //BA.debugLineNum = 3866640;BA.debugLine="TotalLabel.Initialize(\"TotalLabel\")";
mostCurrent._totallabel.Initialize(mostCurrent.activityBA,"TotalLabel");
RDebugUtils.currentLine=3866641;
 //BA.debugLineNum = 3866641;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group16 = mostCurrent._tabledetails;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group16.Get(index16)));
RDebugUtils.currentLine=3866643;
 //BA.debugLineNum = 3866643;BA.debugLine="Dim serial_num As String = record.Get(\"serial\"";
_serial_num = BA.ObjectToString(_record.Get((Object)("serial")));
RDebugUtils.currentLine=3866644;
 //BA.debugLineNum = 3866644;BA.debugLine="Dim sales1 As String = record.Get(\"sales1\")";
_sales1 = BA.ObjectToString(_record.Get((Object)("sales1")));
RDebugUtils.currentLine=3866645;
 //BA.debugLineNum = 3866645;BA.debugLine="Dim sales2 As String = record.Get(\"sales2\")";
_sales2 = BA.ObjectToString(_record.Get((Object)("sales2")));
RDebugUtils.currentLine=3866646;
 //BA.debugLineNum = 3866646;BA.debugLine="Dim sales3 As String = record.Get(\"sales3\")";
_sales3 = BA.ObjectToString(_record.Get((Object)("sales3")));
RDebugUtils.currentLine=3866648;
 //BA.debugLineNum = 3866648;BA.debugLine="Dim id As Int = 0";
_id = (int) (0);
RDebugUtils.currentLine=3866649;
 //BA.debugLineNum = 3866649;BA.debugLine="totalDevices = record.Get(\"totalDevices\")";
_totaldevices = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=3866650;
 //BA.debugLineNum = 3866650;BA.debugLine="Dim comName As String = record.Get(\"comName\")";
_comname = BA.ObjectToString(_record.Get((Object)("comName")));
RDebugUtils.currentLine=3866651;
 //BA.debugLineNum = 3866651;BA.debugLine="LabelTitle.Text = record.Get(\"branchName\")";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_record.Get((Object)("branchName"))));
RDebugUtils.currentLine=3866652;
 //BA.debugLineNum = 3866652;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCase";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=3866654;
 //BA.debugLineNum = 3866654;BA.debugLine="Label1.Text = comName";
mostCurrent._label1.setText(BA.ObjectToCharSequence(_comname));
RDebugUtils.currentLine=3866655;
 //BA.debugLineNum = 3866655;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=3866657;
 //BA.debugLineNum = 3866657;BA.debugLine="branches.Text = \"Branches - \"&comName&\" |\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_comname+" |"));
RDebugUtils.currentLine=3866658;
 //BA.debugLineNum = 3866658;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=3866660;
 //BA.debugLineNum = 3866660;BA.debugLine="devices.Text = \"Devices - \"&record.Get(\"branch";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices - "+BA.ObjectToString(_record.Get((Object)("branchName")))));
RDebugUtils.currentLine=3866661;
 //BA.debugLineNum = 3866661;BA.debugLine="devices.Text = devices.Text.ToUpperCase";
mostCurrent._devices.setText(BA.ObjectToCharSequence(mostCurrent._devices.getText().toUpperCase()));
RDebugUtils.currentLine=3866663;
 //BA.debugLineNum = 3866663;BA.debugLine="Dim ItemPanel As Panel";
_itempanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3866664;
 //BA.debugLineNum = 3866664;BA.debugLine="ItemPanel.Initialize(\"\")";
_itempanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3866665;
 //BA.debugLineNum = 3866665;BA.debugLine="ItemPanel.SetLayout(0, YPos, ScrollView1.Width";
_itempanel.SetLayout((int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
RDebugUtils.currentLine=3866666;
 //BA.debugLineNum = 3866666;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_itempanel.getObject()),(int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=3866667;
 //BA.debugLineNum = 3866667;BA.debugLine="panelWidth = ItemPanel.Width /6";
_panelwidth = (int) (_itempanel.getWidth()/(double)6);
RDebugUtils.currentLine=3866668;
 //BA.debugLineNum = 3866668;BA.debugLine="If num Mod 2 = 0 Then";
if (_num%2==0) { 
RDebugUtils.currentLine=3866669;
 //BA.debugLineNum = 3866669;BA.debugLine="ItemPanel.Color = Colors.LightGray";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 }else {
RDebugUtils.currentLine=3866671;
 //BA.debugLineNum = 3866671;BA.debugLine="ItemPanel.Color = Colors.ARGB(255, 251, 251,";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
 };
RDebugUtils.currentLine=3866674;
 //BA.debugLineNum = 3866674;BA.debugLine="Dim number As Label";
_number = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866675;
 //BA.debugLineNum = 3866675;BA.debugLine="number.Initialize(\"\")";
_number.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3866676;
 //BA.debugLineNum = 3866676;BA.debugLine="number.Text = id";
_number.setText(BA.ObjectToCharSequence(_id));
RDebugUtils.currentLine=3866677;
 //BA.debugLineNum = 3866677;BA.debugLine="number.TextSize = tdFontSize";
_number.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=3866678;
 //BA.debugLineNum = 3866678;BA.debugLine="number.TextColor = Colors.Black";
_number.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866679;
 //BA.debugLineNum = 3866679;BA.debugLine="number.Gravity = Gravity.CENTER_VERTICAL";
_number.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3866680;
 //BA.debugLineNum = 3866680;BA.debugLine="number.Typeface = Typeface.MONOSPACE";
_number.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3866681;
 //BA.debugLineNum = 3866681;BA.debugLine="ItemPanel.AddView(number, tdleftPos, 0, panelW";
_itempanel.AddView((android.view.View)(_number.getObject()),_tdleftpos,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=3866683;
 //BA.debugLineNum = 3866683;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866684;
 //BA.debugLineNum = 3866684;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3866685;
 //BA.debugLineNum = 3866685;BA.debugLine="deviceLabel.Text = \"Pos0\"&id";
_devicelabel.setText(BA.ObjectToCharSequence("Pos0"+BA.NumberToString(_id)));
RDebugUtils.currentLine=3866686;
 //BA.debugLineNum = 3866686;BA.debugLine="deviceLabel.TextSize = tdFontSize";
_devicelabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=3866687;
 //BA.debugLineNum = 3866687;BA.debugLine="deviceLabel.TextColor = Colors.Black";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866688;
 //BA.debugLineNum = 3866688;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3866689;
 //BA.debugLineNum = 3866689;BA.debugLine="ItemPanel.AddView(deviceLabel, panelWidth, 0,";
_itempanel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=3866691;
 //BA.debugLineNum = 3866691;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866692;
 //BA.debugLineNum = 3866692;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3866693;
 //BA.debugLineNum = 3866693;BA.debugLine="serialLabel.Text = serial_num";
_seriallabel.setText(BA.ObjectToCharSequence(_serial_num));
RDebugUtils.currentLine=3866694;
 //BA.debugLineNum = 3866694;BA.debugLine="serialLabel.TextSize = tdFontSize";
_seriallabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=3866695;
 //BA.debugLineNum = 3866695;BA.debugLine="serialLabel.TextColor = Colors.Black";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866696;
 //BA.debugLineNum = 3866696;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3866697;
 //BA.debugLineNum = 3866697;BA.debugLine="ItemPanel.AddView(serialLabel, panelWidth*2, 0";
_itempanel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=3866699;
 //BA.debugLineNum = 3866699;BA.debugLine="Dim sale As Label";
_sale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866700;
 //BA.debugLineNum = 3866700;BA.debugLine="sale.Initialize(\"\")";
_sale.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3866701;
 //BA.debugLineNum = 3866701;BA.debugLine="sale.Text = sales1";
_sale.setText(BA.ObjectToCharSequence(_sales1));
RDebugUtils.currentLine=3866702;
 //BA.debugLineNum = 3866702;BA.debugLine="sale.TextSize = tdFontSize";
_sale.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=3866703;
 //BA.debugLineNum = 3866703;BA.debugLine="sale.TextColor = Colors.Black";
_sale.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866704;
 //BA.debugLineNum = 3866704;BA.debugLine="sale.Gravity = Gravity.CENTER_VERTICAL";
_sale.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3866705;
 //BA.debugLineNum = 3866705;BA.debugLine="ItemPanel.AddView(sale, panelWidth*3, 0, panel";
_itempanel.AddView((android.view.View)(_sale.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=3866707;
 //BA.debugLineNum = 3866707;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866708;
 //BA.debugLineNum = 3866708;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3866709;
 //BA.debugLineNum = 3866709;BA.debugLine="sale1.Text = sales2";
_sale1.setText(BA.ObjectToCharSequence(_sales2));
RDebugUtils.currentLine=3866710;
 //BA.debugLineNum = 3866710;BA.debugLine="sale1.TextSize = tdFontSize";
_sale1.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=3866711;
 //BA.debugLineNum = 3866711;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866712;
 //BA.debugLineNum = 3866712;BA.debugLine="sale1.Gravity = Gravity.CENTER_VERTICAL";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3866713;
 //BA.debugLineNum = 3866713;BA.debugLine="ItemPanel.AddView(sale1, panelWidth*4, 0, pane";
_itempanel.AddView((android.view.View)(_sale1.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=3866715;
 //BA.debugLineNum = 3866715;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866716;
 //BA.debugLineNum = 3866716;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3866717;
 //BA.debugLineNum = 3866717;BA.debugLine="sale2.Text = sales3";
_sale2.setText(BA.ObjectToCharSequence(_sales3));
RDebugUtils.currentLine=3866718;
 //BA.debugLineNum = 3866718;BA.debugLine="sale2.TextSize = tdFontSize";
_sale2.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=3866719;
 //BA.debugLineNum = 3866719;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866720;
 //BA.debugLineNum = 3866720;BA.debugLine="sale2.Gravity = Gravity.CENTER_VERTICAL";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3866721;
 //BA.debugLineNum = 3866721;BA.debugLine="ItemPanel.AddView(sale2, panelWidth*5, 0, pane";
_itempanel.AddView((android.view.View)(_sale2.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=3866723;
 //BA.debugLineNum = 3866723;BA.debugLine="Dim backBtn As Label";
_backbtn = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866724;
 //BA.debugLineNum = 3866724;BA.debugLine="backBtn.Initialize(\"backBtn\")";
_backbtn.Initialize(mostCurrent.activityBA,"backBtn");
RDebugUtils.currentLine=3866725;
 //BA.debugLineNum = 3866725;BA.debugLine="backBtn.TextColor =Colors.White";
_backbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3866726;
 //BA.debugLineNum = 3866726;BA.debugLine="backBtn.Text = \"<\"";
_backbtn.setText(BA.ObjectToCharSequence("<"));
RDebugUtils.currentLine=3866727;
 //BA.debugLineNum = 3866727;BA.debugLine="backBtn.Gravity = Gravity.CENTER";
_backbtn.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3866728;
 //BA.debugLineNum = 3866728;BA.debugLine="backBtn.Typeface = Typeface.SERIF";
_backbtn.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=3866729;
 //BA.debugLineNum = 3866729;BA.debugLine="backBtn.Color = Colors.Black";
_backbtn.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866730;
 //BA.debugLineNum = 3866730;BA.debugLine="backBtn.TextSize = 25";
_backbtn.setTextSize((float) (25));
RDebugUtils.currentLine=3866731;
 //BA.debugLineNum = 3866731;BA.debugLine="Panel3.AddView(backBtn,3dip,5dip,50dip,Panel3.";
mostCurrent._panel3.AddView((android.view.View)(_backbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=3866733;
 //BA.debugLineNum = 3866733;BA.debugLine="pageLabel.Initialize(\"pageLabel\")";
mostCurrent._pagelabel.Initialize(mostCurrent.activityBA,"pageLabel");
RDebugUtils.currentLine=3866734;
 //BA.debugLineNum = 3866734;BA.debugLine="pageLabel.TextColor =Colors.Black";
mostCurrent._pagelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866735;
 //BA.debugLineNum = 3866735;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=3866736;
 //BA.debugLineNum = 3866736;BA.debugLine="pageLabel.Gravity = Gravity.CENTER";
mostCurrent._pagelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3866737;
 //BA.debugLineNum = 3866737;BA.debugLine="pageLabel.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._pagelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=3866738;
 //BA.debugLineNum = 3866738;BA.debugLine="pageLabel.Color = Colors.white";
mostCurrent._pagelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3866739;
 //BA.debugLineNum = 3866739;BA.debugLine="pageLabel.TextSize = 15";
mostCurrent._pagelabel.setTextSize((float) (15));
RDebugUtils.currentLine=3866740;
 //BA.debugLineNum = 3866740;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=3866741;
 //BA.debugLineNum = 3866741;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866742;
 //BA.debugLineNum = 3866742;BA.debugLine="Panel3.AddView(pageLabel,backBtn.Width+backBtn";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._pagelabel.getObject()),(int) (_backbtn.getWidth()+_backbtn.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
RDebugUtils.currentLine=3866744;
 //BA.debugLineNum = 3866744;BA.debugLine="Dim nxtLabel As Label";
_nxtlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3866745;
 //BA.debugLineNum = 3866745;BA.debugLine="nxtLabel.Initialize(\"nxtLabel\")";
_nxtlabel.Initialize(mostCurrent.activityBA,"nxtLabel");
RDebugUtils.currentLine=3866746;
 //BA.debugLineNum = 3866746;BA.debugLine="nxtLabel.TextColor =Colors.White";
_nxtlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3866747;
 //BA.debugLineNum = 3866747;BA.debugLine="nxtLabel.Text = \">\"";
_nxtlabel.setText(BA.ObjectToCharSequence(">"));
RDebugUtils.currentLine=3866748;
 //BA.debugLineNum = 3866748;BA.debugLine="nxtLabel.Gravity = Gravity.CENTER";
_nxtlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3866749;
 //BA.debugLineNum = 3866749;BA.debugLine="nxtLabel.Typeface = Typeface.SERIF";
_nxtlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=3866750;
 //BA.debugLineNum = 3866750;BA.debugLine="nxtLabel.Color = Colors.black";
_nxtlabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3866751;
 //BA.debugLineNum = 3866751;BA.debugLine="nxtLabel.TextSize = 25";
_nxtlabel.setTextSize((float) (25));
RDebugUtils.currentLine=3866752;
 //BA.debugLineNum = 3866752;BA.debugLine="Panel3.AddView(nxtLabel,pageLabel.Width+pageLa";
mostCurrent._panel3.AddView((android.view.View)(_nxtlabel.getObject()),(int) (mostCurrent._pagelabel.getWidth()+mostCurrent._pagelabel.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=3866754;
 //BA.debugLineNum = 3866754;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=3866755;
 //BA.debugLineNum = 3866755;BA.debugLine="cd.Initialize2(Colors.Black, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3866756;
 //BA.debugLineNum = 3866756;BA.debugLine="backBtn.Background = cd";
_backbtn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=3866757;
 //BA.debugLineNum = 3866757;BA.debugLine="nxtLabel.Background = cd";
_nxtlabel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=3866761;
 //BA.debugLineNum = 3866761;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin ' Upda";
_ypos = (int) (_ypos+_itempanel.getHeight()+_margin);
RDebugUtils.currentLine=3866762;
 //BA.debugLineNum = 3866762;BA.debugLine="nxtLabel.Enabled = False";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866763;
 //BA.debugLineNum = 3866763;BA.debugLine="If limit * pageNo < totalDevices Then";
if (_limit*_pageno<_totaldevices) { 
RDebugUtils.currentLine=3866764;
 //BA.debugLineNum = 3866764;BA.debugLine="nxtLabel.Enabled = True";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3866768;
 //BA.debugLineNum = 3866768;BA.debugLine="TotalHeight = TotalHeight + 65dip";
_totalheight = (int) (_totalheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65)));
RDebugUtils.currentLine=3866769;
 //BA.debugLineNum = 3866769;BA.debugLine="ScrollView1.Panel.Height =TotalHeight";
mostCurrent._scrollview1.getPanel().setHeight(_totalheight);
RDebugUtils.currentLine=3866770;
 //BA.debugLineNum = 3866770;BA.debugLine="num = num +1";
_num = (int) (_num+1);
RDebugUtils.currentLine=3866771;
 //BA.debugLineNum = 3866771;BA.debugLine="TotalLabel.Text = \"\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=3866775;
 //BA.debugLineNum = 3866775;BA.debugLine="TotalLabel.RemoveView";
mostCurrent._totallabel.RemoveView();
RDebugUtils.currentLine=3866776;
 //BA.debugLineNum = 3866776;BA.debugLine="TotalLabel.TextColor =Colors.White";
mostCurrent._totallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3866777;
 //BA.debugLineNum = 3866777;BA.debugLine="TotalLabel.Text = num&\" out of \"&totalDevices&\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(BA.NumberToString(_num)+" out of "+BA.NumberToString(_totaldevices)+" devices"));
RDebugUtils.currentLine=3866778;
 //BA.debugLineNum = 3866778;BA.debugLine="TotalLabel.Gravity = Gravity.CENTER";
mostCurrent._totallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3866779;
 //BA.debugLineNum = 3866779;BA.debugLine="TotalLabel.Typeface = Typeface.MONOSPACE";
mostCurrent._totallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3866780;
 //BA.debugLineNum = 3866780;BA.debugLine="TotalLabel.Color = Colors.Transparent";
mostCurrent._totallabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=3866781;
 //BA.debugLineNum = 3866781;BA.debugLine="TotalLabel.TextSize = 15";
mostCurrent._totallabel.setTextSize((float) (15));
RDebugUtils.currentLine=3866783;
 //BA.debugLineNum = 3866783;BA.debugLine="Panel3.AddView(TotalLabel,Panel3.Width-240dip,5";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._totallabel.getObject()),(int) (mostCurrent._panel3.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (240))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (230)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 } 
       catch (Exception e136) {
			processBA.setLastException(e136); };
 }else {
RDebugUtils.currentLine=3866789;
 //BA.debugLineNum = 3866789;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3866792;
 //BA.debugLineNum = 3866792;BA.debugLine="End Sub";
return "";
}
public static String  _nxtlabel_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtlabel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtlabel_click", null));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Private Sub nxtLabel_Click";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="pageNo = pageNo + 1";
_pageno = (int) (_pageno+1);
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="End Sub";
return "";
}
}