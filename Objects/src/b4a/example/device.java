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
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Activity.LoadLayout(\"Device\")";
mostCurrent._activity.LoadLayout("Device",mostCurrent.activityBA);
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="ScrollView1.Width = 100%x";
mostCurrent._scrollview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="ScrollViewPanel.Initialize(\"\")";
mostCurrent._scrollviewpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._scrollviewpanel.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="TableDetails.Initialize";
mostCurrent._tabledetails.Initialize();
RDebugUtils.currentLine=3801107;
 //BA.debugLineNum = 3801107;BA.debugLine="Dim tableLabel As Panel";
_tablelabel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3801108;
 //BA.debugLineNum = 3801108;BA.debugLine="tableLabel.Initialize(\"deviceTitle\")";
_tablelabel.Initialize(mostCurrent.activityBA,"deviceTitle");
RDebugUtils.currentLine=3801109;
 //BA.debugLineNum = 3801109;BA.debugLine="tableLabel.Color = Colors.Black";
_tablelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3801110;
 //BA.debugLineNum = 3801110;BA.debugLine="Panel1.AddView(tableLabel, 0, Panel2.Height+Panel";
mostCurrent._panel1.AddView((android.view.View)(_tablelabel.getObject()),(int) (0),(int) (mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=3801112;
 //BA.debugLineNum = 3801112;BA.debugLine="ScrollView1.Top = tableLabel.Height + Panel2.Heig";
mostCurrent._scrollview1.setTop((int) (_tablelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=3801114;
 //BA.debugLineNum = 3801114;BA.debugLine="panelWidth = tableLabel.Width /6";
_panelwidth = (int) (_tablelabel.getWidth()/(double)6);
RDebugUtils.currentLine=3801116;
 //BA.debugLineNum = 3801116;BA.debugLine="Dim idLabel As Label";
_idlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801117;
 //BA.debugLineNum = 3801117;BA.debugLine="idLabel.Initialize(\"\")";
_idlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801118;
 //BA.debugLineNum = 3801118;BA.debugLine="idLabel.Text = \"ID\"";
_idlabel.setText(BA.ObjectToCharSequence("ID"));
RDebugUtils.currentLine=3801119;
 //BA.debugLineNum = 3801119;BA.debugLine="idLabel.TextColor= Colors.White";
_idlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3801120;
 //BA.debugLineNum = 3801120;BA.debugLine="idLabel.Gravity = Gravity.CENTER_VERTICAL";
_idlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3801121;
 //BA.debugLineNum = 3801121;BA.debugLine="idLabel.Typeface = Typeface.MONOSPACE";
_idlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801122;
 //BA.debugLineNum = 3801122;BA.debugLine="tableLabel.AddView(idLabel,tdleftPos,0dip,panelWi";
_tablelabel.AddView((android.view.View)(_idlabel.getObject()),_tdleftpos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3801124;
 //BA.debugLineNum = 3801124;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801125;
 //BA.debugLineNum = 3801125;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801126;
 //BA.debugLineNum = 3801126;BA.debugLine="deviceLabel.Text = \"NAME\"";
_devicelabel.setText(BA.ObjectToCharSequence("NAME"));
RDebugUtils.currentLine=3801127;
 //BA.debugLineNum = 3801127;BA.debugLine="deviceLabel.TextColor= Colors.White";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3801128;
 //BA.debugLineNum = 3801128;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3801129;
 //BA.debugLineNum = 3801129;BA.debugLine="deviceLabel.Typeface = Typeface.MONOSPACE";
_devicelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801130;
 //BA.debugLineNum = 3801130;BA.debugLine="tableLabel.AddView(deviceLabel,panelWidth,0,panel";
_tablelabel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3801132;
 //BA.debugLineNum = 3801132;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801133;
 //BA.debugLineNum = 3801133;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801134;
 //BA.debugLineNum = 3801134;BA.debugLine="serialLabel.Text = \"SERIAL NUMBER\"";
_seriallabel.setText(BA.ObjectToCharSequence("SERIAL NUMBER"));
RDebugUtils.currentLine=3801135;
 //BA.debugLineNum = 3801135;BA.debugLine="serialLabel.TextSize = 11";
_seriallabel.setTextSize((float) (11));
RDebugUtils.currentLine=3801136;
 //BA.debugLineNum = 3801136;BA.debugLine="serialLabel.TextColor= Colors.White";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3801137;
 //BA.debugLineNum = 3801137;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3801138;
 //BA.debugLineNum = 3801138;BA.debugLine="serialLabel.Typeface = Typeface.MONOSPACE";
_seriallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801139;
 //BA.debugLineNum = 3801139;BA.debugLine="tableLabel.AddView(serialLabel,panelWidth*2,0,pan";
_tablelabel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3801141;
 //BA.debugLineNum = 3801141;BA.debugLine="Dim sale1Label As Label";
_sale1label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801142;
 //BA.debugLineNum = 3801142;BA.debugLine="sale1Label.Initialize(\"\")";
_sale1label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801143;
 //BA.debugLineNum = 3801143;BA.debugLine="sale1Label.Text = \"FIRST SALE\"";
_sale1label.setText(BA.ObjectToCharSequence("FIRST SALE"));
RDebugUtils.currentLine=3801144;
 //BA.debugLineNum = 3801144;BA.debugLine="sale1Label.TextColor= Colors.White";
_sale1label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3801145;
 //BA.debugLineNum = 3801145;BA.debugLine="sale1Label.TextSize = 11";
_sale1label.setTextSize((float) (11));
RDebugUtils.currentLine=3801146;
 //BA.debugLineNum = 3801146;BA.debugLine="sale1Label.Gravity = Gravity.CENTER_VERTICAL";
_sale1label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3801147;
 //BA.debugLineNum = 3801147;BA.debugLine="sale1Label.Typeface = Typeface.MONOSPACE";
_sale1label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801148;
 //BA.debugLineNum = 3801148;BA.debugLine="tableLabel.AddView(sale1Label,panelWidth*3,0,pane";
_tablelabel.AddView((android.view.View)(_sale1label.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3801150;
 //BA.debugLineNum = 3801150;BA.debugLine="Dim sale2Label As Label";
_sale2label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801151;
 //BA.debugLineNum = 3801151;BA.debugLine="sale2Label.Initialize(\"\")";
_sale2label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801152;
 //BA.debugLineNum = 3801152;BA.debugLine="sale2Label.Text = \"SECOND SALE\"";
_sale2label.setText(BA.ObjectToCharSequence("SECOND SALE"));
RDebugUtils.currentLine=3801153;
 //BA.debugLineNum = 3801153;BA.debugLine="sale2Label.TextColor= Colors.White";
_sale2label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3801154;
 //BA.debugLineNum = 3801154;BA.debugLine="sale2Label.TextSize = 11";
_sale2label.setTextSize((float) (11));
RDebugUtils.currentLine=3801155;
 //BA.debugLineNum = 3801155;BA.debugLine="sale2Label.Gravity = Gravity.CENTER_VERTICAL";
_sale2label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3801156;
 //BA.debugLineNum = 3801156;BA.debugLine="sale2Label.Typeface = Typeface.MONOSPACE";
_sale2label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801157;
 //BA.debugLineNum = 3801157;BA.debugLine="tableLabel.AddView(sale2Label,panelWidth*4,0,pane";
_tablelabel.AddView((android.view.View)(_sale2label.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3801159;
 //BA.debugLineNum = 3801159;BA.debugLine="Dim sale3Label As Label";
_sale3label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801160;
 //BA.debugLineNum = 3801160;BA.debugLine="sale3Label.Initialize(\"\")";
_sale3label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801161;
 //BA.debugLineNum = 3801161;BA.debugLine="sale3Label.Text = \"THIRD SALE\"";
_sale3label.setText(BA.ObjectToCharSequence("THIRD SALE"));
RDebugUtils.currentLine=3801162;
 //BA.debugLineNum = 3801162;BA.debugLine="sale3Label.TextSize = 11";
_sale3label.setTextSize((float) (11));
RDebugUtils.currentLine=3801163;
 //BA.debugLineNum = 3801163;BA.debugLine="sale3Label.TextColor= Colors.White";
_sale3label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3801164;
 //BA.debugLineNum = 3801164;BA.debugLine="sale3Label.Gravity = Gravity.CENTER_VERTICAL";
_sale3label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3801165;
 //BA.debugLineNum = 3801165;BA.debugLine="sale3Label.Typeface = Typeface.MONOSPACE";
_sale3label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801166;
 //BA.debugLineNum = 3801166;BA.debugLine="tableLabel.AddView(sale3Label,panelWidth*5,0,pane";
_tablelabel.AddView((android.view.View)(_sale3label.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=3801169;
 //BA.debugLineNum = 3801169;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=3801170;
 //BA.debugLineNum = 3801170;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=3801171;
 //BA.debugLineNum = 3801171;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3801172;
 //BA.debugLineNum = 3801172;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801173;
 //BA.debugLineNum = 3801173;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3801174;
 //BA.debugLineNum = 3801174;BA.debugLine="home.TextSize = 16 '";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=3801175;
 //BA.debugLineNum = 3801175;BA.debugLine="Panel4.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=3801176;
 //BA.debugLineNum = 3801176;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=3801178;
 //BA.debugLineNum = 3801178;BA.debugLine="branches.Initialize(\"branch\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"branch");
RDebugUtils.currentLine=3801179;
 //BA.debugLineNum = 3801179;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=3801180;
 //BA.debugLineNum = 3801180;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801181;
 //BA.debugLineNum = 3801181;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3801182;
 //BA.debugLineNum = 3801182;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=3801183;
 //BA.debugLineNum = 3801183;BA.debugLine="branches.TextColor = Colors.Black";
mostCurrent._branches.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3801184;
 //BA.debugLineNum = 3801184;BA.debugLine="Panel4.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (210)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=3801187;
 //BA.debugLineNum = 3801187;BA.debugLine="devices.Initialize(\"device\")";
mostCurrent._devices.Initialize(mostCurrent.activityBA,"device");
RDebugUtils.currentLine=3801188;
 //BA.debugLineNum = 3801188;BA.debugLine="devices.Text = \"Devices\"";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices"));
RDebugUtils.currentLine=3801189;
 //BA.debugLineNum = 3801189;BA.debugLine="devices.Typeface = Typeface.MONOSPACE";
mostCurrent._devices.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3801190;
 //BA.debugLineNum = 3801190;BA.debugLine="devices.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._devices.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3801191;
 //BA.debugLineNum = 3801191;BA.debugLine="devices.TextSize = 16";
mostCurrent._devices.setTextSize((float) (16));
RDebugUtils.currentLine=3801192;
 //BA.debugLineNum = 3801192;BA.debugLine="Panel4.AddView(devices, branches.Left + branches.";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._devices.getObject()),(int) (mostCurrent._branches.getLeft()+mostCurrent._branches.getWidth()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=3801193;
 //BA.debugLineNum = 3801193;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=3801195;
 //BA.debugLineNum = 3801195;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=3801196;
 //BA.debugLineNum = 3801196;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=3801197;
 //BA.debugLineNum = 3801197;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=3801199;
 //BA.debugLineNum = 3801199;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=3801200;
 //BA.debugLineNum = 3801200;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Log(PHPURL)";
anywheresoftware.b4a.keywords.Common.LogImpl("63932162",mostCurrent._phpurl,0);
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="Job1.Initialize(\"\", Me)";
_job1._initialize /*String*/ (null,processBA,"",device.getObject());
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="device";
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Private Sub backBtn_Click";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="If pageNo > 1 Then";
if (_pageno>1) { 
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="pageNo = pageNo - 1";
_pageno = (int) (_pageno-1);
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="num = 1";
_num = (int) (1);
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 };
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="End Sub";
return "";
}
public static String  _branch_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "branch_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "branch_click", null));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Private Sub branch_Click";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="Try";
try {RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="ScrollViewPanel.RemoveAllViews";
mostCurrent._scrollviewpanel.RemoveAllViews();
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="Dim YPos As Int = 0";
_ypos = (int) (0);
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="Dim Margin As Int = 0dip";
_margin = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0));
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="Dim TotalHeight As Int = 0";
_totalheight = (int) (0);
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="Dim totalDevices As Int = 0";
_totaldevices = (int) (0);
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="YPos = YPos + 0%y + Margin";
_ypos = (int) (_ypos+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA)+_margin);
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="Dim tdFontSize As Int = 13";
_tdfontsize = (int) (13);
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="TotalLabel.Initialize(\"TotalLabel\")";
mostCurrent._totallabel.Initialize(mostCurrent.activityBA,"TotalLabel");
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group16 = mostCurrent._tabledetails;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group16.Get(index16)));
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="Dim serial_num As String = record.Get(\"serial\"";
_serial_num = BA.ObjectToString(_record.Get((Object)("serial")));
RDebugUtils.currentLine=4128788;
 //BA.debugLineNum = 4128788;BA.debugLine="Dim sales1 As String = record.Get(\"sales1\")";
_sales1 = BA.ObjectToString(_record.Get((Object)("sales1")));
RDebugUtils.currentLine=4128789;
 //BA.debugLineNum = 4128789;BA.debugLine="Dim sales2 As String = record.Get(\"sales2\")";
_sales2 = BA.ObjectToString(_record.Get((Object)("sales2")));
RDebugUtils.currentLine=4128790;
 //BA.debugLineNum = 4128790;BA.debugLine="Dim sales3 As String = record.Get(\"sales3\")";
_sales3 = BA.ObjectToString(_record.Get((Object)("sales3")));
RDebugUtils.currentLine=4128792;
 //BA.debugLineNum = 4128792;BA.debugLine="Dim id As Int = 0";
_id = (int) (0);
RDebugUtils.currentLine=4128793;
 //BA.debugLineNum = 4128793;BA.debugLine="totalDevices = record.Get(\"totalDevices\")";
_totaldevices = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=4128794;
 //BA.debugLineNum = 4128794;BA.debugLine="Dim comName As String = record.Get(\"comName\")";
_comname = BA.ObjectToString(_record.Get((Object)("comName")));
RDebugUtils.currentLine=4128795;
 //BA.debugLineNum = 4128795;BA.debugLine="LabelTitle.Text = record.Get(\"branchName\")";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_record.Get((Object)("branchName"))));
RDebugUtils.currentLine=4128796;
 //BA.debugLineNum = 4128796;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCase";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=4128798;
 //BA.debugLineNum = 4128798;BA.debugLine="Label1.Text = comName";
mostCurrent._label1.setText(BA.ObjectToCharSequence(_comname));
RDebugUtils.currentLine=4128799;
 //BA.debugLineNum = 4128799;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=4128801;
 //BA.debugLineNum = 4128801;BA.debugLine="branches.Text = \"Branches - \"&comName&\" |\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_comname+" |"));
RDebugUtils.currentLine=4128802;
 //BA.debugLineNum = 4128802;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=4128804;
 //BA.debugLineNum = 4128804;BA.debugLine="devices.Text = \"Devices - \"&record.Get(\"branch";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices - "+BA.ObjectToString(_record.Get((Object)("branchName")))));
RDebugUtils.currentLine=4128805;
 //BA.debugLineNum = 4128805;BA.debugLine="devices.Text = devices.Text.ToUpperCase";
mostCurrent._devices.setText(BA.ObjectToCharSequence(mostCurrent._devices.getText().toUpperCase()));
RDebugUtils.currentLine=4128807;
 //BA.debugLineNum = 4128807;BA.debugLine="Dim ItemPanel As Panel";
_itempanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4128808;
 //BA.debugLineNum = 4128808;BA.debugLine="ItemPanel.Initialize(\"\")";
_itempanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128809;
 //BA.debugLineNum = 4128809;BA.debugLine="ItemPanel.SetLayout(0, YPos, ScrollView1.Width";
_itempanel.SetLayout((int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
RDebugUtils.currentLine=4128810;
 //BA.debugLineNum = 4128810;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_itempanel.getObject()),(int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=4128811;
 //BA.debugLineNum = 4128811;BA.debugLine="panelWidth = ItemPanel.Width /6";
_panelwidth = (int) (_itempanel.getWidth()/(double)6);
RDebugUtils.currentLine=4128812;
 //BA.debugLineNum = 4128812;BA.debugLine="If num Mod 2 = 0 Then";
if (_num%2==0) { 
RDebugUtils.currentLine=4128813;
 //BA.debugLineNum = 4128813;BA.debugLine="ItemPanel.Color = Colors.LightGray";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 }else {
RDebugUtils.currentLine=4128815;
 //BA.debugLineNum = 4128815;BA.debugLine="ItemPanel.Color = Colors.ARGB(255, 251, 251,";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
 };
RDebugUtils.currentLine=4128818;
 //BA.debugLineNum = 4128818;BA.debugLine="Dim number As Label";
_number = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128819;
 //BA.debugLineNum = 4128819;BA.debugLine="number.Initialize(\"\")";
_number.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128820;
 //BA.debugLineNum = 4128820;BA.debugLine="number.Text = id";
_number.setText(BA.ObjectToCharSequence(_id));
RDebugUtils.currentLine=4128821;
 //BA.debugLineNum = 4128821;BA.debugLine="number.TextSize = tdFontSize";
_number.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4128822;
 //BA.debugLineNum = 4128822;BA.debugLine="number.TextColor = Colors.Black";
_number.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128823;
 //BA.debugLineNum = 4128823;BA.debugLine="number.Gravity = Gravity.CENTER_VERTICAL";
_number.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128824;
 //BA.debugLineNum = 4128824;BA.debugLine="number.Typeface = Typeface.MONOSPACE";
_number.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4128825;
 //BA.debugLineNum = 4128825;BA.debugLine="ItemPanel.AddView(number, tdleftPos, 0, panelW";
_itempanel.AddView((android.view.View)(_number.getObject()),_tdleftpos,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4128827;
 //BA.debugLineNum = 4128827;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128828;
 //BA.debugLineNum = 4128828;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128829;
 //BA.debugLineNum = 4128829;BA.debugLine="deviceLabel.Text = \"Pos0\"&id";
_devicelabel.setText(BA.ObjectToCharSequence("Pos0"+BA.NumberToString(_id)));
RDebugUtils.currentLine=4128830;
 //BA.debugLineNum = 4128830;BA.debugLine="deviceLabel.TextSize = tdFontSize";
_devicelabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4128831;
 //BA.debugLineNum = 4128831;BA.debugLine="deviceLabel.TextColor = Colors.Black";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128832;
 //BA.debugLineNum = 4128832;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128833;
 //BA.debugLineNum = 4128833;BA.debugLine="ItemPanel.AddView(deviceLabel, panelWidth, 0,";
_itempanel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4128835;
 //BA.debugLineNum = 4128835;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128836;
 //BA.debugLineNum = 4128836;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128837;
 //BA.debugLineNum = 4128837;BA.debugLine="serialLabel.Text = serial_num";
_seriallabel.setText(BA.ObjectToCharSequence(_serial_num));
RDebugUtils.currentLine=4128838;
 //BA.debugLineNum = 4128838;BA.debugLine="serialLabel.TextSize = tdFontSize";
_seriallabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4128839;
 //BA.debugLineNum = 4128839;BA.debugLine="serialLabel.TextColor = Colors.Black";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128840;
 //BA.debugLineNum = 4128840;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128841;
 //BA.debugLineNum = 4128841;BA.debugLine="ItemPanel.AddView(serialLabel, panelWidth*2, 0";
_itempanel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4128843;
 //BA.debugLineNum = 4128843;BA.debugLine="Dim sale As Label";
_sale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128844;
 //BA.debugLineNum = 4128844;BA.debugLine="sale.Initialize(\"\")";
_sale.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128845;
 //BA.debugLineNum = 4128845;BA.debugLine="sale.Text = sales1";
_sale.setText(BA.ObjectToCharSequence(_sales1));
RDebugUtils.currentLine=4128846;
 //BA.debugLineNum = 4128846;BA.debugLine="sale.TextSize = tdFontSize";
_sale.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4128847;
 //BA.debugLineNum = 4128847;BA.debugLine="sale.TextColor = Colors.Black";
_sale.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128848;
 //BA.debugLineNum = 4128848;BA.debugLine="sale.Gravity = Gravity.CENTER_VERTICAL";
_sale.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128849;
 //BA.debugLineNum = 4128849;BA.debugLine="ItemPanel.AddView(sale, panelWidth*3, 0, panel";
_itempanel.AddView((android.view.View)(_sale.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4128851;
 //BA.debugLineNum = 4128851;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128852;
 //BA.debugLineNum = 4128852;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128853;
 //BA.debugLineNum = 4128853;BA.debugLine="sale1.Text = sales2";
_sale1.setText(BA.ObjectToCharSequence(_sales2));
RDebugUtils.currentLine=4128854;
 //BA.debugLineNum = 4128854;BA.debugLine="sale1.TextSize = tdFontSize";
_sale1.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4128855;
 //BA.debugLineNum = 4128855;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128856;
 //BA.debugLineNum = 4128856;BA.debugLine="sale1.Gravity = Gravity.CENTER_VERTICAL";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128857;
 //BA.debugLineNum = 4128857;BA.debugLine="ItemPanel.AddView(sale1, panelWidth*4, 0, pane";
_itempanel.AddView((android.view.View)(_sale1.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4128859;
 //BA.debugLineNum = 4128859;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128860;
 //BA.debugLineNum = 4128860;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128861;
 //BA.debugLineNum = 4128861;BA.debugLine="sale2.Text = sales3";
_sale2.setText(BA.ObjectToCharSequence(_sales3));
RDebugUtils.currentLine=4128862;
 //BA.debugLineNum = 4128862;BA.debugLine="sale2.TextSize = tdFontSize";
_sale2.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4128863;
 //BA.debugLineNum = 4128863;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128864;
 //BA.debugLineNum = 4128864;BA.debugLine="sale2.Gravity = Gravity.CENTER_VERTICAL";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128865;
 //BA.debugLineNum = 4128865;BA.debugLine="ItemPanel.AddView(sale2, panelWidth*5, 0, pane";
_itempanel.AddView((android.view.View)(_sale2.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4128867;
 //BA.debugLineNum = 4128867;BA.debugLine="Dim backBtn As Label";
_backbtn = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128868;
 //BA.debugLineNum = 4128868;BA.debugLine="backBtn.Initialize(\"backBtn\")";
_backbtn.Initialize(mostCurrent.activityBA,"backBtn");
RDebugUtils.currentLine=4128869;
 //BA.debugLineNum = 4128869;BA.debugLine="backBtn.TextColor =Colors.White";
_backbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4128870;
 //BA.debugLineNum = 4128870;BA.debugLine="backBtn.Text = \"<\"";
_backbtn.setText(BA.ObjectToCharSequence("<"));
RDebugUtils.currentLine=4128871;
 //BA.debugLineNum = 4128871;BA.debugLine="backBtn.Gravity = Gravity.CENTER";
_backbtn.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4128872;
 //BA.debugLineNum = 4128872;BA.debugLine="backBtn.Typeface = Typeface.SERIF";
_backbtn.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=4128873;
 //BA.debugLineNum = 4128873;BA.debugLine="backBtn.Color = Colors.Black";
_backbtn.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128874;
 //BA.debugLineNum = 4128874;BA.debugLine="backBtn.TextSize = 25";
_backbtn.setTextSize((float) (25));
RDebugUtils.currentLine=4128875;
 //BA.debugLineNum = 4128875;BA.debugLine="Panel3.AddView(backBtn,3dip,5dip,50dip,Panel3.";
mostCurrent._panel3.AddView((android.view.View)(_backbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=4128877;
 //BA.debugLineNum = 4128877;BA.debugLine="pageLabel.Initialize(\"pageLabel\")";
mostCurrent._pagelabel.Initialize(mostCurrent.activityBA,"pageLabel");
RDebugUtils.currentLine=4128878;
 //BA.debugLineNum = 4128878;BA.debugLine="pageLabel.TextColor =Colors.Black";
mostCurrent._pagelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128879;
 //BA.debugLineNum = 4128879;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=4128880;
 //BA.debugLineNum = 4128880;BA.debugLine="pageLabel.Gravity = Gravity.CENTER";
mostCurrent._pagelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4128881;
 //BA.debugLineNum = 4128881;BA.debugLine="pageLabel.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._pagelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=4128882;
 //BA.debugLineNum = 4128882;BA.debugLine="pageLabel.Color = Colors.white";
mostCurrent._pagelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4128883;
 //BA.debugLineNum = 4128883;BA.debugLine="pageLabel.TextSize = 15";
mostCurrent._pagelabel.setTextSize((float) (15));
RDebugUtils.currentLine=4128884;
 //BA.debugLineNum = 4128884;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4128885;
 //BA.debugLineNum = 4128885;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128886;
 //BA.debugLineNum = 4128886;BA.debugLine="Panel3.AddView(pageLabel,backBtn.Width+backBtn";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._pagelabel.getObject()),(int) (_backbtn.getWidth()+_backbtn.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
RDebugUtils.currentLine=4128888;
 //BA.debugLineNum = 4128888;BA.debugLine="Dim nxtLabel As Label";
_nxtlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128889;
 //BA.debugLineNum = 4128889;BA.debugLine="nxtLabel.Initialize(\"nxtLabel\")";
_nxtlabel.Initialize(mostCurrent.activityBA,"nxtLabel");
RDebugUtils.currentLine=4128890;
 //BA.debugLineNum = 4128890;BA.debugLine="nxtLabel.TextColor =Colors.White";
_nxtlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4128891;
 //BA.debugLineNum = 4128891;BA.debugLine="nxtLabel.Text = \">\"";
_nxtlabel.setText(BA.ObjectToCharSequence(">"));
RDebugUtils.currentLine=4128892;
 //BA.debugLineNum = 4128892;BA.debugLine="nxtLabel.Gravity = Gravity.CENTER";
_nxtlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4128893;
 //BA.debugLineNum = 4128893;BA.debugLine="nxtLabel.Typeface = Typeface.SERIF";
_nxtlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=4128894;
 //BA.debugLineNum = 4128894;BA.debugLine="nxtLabel.Color = Colors.black";
_nxtlabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128895;
 //BA.debugLineNum = 4128895;BA.debugLine="nxtLabel.TextSize = 25";
_nxtlabel.setTextSize((float) (25));
RDebugUtils.currentLine=4128896;
 //BA.debugLineNum = 4128896;BA.debugLine="Panel3.AddView(nxtLabel,pageLabel.Width+pageLa";
mostCurrent._panel3.AddView((android.view.View)(_nxtlabel.getObject()),(int) (mostCurrent._pagelabel.getWidth()+mostCurrent._pagelabel.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=4128898;
 //BA.debugLineNum = 4128898;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4128899;
 //BA.debugLineNum = 4128899;BA.debugLine="cd.Initialize2(Colors.Black, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4128900;
 //BA.debugLineNum = 4128900;BA.debugLine="backBtn.Background = cd";
_backbtn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=4128901;
 //BA.debugLineNum = 4128901;BA.debugLine="nxtLabel.Background = cd";
_nxtlabel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=4128905;
 //BA.debugLineNum = 4128905;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin ' Upda";
_ypos = (int) (_ypos+_itempanel.getHeight()+_margin);
RDebugUtils.currentLine=4128906;
 //BA.debugLineNum = 4128906;BA.debugLine="nxtLabel.Enabled = False";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128907;
 //BA.debugLineNum = 4128907;BA.debugLine="If limit * pageNo < totalDevices Then";
if (_limit*_pageno<_totaldevices) { 
RDebugUtils.currentLine=4128908;
 //BA.debugLineNum = 4128908;BA.debugLine="nxtLabel.Enabled = True";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4128912;
 //BA.debugLineNum = 4128912;BA.debugLine="TotalHeight = TotalHeight + 65dip";
_totalheight = (int) (_totalheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65)));
RDebugUtils.currentLine=4128913;
 //BA.debugLineNum = 4128913;BA.debugLine="ScrollView1.Panel.Height =TotalHeight";
mostCurrent._scrollview1.getPanel().setHeight(_totalheight);
RDebugUtils.currentLine=4128914;
 //BA.debugLineNum = 4128914;BA.debugLine="num = num +1";
_num = (int) (_num+1);
RDebugUtils.currentLine=4128915;
 //BA.debugLineNum = 4128915;BA.debugLine="TotalLabel.Text = \"\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=4128919;
 //BA.debugLineNum = 4128919;BA.debugLine="TotalLabel.RemoveView";
mostCurrent._totallabel.RemoveView();
RDebugUtils.currentLine=4128920;
 //BA.debugLineNum = 4128920;BA.debugLine="TotalLabel.TextColor =Colors.White";
mostCurrent._totallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4128921;
 //BA.debugLineNum = 4128921;BA.debugLine="TotalLabel.Text = num&\" out of \"&totalDevices&\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(BA.NumberToString(_num)+" out of "+BA.NumberToString(_totaldevices)+" devices"));
RDebugUtils.currentLine=4128922;
 //BA.debugLineNum = 4128922;BA.debugLine="TotalLabel.Gravity = Gravity.CENTER";
mostCurrent._totallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4128923;
 //BA.debugLineNum = 4128923;BA.debugLine="TotalLabel.Typeface = Typeface.MONOSPACE";
mostCurrent._totallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4128924;
 //BA.debugLineNum = 4128924;BA.debugLine="TotalLabel.Color = Colors.Transparent";
mostCurrent._totallabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=4128925;
 //BA.debugLineNum = 4128925;BA.debugLine="TotalLabel.TextSize = 15";
mostCurrent._totallabel.setTextSize((float) (15));
RDebugUtils.currentLine=4128927;
 //BA.debugLineNum = 4128927;BA.debugLine="Panel3.AddView(TotalLabel,Panel3.Width-240dip,5";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._totallabel.getObject()),(int) (mostCurrent._panel3.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (240))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (230)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 } 
       catch (Exception e136) {
			processBA.setLastException(e136); };
 }else {
RDebugUtils.currentLine=4128933;
 //BA.debugLineNum = 4128933;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4128936;
 //BA.debugLineNum = 4128936;BA.debugLine="End Sub";
return "";
}
public static String  _nxtlabel_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtlabel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtlabel_click", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub nxtLabel_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="pageNo = pageNo + 1";
_pageno = (int) (_pageno+1);
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="End Sub";
return "";
}
}