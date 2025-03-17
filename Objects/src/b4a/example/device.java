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
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Activity.LoadLayout(\"Device\")";
mostCurrent._activity.LoadLayout("Device",mostCurrent.activityBA);
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="ScrollView1.Width = 100%x";
mostCurrent._scrollview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="ScrollViewPanel.Initialize(\"\")";
mostCurrent._scrollviewpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._scrollviewpanel.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="TableDetails.Initialize";
mostCurrent._tabledetails.Initialize();
RDebugUtils.currentLine=4194323;
 //BA.debugLineNum = 4194323;BA.debugLine="Dim tableLabel As Panel";
_tablelabel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4194324;
 //BA.debugLineNum = 4194324;BA.debugLine="tableLabel.Initialize(\"deviceTitle\")";
_tablelabel.Initialize(mostCurrent.activityBA,"deviceTitle");
RDebugUtils.currentLine=4194325;
 //BA.debugLineNum = 4194325;BA.debugLine="tableLabel.Color = Colors.Black";
_tablelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4194326;
 //BA.debugLineNum = 4194326;BA.debugLine="Panel1.AddView(tableLabel, 0, Panel2.Height+Panel";
mostCurrent._panel1.AddView((android.view.View)(_tablelabel.getObject()),(int) (0),(int) (mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=4194328;
 //BA.debugLineNum = 4194328;BA.debugLine="ScrollView1.Top = tableLabel.Height + Panel2.Heig";
mostCurrent._scrollview1.setTop((int) (_tablelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=4194330;
 //BA.debugLineNum = 4194330;BA.debugLine="panelWidth = tableLabel.Width /6";
_panelwidth = (int) (_tablelabel.getWidth()/(double)6);
RDebugUtils.currentLine=4194332;
 //BA.debugLineNum = 4194332;BA.debugLine="Dim idLabel As Label";
_idlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4194333;
 //BA.debugLineNum = 4194333;BA.debugLine="idLabel.Initialize(\"\")";
_idlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4194334;
 //BA.debugLineNum = 4194334;BA.debugLine="idLabel.Text = \"ID\"";
_idlabel.setText(BA.ObjectToCharSequence("ID"));
RDebugUtils.currentLine=4194335;
 //BA.debugLineNum = 4194335;BA.debugLine="idLabel.TextColor= Colors.White";
_idlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4194336;
 //BA.debugLineNum = 4194336;BA.debugLine="idLabel.Gravity = Gravity.CENTER_VERTICAL";
_idlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4194337;
 //BA.debugLineNum = 4194337;BA.debugLine="idLabel.Typeface = Typeface.MONOSPACE";
_idlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194338;
 //BA.debugLineNum = 4194338;BA.debugLine="tableLabel.AddView(idLabel,tdleftPos,0dip,panelWi";
_tablelabel.AddView((android.view.View)(_idlabel.getObject()),_tdleftpos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=4194340;
 //BA.debugLineNum = 4194340;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4194341;
 //BA.debugLineNum = 4194341;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4194342;
 //BA.debugLineNum = 4194342;BA.debugLine="deviceLabel.Text = \"NAME\"";
_devicelabel.setText(BA.ObjectToCharSequence("NAME"));
RDebugUtils.currentLine=4194343;
 //BA.debugLineNum = 4194343;BA.debugLine="deviceLabel.TextColor= Colors.White";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4194344;
 //BA.debugLineNum = 4194344;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4194345;
 //BA.debugLineNum = 4194345;BA.debugLine="deviceLabel.Typeface = Typeface.MONOSPACE";
_devicelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194346;
 //BA.debugLineNum = 4194346;BA.debugLine="tableLabel.AddView(deviceLabel,panelWidth,0,panel";
_tablelabel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=4194348;
 //BA.debugLineNum = 4194348;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4194349;
 //BA.debugLineNum = 4194349;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4194350;
 //BA.debugLineNum = 4194350;BA.debugLine="serialLabel.Text = \"SERIAL NUMBER\"";
_seriallabel.setText(BA.ObjectToCharSequence("SERIAL NUMBER"));
RDebugUtils.currentLine=4194351;
 //BA.debugLineNum = 4194351;BA.debugLine="serialLabel.TextSize = 11";
_seriallabel.setTextSize((float) (11));
RDebugUtils.currentLine=4194352;
 //BA.debugLineNum = 4194352;BA.debugLine="serialLabel.TextColor= Colors.White";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4194353;
 //BA.debugLineNum = 4194353;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4194354;
 //BA.debugLineNum = 4194354;BA.debugLine="serialLabel.Typeface = Typeface.MONOSPACE";
_seriallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194355;
 //BA.debugLineNum = 4194355;BA.debugLine="tableLabel.AddView(serialLabel,panelWidth*2,0,pan";
_tablelabel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=4194357;
 //BA.debugLineNum = 4194357;BA.debugLine="Dim sale1Label As Label";
_sale1label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4194358;
 //BA.debugLineNum = 4194358;BA.debugLine="sale1Label.Initialize(\"\")";
_sale1label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4194359;
 //BA.debugLineNum = 4194359;BA.debugLine="sale1Label.Text = \"FIRST SALE\"";
_sale1label.setText(BA.ObjectToCharSequence("FIRST SALE"));
RDebugUtils.currentLine=4194360;
 //BA.debugLineNum = 4194360;BA.debugLine="sale1Label.TextColor= Colors.White";
_sale1label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4194361;
 //BA.debugLineNum = 4194361;BA.debugLine="sale1Label.TextSize = 11";
_sale1label.setTextSize((float) (11));
RDebugUtils.currentLine=4194362;
 //BA.debugLineNum = 4194362;BA.debugLine="sale1Label.Gravity = Gravity.CENTER_VERTICAL";
_sale1label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4194363;
 //BA.debugLineNum = 4194363;BA.debugLine="sale1Label.Typeface = Typeface.MONOSPACE";
_sale1label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194364;
 //BA.debugLineNum = 4194364;BA.debugLine="tableLabel.AddView(sale1Label,panelWidth*3,0,pane";
_tablelabel.AddView((android.view.View)(_sale1label.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=4194366;
 //BA.debugLineNum = 4194366;BA.debugLine="Dim sale2Label As Label";
_sale2label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4194367;
 //BA.debugLineNum = 4194367;BA.debugLine="sale2Label.Initialize(\"\")";
_sale2label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4194368;
 //BA.debugLineNum = 4194368;BA.debugLine="sale2Label.Text = \"SECOND SALE\"";
_sale2label.setText(BA.ObjectToCharSequence("SECOND SALE"));
RDebugUtils.currentLine=4194369;
 //BA.debugLineNum = 4194369;BA.debugLine="sale2Label.TextColor= Colors.White";
_sale2label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4194370;
 //BA.debugLineNum = 4194370;BA.debugLine="sale2Label.TextSize = 11";
_sale2label.setTextSize((float) (11));
RDebugUtils.currentLine=4194371;
 //BA.debugLineNum = 4194371;BA.debugLine="sale2Label.Gravity = Gravity.CENTER_VERTICAL";
_sale2label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4194372;
 //BA.debugLineNum = 4194372;BA.debugLine="sale2Label.Typeface = Typeface.MONOSPACE";
_sale2label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194373;
 //BA.debugLineNum = 4194373;BA.debugLine="tableLabel.AddView(sale2Label,panelWidth*4,0,pane";
_tablelabel.AddView((android.view.View)(_sale2label.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=4194375;
 //BA.debugLineNum = 4194375;BA.debugLine="Dim sale3Label As Label";
_sale3label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4194376;
 //BA.debugLineNum = 4194376;BA.debugLine="sale3Label.Initialize(\"\")";
_sale3label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4194377;
 //BA.debugLineNum = 4194377;BA.debugLine="sale3Label.Text = \"THIRD SALE\"";
_sale3label.setText(BA.ObjectToCharSequence("THIRD SALE"));
RDebugUtils.currentLine=4194378;
 //BA.debugLineNum = 4194378;BA.debugLine="sale3Label.TextSize = 11";
_sale3label.setTextSize((float) (11));
RDebugUtils.currentLine=4194379;
 //BA.debugLineNum = 4194379;BA.debugLine="sale3Label.TextColor= Colors.White";
_sale3label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4194380;
 //BA.debugLineNum = 4194380;BA.debugLine="sale3Label.Gravity = Gravity.CENTER_VERTICAL";
_sale3label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4194381;
 //BA.debugLineNum = 4194381;BA.debugLine="sale3Label.Typeface = Typeface.MONOSPACE";
_sale3label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194382;
 //BA.debugLineNum = 4194382;BA.debugLine="tableLabel.AddView(sale3Label,panelWidth*5,0,pane";
_tablelabel.AddView((android.view.View)(_sale3label.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=4194385;
 //BA.debugLineNum = 4194385;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=4194386;
 //BA.debugLineNum = 4194386;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=4194387;
 //BA.debugLineNum = 4194387;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4194388;
 //BA.debugLineNum = 4194388;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194389;
 //BA.debugLineNum = 4194389;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4194390;
 //BA.debugLineNum = 4194390;BA.debugLine="home.TextSize = 16 '";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=4194391;
 //BA.debugLineNum = 4194391;BA.debugLine="Panel4.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=4194392;
 //BA.debugLineNum = 4194392;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=4194394;
 //BA.debugLineNum = 4194394;BA.debugLine="branches.Initialize(\"branch\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"branch");
RDebugUtils.currentLine=4194395;
 //BA.debugLineNum = 4194395;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=4194396;
 //BA.debugLineNum = 4194396;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194397;
 //BA.debugLineNum = 4194397;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4194398;
 //BA.debugLineNum = 4194398;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=4194399;
 //BA.debugLineNum = 4194399;BA.debugLine="branches.TextColor = Colors.Black";
mostCurrent._branches.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4194400;
 //BA.debugLineNum = 4194400;BA.debugLine="Panel4.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (210)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=4194403;
 //BA.debugLineNum = 4194403;BA.debugLine="devices.Initialize(\"device\")";
mostCurrent._devices.Initialize(mostCurrent.activityBA,"device");
RDebugUtils.currentLine=4194404;
 //BA.debugLineNum = 4194404;BA.debugLine="devices.Text = \"Devices\"";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices"));
RDebugUtils.currentLine=4194405;
 //BA.debugLineNum = 4194405;BA.debugLine="devices.Typeface = Typeface.MONOSPACE";
mostCurrent._devices.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4194406;
 //BA.debugLineNum = 4194406;BA.debugLine="devices.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._devices.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4194407;
 //BA.debugLineNum = 4194407;BA.debugLine="devices.TextSize = 16";
mostCurrent._devices.setTextSize((float) (16));
RDebugUtils.currentLine=4194408;
 //BA.debugLineNum = 4194408;BA.debugLine="Panel4.AddView(devices, branches.Left + branches.";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._devices.getObject()),(int) (mostCurrent._branches.getLeft()+mostCurrent._branches.getWidth()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=4194409;
 //BA.debugLineNum = 4194409;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=4194411;
 //BA.debugLineNum = 4194411;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=4194412;
 //BA.debugLineNum = 4194412;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=4194413;
 //BA.debugLineNum = 4194413;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=4194415;
 //BA.debugLineNum = 4194415;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=4194416;
 //BA.debugLineNum = 4194416;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Log(PHPURL)";
anywheresoftware.b4a.keywords.Common.LogImpl("74325378",mostCurrent._phpurl,0);
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Job1.Initialize(\"\", Me)";
_job1._initialize /*String*/ (null,processBA,"",device.getObject());
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="device";
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Private Sub backBtn_Click";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="If pageNo > 1 Then";
if (_pageno>1) { 
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="pageNo = pageNo - 1";
_pageno = (int) (_pageno-1);
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="num = 1";
_num = (int) (1);
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 };
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="End Sub";
return "";
}
public static String  _branch_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "branch_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "branch_click", null));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Private Sub branch_Click";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="Try";
try {RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=4521989;
 //BA.debugLineNum = 4521989;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=4521992;
 //BA.debugLineNum = 4521992;BA.debugLine="ScrollViewPanel.RemoveAllViews";
mostCurrent._scrollviewpanel.RemoveAllViews();
RDebugUtils.currentLine=4521993;
 //BA.debugLineNum = 4521993;BA.debugLine="Dim YPos As Int = 0";
_ypos = (int) (0);
RDebugUtils.currentLine=4521994;
 //BA.debugLineNum = 4521994;BA.debugLine="Dim Margin As Int = 0dip";
_margin = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0));
RDebugUtils.currentLine=4521995;
 //BA.debugLineNum = 4521995;BA.debugLine="Dim TotalHeight As Int = 0";
_totalheight = (int) (0);
RDebugUtils.currentLine=4521996;
 //BA.debugLineNum = 4521996;BA.debugLine="Dim totalDevices As Int = 0";
_totaldevices = (int) (0);
RDebugUtils.currentLine=4521997;
 //BA.debugLineNum = 4521997;BA.debugLine="YPos = YPos + 0%y + Margin";
_ypos = (int) (_ypos+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA)+_margin);
RDebugUtils.currentLine=4521998;
 //BA.debugLineNum = 4521998;BA.debugLine="Dim tdFontSize As Int = 13";
_tdfontsize = (int) (13);
RDebugUtils.currentLine=4522000;
 //BA.debugLineNum = 4522000;BA.debugLine="TotalLabel.Initialize(\"TotalLabel\")";
mostCurrent._totallabel.Initialize(mostCurrent.activityBA,"TotalLabel");
RDebugUtils.currentLine=4522001;
 //BA.debugLineNum = 4522001;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group16 = mostCurrent._tabledetails;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group16.Get(index16)));
RDebugUtils.currentLine=4522003;
 //BA.debugLineNum = 4522003;BA.debugLine="Dim serial_num As String = record.Get(\"serial\"";
_serial_num = BA.ObjectToString(_record.Get((Object)("serial")));
RDebugUtils.currentLine=4522004;
 //BA.debugLineNum = 4522004;BA.debugLine="Dim sales1 As String = record.Get(\"sales1\")";
_sales1 = BA.ObjectToString(_record.Get((Object)("sales1")));
RDebugUtils.currentLine=4522005;
 //BA.debugLineNum = 4522005;BA.debugLine="Dim sales2 As String = record.Get(\"sales2\")";
_sales2 = BA.ObjectToString(_record.Get((Object)("sales2")));
RDebugUtils.currentLine=4522006;
 //BA.debugLineNum = 4522006;BA.debugLine="Dim sales3 As String = record.Get(\"sales3\")";
_sales3 = BA.ObjectToString(_record.Get((Object)("sales3")));
RDebugUtils.currentLine=4522008;
 //BA.debugLineNum = 4522008;BA.debugLine="Dim id As Int = 0";
_id = (int) (0);
RDebugUtils.currentLine=4522009;
 //BA.debugLineNum = 4522009;BA.debugLine="totalDevices = record.Get(\"totalDevices\")";
_totaldevices = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=4522010;
 //BA.debugLineNum = 4522010;BA.debugLine="Dim comName As String = record.Get(\"comName\")";
_comname = BA.ObjectToString(_record.Get((Object)("comName")));
RDebugUtils.currentLine=4522011;
 //BA.debugLineNum = 4522011;BA.debugLine="LabelTitle.Text = record.Get(\"branchName\")";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_record.Get((Object)("branchName"))));
RDebugUtils.currentLine=4522012;
 //BA.debugLineNum = 4522012;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCase";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=4522014;
 //BA.debugLineNum = 4522014;BA.debugLine="Label1.Text = comName";
mostCurrent._label1.setText(BA.ObjectToCharSequence(_comname));
RDebugUtils.currentLine=4522015;
 //BA.debugLineNum = 4522015;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=4522017;
 //BA.debugLineNum = 4522017;BA.debugLine="branches.Text = \"Branches - \"&comName&\" |\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_comname+" |"));
RDebugUtils.currentLine=4522018;
 //BA.debugLineNum = 4522018;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=4522020;
 //BA.debugLineNum = 4522020;BA.debugLine="devices.Text = \"Devices - \"&record.Get(\"branch";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices - "+BA.ObjectToString(_record.Get((Object)("branchName")))));
RDebugUtils.currentLine=4522021;
 //BA.debugLineNum = 4522021;BA.debugLine="devices.Text = devices.Text.ToUpperCase";
mostCurrent._devices.setText(BA.ObjectToCharSequence(mostCurrent._devices.getText().toUpperCase()));
RDebugUtils.currentLine=4522023;
 //BA.debugLineNum = 4522023;BA.debugLine="Dim ItemPanel As Panel";
_itempanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4522024;
 //BA.debugLineNum = 4522024;BA.debugLine="ItemPanel.Initialize(\"\")";
_itempanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4522025;
 //BA.debugLineNum = 4522025;BA.debugLine="ItemPanel.SetLayout(0, YPos, ScrollView1.Width";
_itempanel.SetLayout((int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
RDebugUtils.currentLine=4522026;
 //BA.debugLineNum = 4522026;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_itempanel.getObject()),(int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=4522027;
 //BA.debugLineNum = 4522027;BA.debugLine="panelWidth = ItemPanel.Width /6";
_panelwidth = (int) (_itempanel.getWidth()/(double)6);
RDebugUtils.currentLine=4522028;
 //BA.debugLineNum = 4522028;BA.debugLine="If num Mod 2 = 0 Then";
if (_num%2==0) { 
RDebugUtils.currentLine=4522029;
 //BA.debugLineNum = 4522029;BA.debugLine="ItemPanel.Color = Colors.LightGray";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 }else {
RDebugUtils.currentLine=4522031;
 //BA.debugLineNum = 4522031;BA.debugLine="ItemPanel.Color = Colors.ARGB(255, 251, 251,";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
 };
RDebugUtils.currentLine=4522034;
 //BA.debugLineNum = 4522034;BA.debugLine="Dim number As Label";
_number = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4522035;
 //BA.debugLineNum = 4522035;BA.debugLine="number.Initialize(\"\")";
_number.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4522036;
 //BA.debugLineNum = 4522036;BA.debugLine="number.Text = id";
_number.setText(BA.ObjectToCharSequence(_id));
RDebugUtils.currentLine=4522037;
 //BA.debugLineNum = 4522037;BA.debugLine="number.TextSize = tdFontSize";
_number.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4522038;
 //BA.debugLineNum = 4522038;BA.debugLine="number.TextColor = Colors.Black";
_number.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522039;
 //BA.debugLineNum = 4522039;BA.debugLine="number.Gravity = Gravity.CENTER_VERTICAL";
_number.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4522040;
 //BA.debugLineNum = 4522040;BA.debugLine="number.Typeface = Typeface.MONOSPACE";
_number.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4522041;
 //BA.debugLineNum = 4522041;BA.debugLine="ItemPanel.AddView(number, tdleftPos, 0, panelW";
_itempanel.AddView((android.view.View)(_number.getObject()),_tdleftpos,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4522043;
 //BA.debugLineNum = 4522043;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4522044;
 //BA.debugLineNum = 4522044;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4522045;
 //BA.debugLineNum = 4522045;BA.debugLine="deviceLabel.Text = \"Pos0\"&id";
_devicelabel.setText(BA.ObjectToCharSequence("Pos0"+BA.NumberToString(_id)));
RDebugUtils.currentLine=4522046;
 //BA.debugLineNum = 4522046;BA.debugLine="deviceLabel.TextSize = tdFontSize";
_devicelabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4522047;
 //BA.debugLineNum = 4522047;BA.debugLine="deviceLabel.TextColor = Colors.Black";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522048;
 //BA.debugLineNum = 4522048;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4522049;
 //BA.debugLineNum = 4522049;BA.debugLine="ItemPanel.AddView(deviceLabel, panelWidth, 0,";
_itempanel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4522051;
 //BA.debugLineNum = 4522051;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4522052;
 //BA.debugLineNum = 4522052;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4522053;
 //BA.debugLineNum = 4522053;BA.debugLine="serialLabel.Text = serial_num";
_seriallabel.setText(BA.ObjectToCharSequence(_serial_num));
RDebugUtils.currentLine=4522054;
 //BA.debugLineNum = 4522054;BA.debugLine="serialLabel.TextSize = tdFontSize";
_seriallabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4522055;
 //BA.debugLineNum = 4522055;BA.debugLine="serialLabel.TextColor = Colors.Black";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522056;
 //BA.debugLineNum = 4522056;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4522057;
 //BA.debugLineNum = 4522057;BA.debugLine="ItemPanel.AddView(serialLabel, panelWidth*2, 0";
_itempanel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4522059;
 //BA.debugLineNum = 4522059;BA.debugLine="Dim sale As Label";
_sale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4522060;
 //BA.debugLineNum = 4522060;BA.debugLine="sale.Initialize(\"\")";
_sale.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4522061;
 //BA.debugLineNum = 4522061;BA.debugLine="sale.Text = sales1";
_sale.setText(BA.ObjectToCharSequence(_sales1));
RDebugUtils.currentLine=4522062;
 //BA.debugLineNum = 4522062;BA.debugLine="sale.TextSize = tdFontSize";
_sale.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4522063;
 //BA.debugLineNum = 4522063;BA.debugLine="sale.TextColor = Colors.Black";
_sale.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522064;
 //BA.debugLineNum = 4522064;BA.debugLine="sale.Gravity = Gravity.CENTER_VERTICAL";
_sale.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4522065;
 //BA.debugLineNum = 4522065;BA.debugLine="ItemPanel.AddView(sale, panelWidth*3, 0, panel";
_itempanel.AddView((android.view.View)(_sale.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4522067;
 //BA.debugLineNum = 4522067;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4522068;
 //BA.debugLineNum = 4522068;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4522069;
 //BA.debugLineNum = 4522069;BA.debugLine="sale1.Text = sales2";
_sale1.setText(BA.ObjectToCharSequence(_sales2));
RDebugUtils.currentLine=4522070;
 //BA.debugLineNum = 4522070;BA.debugLine="sale1.TextSize = tdFontSize";
_sale1.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4522071;
 //BA.debugLineNum = 4522071;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522072;
 //BA.debugLineNum = 4522072;BA.debugLine="sale1.Gravity = Gravity.CENTER_VERTICAL";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4522073;
 //BA.debugLineNum = 4522073;BA.debugLine="ItemPanel.AddView(sale1, panelWidth*4, 0, pane";
_itempanel.AddView((android.view.View)(_sale1.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4522075;
 //BA.debugLineNum = 4522075;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4522076;
 //BA.debugLineNum = 4522076;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4522077;
 //BA.debugLineNum = 4522077;BA.debugLine="sale2.Text = sales3";
_sale2.setText(BA.ObjectToCharSequence(_sales3));
RDebugUtils.currentLine=4522078;
 //BA.debugLineNum = 4522078;BA.debugLine="sale2.TextSize = tdFontSize";
_sale2.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=4522079;
 //BA.debugLineNum = 4522079;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522080;
 //BA.debugLineNum = 4522080;BA.debugLine="sale2.Gravity = Gravity.CENTER_VERTICAL";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4522081;
 //BA.debugLineNum = 4522081;BA.debugLine="ItemPanel.AddView(sale2, panelWidth*5, 0, pane";
_itempanel.AddView((android.view.View)(_sale2.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=4522083;
 //BA.debugLineNum = 4522083;BA.debugLine="Dim backBtn As Label";
_backbtn = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4522084;
 //BA.debugLineNum = 4522084;BA.debugLine="backBtn.Initialize(\"backBtn\")";
_backbtn.Initialize(mostCurrent.activityBA,"backBtn");
RDebugUtils.currentLine=4522085;
 //BA.debugLineNum = 4522085;BA.debugLine="backBtn.TextColor =Colors.White";
_backbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4522086;
 //BA.debugLineNum = 4522086;BA.debugLine="backBtn.Text = \"<\"";
_backbtn.setText(BA.ObjectToCharSequence("<"));
RDebugUtils.currentLine=4522087;
 //BA.debugLineNum = 4522087;BA.debugLine="backBtn.Gravity = Gravity.CENTER";
_backbtn.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4522088;
 //BA.debugLineNum = 4522088;BA.debugLine="backBtn.Typeface = Typeface.SERIF";
_backbtn.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=4522089;
 //BA.debugLineNum = 4522089;BA.debugLine="backBtn.Color = Colors.Black";
_backbtn.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522090;
 //BA.debugLineNum = 4522090;BA.debugLine="backBtn.TextSize = 25";
_backbtn.setTextSize((float) (25));
RDebugUtils.currentLine=4522091;
 //BA.debugLineNum = 4522091;BA.debugLine="Panel3.AddView(backBtn,3dip,5dip,50dip,Panel3.";
mostCurrent._panel3.AddView((android.view.View)(_backbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=4522093;
 //BA.debugLineNum = 4522093;BA.debugLine="pageLabel.Initialize(\"pageLabel\")";
mostCurrent._pagelabel.Initialize(mostCurrent.activityBA,"pageLabel");
RDebugUtils.currentLine=4522094;
 //BA.debugLineNum = 4522094;BA.debugLine="pageLabel.TextColor =Colors.Black";
mostCurrent._pagelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522095;
 //BA.debugLineNum = 4522095;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=4522096;
 //BA.debugLineNum = 4522096;BA.debugLine="pageLabel.Gravity = Gravity.CENTER";
mostCurrent._pagelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4522097;
 //BA.debugLineNum = 4522097;BA.debugLine="pageLabel.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._pagelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=4522098;
 //BA.debugLineNum = 4522098;BA.debugLine="pageLabel.Color = Colors.white";
mostCurrent._pagelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4522099;
 //BA.debugLineNum = 4522099;BA.debugLine="pageLabel.TextSize = 15";
mostCurrent._pagelabel.setTextSize((float) (15));
RDebugUtils.currentLine=4522100;
 //BA.debugLineNum = 4522100;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4522101;
 //BA.debugLineNum = 4522101;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522102;
 //BA.debugLineNum = 4522102;BA.debugLine="Panel3.AddView(pageLabel,backBtn.Width+backBtn";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._pagelabel.getObject()),(int) (_backbtn.getWidth()+_backbtn.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
RDebugUtils.currentLine=4522104;
 //BA.debugLineNum = 4522104;BA.debugLine="Dim nxtLabel As Label";
_nxtlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4522105;
 //BA.debugLineNum = 4522105;BA.debugLine="nxtLabel.Initialize(\"nxtLabel\")";
_nxtlabel.Initialize(mostCurrent.activityBA,"nxtLabel");
RDebugUtils.currentLine=4522106;
 //BA.debugLineNum = 4522106;BA.debugLine="nxtLabel.TextColor =Colors.White";
_nxtlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4522107;
 //BA.debugLineNum = 4522107;BA.debugLine="nxtLabel.Text = \">\"";
_nxtlabel.setText(BA.ObjectToCharSequence(">"));
RDebugUtils.currentLine=4522108;
 //BA.debugLineNum = 4522108;BA.debugLine="nxtLabel.Gravity = Gravity.CENTER";
_nxtlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4522109;
 //BA.debugLineNum = 4522109;BA.debugLine="nxtLabel.Typeface = Typeface.SERIF";
_nxtlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=4522110;
 //BA.debugLineNum = 4522110;BA.debugLine="nxtLabel.Color = Colors.black";
_nxtlabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4522111;
 //BA.debugLineNum = 4522111;BA.debugLine="nxtLabel.TextSize = 25";
_nxtlabel.setTextSize((float) (25));
RDebugUtils.currentLine=4522112;
 //BA.debugLineNum = 4522112;BA.debugLine="Panel3.AddView(nxtLabel,pageLabel.Width+pageLa";
mostCurrent._panel3.AddView((android.view.View)(_nxtlabel.getObject()),(int) (mostCurrent._pagelabel.getWidth()+mostCurrent._pagelabel.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=4522114;
 //BA.debugLineNum = 4522114;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4522115;
 //BA.debugLineNum = 4522115;BA.debugLine="cd.Initialize2(Colors.Black, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4522116;
 //BA.debugLineNum = 4522116;BA.debugLine="backBtn.Background = cd";
_backbtn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=4522117;
 //BA.debugLineNum = 4522117;BA.debugLine="nxtLabel.Background = cd";
_nxtlabel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=4522121;
 //BA.debugLineNum = 4522121;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin ' Upda";
_ypos = (int) (_ypos+_itempanel.getHeight()+_margin);
RDebugUtils.currentLine=4522122;
 //BA.debugLineNum = 4522122;BA.debugLine="nxtLabel.Enabled = False";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4522123;
 //BA.debugLineNum = 4522123;BA.debugLine="If limit * pageNo < totalDevices Then";
if (_limit*_pageno<_totaldevices) { 
RDebugUtils.currentLine=4522124;
 //BA.debugLineNum = 4522124;BA.debugLine="nxtLabel.Enabled = True";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4522128;
 //BA.debugLineNum = 4522128;BA.debugLine="TotalHeight = TotalHeight + 65dip";
_totalheight = (int) (_totalheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65)));
RDebugUtils.currentLine=4522129;
 //BA.debugLineNum = 4522129;BA.debugLine="ScrollView1.Panel.Height =TotalHeight";
mostCurrent._scrollview1.getPanel().setHeight(_totalheight);
RDebugUtils.currentLine=4522130;
 //BA.debugLineNum = 4522130;BA.debugLine="num = num +1";
_num = (int) (_num+1);
RDebugUtils.currentLine=4522131;
 //BA.debugLineNum = 4522131;BA.debugLine="TotalLabel.Text = \"\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=4522135;
 //BA.debugLineNum = 4522135;BA.debugLine="TotalLabel.RemoveView";
mostCurrent._totallabel.RemoveView();
RDebugUtils.currentLine=4522136;
 //BA.debugLineNum = 4522136;BA.debugLine="TotalLabel.TextColor =Colors.White";
mostCurrent._totallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4522137;
 //BA.debugLineNum = 4522137;BA.debugLine="TotalLabel.Text = num&\" out of \"&totalDevices&\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(BA.NumberToString(_num)+" out of "+BA.NumberToString(_totaldevices)+" devices"));
RDebugUtils.currentLine=4522138;
 //BA.debugLineNum = 4522138;BA.debugLine="TotalLabel.Gravity = Gravity.CENTER";
mostCurrent._totallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4522139;
 //BA.debugLineNum = 4522139;BA.debugLine="TotalLabel.Typeface = Typeface.MONOSPACE";
mostCurrent._totallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4522140;
 //BA.debugLineNum = 4522140;BA.debugLine="TotalLabel.Color = Colors.Transparent";
mostCurrent._totallabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=4522141;
 //BA.debugLineNum = 4522141;BA.debugLine="TotalLabel.TextSize = 15";
mostCurrent._totallabel.setTextSize((float) (15));
RDebugUtils.currentLine=4522143;
 //BA.debugLineNum = 4522143;BA.debugLine="Panel3.AddView(TotalLabel,Panel3.Width-240dip,5";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._totallabel.getObject()),(int) (mostCurrent._panel3.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (240))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (230)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 } 
       catch (Exception e136) {
			processBA.setLastException(e136); };
 }else {
RDebugUtils.currentLine=4522149;
 //BA.debugLineNum = 4522149;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4522152;
 //BA.debugLineNum = 4522152;BA.debugLine="End Sub";
return "";
}
public static String  _nxtlabel_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtlabel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtlabel_click", null));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Private Sub nxtLabel_Click";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="pageNo = pageNo + 1";
_pageno = (int) (_pageno+1);
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="End Sub";
return "";
}
}