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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (device.mostCurrent != null);
vis = vis | (branch.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (device.previousOne != null) {
				__a = device.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(device.mostCurrent == null ? null : device.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (branch.previousOne != null) {
				__a = branch.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(branch.mostCurrent == null ? null : branch.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static String _company = "";
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public static String _phpurl = "";
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _navigate = null;
public static int _primaryfontsize = 0;
public static int _secondaryfontsize = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public b4a.example.bargraph _bargraph = null;
public b4a.example.bargraph _bargraph1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _purchasepanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _barpanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _salenxtbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _salebackbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _purchnxtbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _purchbackbtn = null;
public static String[] _legend = null;
public static int _height = 0;
public anywheresoftware.b4a.objects.PanelWrapper _companypanel = null;
public static int _totalgraphdataheight = 0;
public static int _totalgetdataheight = 0;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.branch _branch = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Panel1.Color = Colors.Black";
mostCurrent._panel1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
mostCurrent._label1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 241, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (241),(int) (241),(int) (241)));
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (225),(int) (218),(int) (218)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (189),(int) (202),(int) (217))});
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="ScrollView1.Background = gradient";
mostCurrent._scrollview1.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="ScrollView1.Panel.Height = Activity.Height";
mostCurrent._scrollview1.getPanel().setHeight(mostCurrent._activity.getHeight());
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="LoadGraphData";
_loadgraphdata();
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="barPanel.Initialize(\"\")";
mostCurrent._barpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Try";
try {RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",main.getObject());
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("34063239",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="End Sub";
return "";
}
public static String  _loadgraphdata() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadgraphdata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadgraphdata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub LoadGraphData";
RDebugUtils.currentLine=7077889;
 //BA.debugLineNum = 7077889;BA.debugLine="Try";
try {RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="Job1.Initialize(\"getDataGraph\", Me)";
_job1._initialize /*String*/ (null,processBA,"getDataGraph",main.getObject());
RDebugUtils.currentLine=7077892;
 //BA.debugLineNum = 7077892;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=7077893;
 //BA.debugLineNum = 7077893;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=7077895;
 //BA.debugLineNum = 7077895;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("37077895",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=7077898;
 //BA.debugLineNum = 7077898;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _adjustfontsizetoheight(anywheresoftware.b4a.objects.LabelWrapper _lbl,float _fontnum) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "adjustfontsizetoheight", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "adjustfontsizetoheight", new Object[] {_lbl,_fontnum}));}
float _fontsize = 0f;
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub AdjustFontSizeToHeight(lbl As Label,fontNum As";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Dim fontSize As Float = lbl.Height * fontNum / Ge";
_fontsize = (float) (_lbl.getHeight()*_fontnum/(double)_getdevicedensity());
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="lbl.TextSize = fontSize";
_lbl.setTextSize(_fontsize);
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="End Sub";
return "";
}
public static float  _getdevicedensity() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getdevicedensity", false))
	 {return ((Float) Debug.delegate(mostCurrent.activityBA, "getdevicedensity", null));}
int _pixelwidth = 0;
int _dipwidth = 0;
float _dense = 0f;
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub GetDeviceDensity As Float";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Dim pixelWidth As Int = 100%x ' Screen width in p";
_pixelwidth = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA);
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="Dim dipWidth As Int = 100dip  ' 100 DIPs in pixel";
_dipwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="Dim Dense As Float = pixelWidth / dipWidth";
_dense = (float) (_pixelwidth/(double)_dipwidth);
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="Return Dense";
if (true) return _dense;
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="End Sub";
return 0f;
}
public static Object  _getmapvalueordefault(anywheresoftware.b4a.objects.collections.Map _m,String _key,Object _defaultvalue) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getmapvalueordefault", false))
	 {return ((Object) Debug.delegate(mostCurrent.activityBA, "getmapvalueordefault", new Object[] {_m,_key,_defaultvalue}));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="If m.ContainsKey(Key) Then";
if (_m.ContainsKey((Object)(_key))) { 
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="Return m.Get(Key)";
if (true) return _m.Get((Object)(_key));
 }else {
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="End Sub";
return null;
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _scrollheight = 0;
anywheresoftware.b4a.objects.collections.List _salesarray = null;
int _padding = 0;
int _count = 0;
int _rownum = 0;
int _mainpanelwidth = 0;
int _panelheight = 0;
anywheresoftware.b4a.objects.collections.Map _record = null;
int _col = 0;
int _row = 0;
String _name = "";
int _company_id = 0;
int _total_count = 0;
int _total_pos = 0;
anywheresoftware.b4a.objects.PanelWrapper _dashpanel = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _myimage = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
anywheresoftware.b4a.objects.LabelWrapper _dashlabel = null;
anywheresoftware.b4a.objects.PanelWrapper _panel = null;
anywheresoftware.b4a.objects.PanelWrapper _paneltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _label17 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _resizedimage = null;
int _panelwidth = 0;
int _labelheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _totalstore = null;
anywheresoftware.b4a.objects.LabelWrapper _totalstorelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpos = null;
anywheresoftware.b4a.objects.LabelWrapper _totalposlabel = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _totalcompanies = 0;
int[] _sales = null;
int[] _comid = null;
int[] _sales1 = null;
int[] _sales2 = null;
int[] _purchase = null;
int[] _purchase1 = null;
int[] _purchase2 = null;
String[] _companyname = null;
int[] _max_value = null;
int _maxsale = 0;
int _i = 0;
anywheresoftware.b4a.objects.PanelWrapper _totalsalepanel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalsalelabel = null;
anywheresoftware.b4a.objects.PanelWrapper _shadowpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _totalpurchasepanel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpurchaselabel = null;
anywheresoftware.b4a.objects.PanelWrapper _shadowpurchpanel = null;
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
 //BA.debugLineNum = 4128772;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","getDataGraph","UpdateData")) {
case 0: {
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=4128789;
 //BA.debugLineNum = 4128789;BA.debugLine="Dim rowNum As Int = 3";
_rownum = (int) (3);
RDebugUtils.currentLine=4128790;
 //BA.debugLineNum = 4128790;BA.debugLine="Dim mainPanelWidth As Int = 0";
_mainpanelwidth = (int) (0);
RDebugUtils.currentLine=4128791;
 //BA.debugLineNum = 4128791;BA.debugLine="Dim panelHeight As Int = 150dip ' Adjust heig";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150));
RDebugUtils.currentLine=4128792;
 //BA.debugLineNum = 4128792;BA.debugLine="height = panelHeight - 70dip";
_height = (int) (_panelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=4128794;
 //BA.debugLineNum = 4128794;BA.debugLine="For Each record As Map In salesArray";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group20 = _salesarray;
final int groupLen20 = group20.getSize()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group20.Get(index20)));
RDebugUtils.currentLine=4128796;
 //BA.debugLineNum = 4128796;BA.debugLine="If count Mod 3 = 0 Then";
if (_count%3==0) { 
RDebugUtils.currentLine=4128797;
 //BA.debugLineNum = 4128797;BA.debugLine="height = height + panelHeight";
_height = (int) (_height+_panelheight);
 };
RDebugUtils.currentLine=4128800;
 //BA.debugLineNum = 4128800;BA.debugLine="Dim col As Int = count Mod 3  ' Column posi";
_col = (int) (_count%3);
RDebugUtils.currentLine=4128801;
 //BA.debugLineNum = 4128801;BA.debugLine="Dim row As Int = Floor(count / 3)";
_row = (int) (anywheresoftware.b4a.keywords.Common.Floor(_count/(double)3));
RDebugUtils.currentLine=4128803;
 //BA.debugLineNum = 4128803;BA.debugLine="Dim name As String = record.Get(\"company_na";
_name = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=4128804;
 //BA.debugLineNum = 4128804;BA.debugLine="Dim company_id As Int = record.Get(\"comId\")";
_company_id = (int)(BA.ObjectToNumber(_record.Get((Object)("comId"))));
RDebugUtils.currentLine=4128805;
 //BA.debugLineNum = 4128805;BA.debugLine="Dim total_count As Int = record.Get(\"total_";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("total_count"))));
RDebugUtils.currentLine=4128806;
 //BA.debugLineNum = 4128806;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDev";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=4128808;
 //BA.debugLineNum = 4128808;BA.debugLine="Dim dashPanel As Panel";
_dashpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4128809;
 //BA.debugLineNum = 4128809;BA.debugLine="dashPanel.Initialize(\"\")";
_dashpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128810;
 //BA.debugLineNum = 4128810;BA.debugLine="ScrollView1.Panel.AddView(dashPanel, 5dip,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_dashpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),mostCurrent._panel2.getHeight(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=4128813;
 //BA.debugLineNum = 4128813;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=4128814;
 //BA.debugLineNum = 4128814;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"dashb";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dashboard.png");
RDebugUtils.currentLine=4128816;
 //BA.debugLineNum = 4128816;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4128817;
 //BA.debugLineNum = 4128817;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128818;
 //BA.debugLineNum = 4128818;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=4128819;
 //BA.debugLineNum = 4128819;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=4128820;
 //BA.debugLineNum = 4128820;BA.debugLine="dashPanel.AddView(imgView, 0dip, 12.5dip, 1";
_dashpanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_dashpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=4128822;
 //BA.debugLineNum = 4128822;BA.debugLine="Dim dashLabel As Label";
_dashlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128823;
 //BA.debugLineNum = 4128823;BA.debugLine="dashLabel.Initialize(\"\")";
_dashlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128824;
 //BA.debugLineNum = 4128824;BA.debugLine="dashLabel.Text = \"Dashboard\"";
_dashlabel.setText(BA.ObjectToCharSequence("Dashboard"));
RDebugUtils.currentLine=4128825;
 //BA.debugLineNum = 4128825;BA.debugLine="dashLabel.TextColor = Colors.ARGB(50,156,0,";
_dashlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (156),(int) (0),(int) (0)));
RDebugUtils.currentLine=4128826;
 //BA.debugLineNum = 4128826;BA.debugLine="dashLabel.Gravity = Gravity.CENTER_VERTICAL";
_dashlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128827;
 //BA.debugLineNum = 4128827;BA.debugLine="dashLabel.Typeface = Typeface.MONOSPACE";
_dashlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4128828;
 //BA.debugLineNum = 4128828;BA.debugLine="dashPanel.AddView(dashLabel, imgView.Width+";
_dashpanel.AddView((android.view.View)(_dashlabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_dashpanel.getWidth(),_dashpanel.getHeight());
RDebugUtils.currentLine=4128829;
 //BA.debugLineNum = 4128829;BA.debugLine="AdjustFontSizeToHeight(dashLabel,2)";
_adjustfontsizetoheight(_dashlabel,(float) (2));
RDebugUtils.currentLine=4128832;
 //BA.debugLineNum = 4128832;BA.debugLine="companyPanel.Initialize(\"Panel\")";
mostCurrent._companypanel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=4128833;
 //BA.debugLineNum = 4128833;BA.debugLine="ScrollView1.Panel.AddView(companyPanel, 5di";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._companypanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),_dashpanel.getHeight(),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),_height);
RDebugUtils.currentLine=4128836;
 //BA.debugLineNum = 4128836;BA.debugLine="mainPanelWidth = companyPanel.Width / rowNu";
_mainpanelwidth = (int) (mostCurrent._companypanel.getWidth()/(double)_rownum);
RDebugUtils.currentLine=4128837;
 //BA.debugLineNum = 4128837;BA.debugLine="Dim Panel As Panel";
_panel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4128838;
 //BA.debugLineNum = 4128838;BA.debugLine="Panel.Initialize(\"\")";
_panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128839;
 //BA.debugLineNum = 4128839;BA.debugLine="companyPanel.AddView(Panel, col * (mainPane";
mostCurrent._companypanel.AddView((android.view.View)(_panel.getObject()),(int) (_col*(_mainpanelwidth+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)))),(int) (mostCurrent._panel2.getHeight()+(_row*(_panelheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))))),(int) (_mainpanelwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),_panelheight);
RDebugUtils.currentLine=4128841;
 //BA.debugLineNum = 4128841;BA.debugLine="Dim PanelTitle As Panel";
_paneltitle = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4128842;
 //BA.debugLineNum = 4128842;BA.debugLine="PanelTitle.Initialize(\"Panel2\")";
_paneltitle.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=4128843;
 //BA.debugLineNum = 4128843;BA.debugLine="PanelTitle.Color = Colors.Black";
_paneltitle.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128844;
 //BA.debugLineNum = 4128844;BA.debugLine="PanelTitle.Tag = name";
_paneltitle.setTag((Object)(_name));
RDebugUtils.currentLine=4128845;
 //BA.debugLineNum = 4128845;BA.debugLine="Panel.AddView(PanelTitle, 0, 0, Panel.Width";
_panel.AddView((android.view.View)(_paneltitle.getObject()),(int) (0),(int) (0),_panel.getWidth(),(int) (_panelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))));
RDebugUtils.currentLine=4128848;
 //BA.debugLineNum = 4128848;BA.debugLine="Dim Label17 As Label";
_label17 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128849;
 //BA.debugLineNum = 4128849;BA.debugLine="Label17.Initialize(\"Label17\")";
_label17.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=4128850;
 //BA.debugLineNum = 4128850;BA.debugLine="Label17.Text = name.ToUpperCase";
_label17.setText(BA.ObjectToCharSequence(_name.toUpperCase()));
RDebugUtils.currentLine=4128851;
 //BA.debugLineNum = 4128851;BA.debugLine="Label17.Tag = company_id";
_label17.setTag((Object)(_company_id));
RDebugUtils.currentLine=4128852;
 //BA.debugLineNum = 4128852;BA.debugLine="Label17.TextSize = 18";
_label17.setTextSize((float) (18));
RDebugUtils.currentLine=4128853;
 //BA.debugLineNum = 4128853;BA.debugLine="Label17.TextColor = Colors.White";
_label17.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4128854;
 //BA.debugLineNum = 4128854;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
_label17.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128855;
 //BA.debugLineNum = 4128855;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
_label17.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4128856;
 //BA.debugLineNum = 4128856;BA.debugLine="PanelTitle.AddView(Label17, 5dip, 0dip, Pan";
_paneltitle.AddView((android.view.View)(_label17.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_paneltitle.getWidth(),_paneltitle.getHeight());
RDebugUtils.currentLine=4128857;
 //BA.debugLineNum = 4128857;BA.debugLine="AdjustFontSizeToHeight(Label17,2)";
_adjustfontsizetoheight(_label17,(float) (2));
RDebugUtils.currentLine=4128859;
 //BA.debugLineNum = 4128859;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=4128860;
 //BA.debugLineNum = 4128860;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrow";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=4128861;
 //BA.debugLineNum = 4128861;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=4128862;
 //BA.debugLineNum = 4128862;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resiz";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128863;
 //BA.debugLineNum = 4128863;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4128864;
 //BA.debugLineNum = 4128864;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128865;
 //BA.debugLineNum = 4128865;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=4128866;
 //BA.debugLineNum = 4128866;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=4128867;
 //BA.debugLineNum = 4128867;BA.debugLine="PanelTitle.AddView(imgView, PanelTitle.Wid";
_paneltitle.AddView((android.view.View)(_imgview.getObject()),(int) (_paneltitle.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),(int) (_paneltitle.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 }else {
RDebugUtils.currentLine=4128869;
 //BA.debugLineNum = 4128869;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("34128869","Error loading image",0);
 };
RDebugUtils.currentLine=4128872;
 //BA.debugLineNum = 4128872;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
_panelwidth = (int) (_panel.getWidth()/(double)3);
RDebugUtils.currentLine=4128873;
 //BA.debugLineNum = 4128873;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=4128874;
 //BA.debugLineNum = 4128874;BA.debugLine="Dim labelheight As Int = panelHeight - Pane";
_labelheight = (int) (_panelheight-_paneltitle.getHeight());
RDebugUtils.currentLine=4128875;
 //BA.debugLineNum = 4128875;BA.debugLine="panelWidth = Panel.Width /2";
_panelwidth = (int) (_panel.getWidth()/(double)2);
RDebugUtils.currentLine=4128877;
 //BA.debugLineNum = 4128877;BA.debugLine="Dim totalStore As Label";
_totalstore = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128878;
 //BA.debugLineNum = 4128878;BA.debugLine="totalStore.Initialize(\"\")";
_totalstore.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128879;
 //BA.debugLineNum = 4128879;BA.debugLine="totalStore.Text = total_count";
_totalstore.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=4128880;
 //BA.debugLineNum = 4128880;BA.debugLine="totalStore.TextColor = Colors.Black";
_totalstore.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128881;
 //BA.debugLineNum = 4128881;BA.debugLine="totalStore.TextSize = primaryFontSize";
_totalstore.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=4128882;
 //BA.debugLineNum = 4128882;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
_totalstore.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4128883;
 //BA.debugLineNum = 4128883;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
_totalstore.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=4128884;
 //BA.debugLineNum = 4128884;BA.debugLine="Panel.AddView(totalStore,0,PanelTitle.Heigh";
_panel.AddView((android.view.View)(_totalstore.getObject()),(int) (0),_paneltitle.getHeight(),_panelwidth,(int) (_labelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))));
RDebugUtils.currentLine=4128885;
 //BA.debugLineNum = 4128885;BA.debugLine="AdjustFontSizeToHeight(totalStore,1.3)";
_adjustfontsizetoheight(_totalstore,(float) (1.3));
RDebugUtils.currentLine=4128887;
 //BA.debugLineNum = 4128887;BA.debugLine="Dim totalStoreLabel As Label";
_totalstorelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128888;
 //BA.debugLineNum = 4128888;BA.debugLine="totalStoreLabel.Initialize(\"\")";
_totalstorelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128889;
 //BA.debugLineNum = 4128889;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
_totalstorelabel.setText(BA.ObjectToCharSequence(" Total Store"));
RDebugUtils.currentLine=4128890;
 //BA.debugLineNum = 4128890;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
_totalstorelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=4128891;
 //BA.debugLineNum = 4128891;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSiz";
_totalstorelabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=4128892;
 //BA.debugLineNum = 4128892;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
_totalstorelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4128893;
 //BA.debugLineNum = 4128893;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPA";
_totalstorelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4128894;
 //BA.debugLineNum = 4128894;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text";
_totalstorelabel.setText(BA.ObjectToCharSequence(_totalstorelabel.getText().toUpperCase()));
RDebugUtils.currentLine=4128895;
 //BA.debugLineNum = 4128895;BA.debugLine="Panel.AddView(totalStoreLabel,0,totalStore.";
_panel.AddView((android.view.View)(_totalstorelabel.getObject()),(int) (0),(int) (_totalstore.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=4128897;
 //BA.debugLineNum = 4128897;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128898;
 //BA.debugLineNum = 4128898;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128899;
 //BA.debugLineNum = 4128899;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=4128900;
 //BA.debugLineNum = 4128900;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128901;
 //BA.debugLineNum = 4128901;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=4128902;
 //BA.debugLineNum = 4128902;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4128903;
 //BA.debugLineNum = 4128903;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=4128904;
 //BA.debugLineNum = 4128904;BA.debugLine="Panel.AddView(totalPos,panelWidth,PanelTitl";
_panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,_paneltitle.getHeight(),_panelwidth,(int) (_labelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))));
RDebugUtils.currentLine=4128905;
 //BA.debugLineNum = 4128905;BA.debugLine="AdjustFontSizeToHeight(totalPos,1.3)";
_adjustfontsizetoheight(_totalpos,(float) (1.3));
RDebugUtils.currentLine=4128907;
 //BA.debugLineNum = 4128907;BA.debugLine="Dim totalPosLabel As Label";
_totalposlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128908;
 //BA.debugLineNum = 4128908;BA.debugLine="totalPosLabel.Initialize(\"\")";
_totalposlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128909;
 //BA.debugLineNum = 4128909;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
_totalposlabel.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=4128910;
 //BA.debugLineNum = 4128910;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
_totalposlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=4128911;
 //BA.debugLineNum = 4128911;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
_totalposlabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=4128912;
 //BA.debugLineNum = 4128912;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
_totalposlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4128913;
 //BA.debugLineNum = 4128913;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
_totalposlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4128914;
 //BA.debugLineNum = 4128914;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToU";
_totalposlabel.setText(BA.ObjectToCharSequence(_totalposlabel.getText().toUpperCase()));
RDebugUtils.currentLine=4128915;
 //BA.debugLineNum = 4128915;BA.debugLine="Panel.AddView(totalPosLabel,panelWidth,tota";
_panel.AddView((android.view.View)(_totalposlabel.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=4128918;
 //BA.debugLineNum = 4128918;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4128919;
 //BA.debugLineNum = 4128919;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 0dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128920;
 //BA.debugLineNum = 4128920;BA.debugLine="Panel.Background = cd";
_panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=4128921;
 //BA.debugLineNum = 4128921;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 }
};
RDebugUtils.currentLine=4128924;
 //BA.debugLineNum = 4128924;BA.debugLine="totalGetDataHeight = Panel2.Height+companyPan";
_totalgetdataheight = (int) (mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight());
 break; }
case 1: {
RDebugUtils.currentLine=4128926;
 //BA.debugLineNum = 4128926;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=4128930;
 //BA.debugLineNum = 4128930;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=4128931;
 //BA.debugLineNum = 4128931;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128932;
 //BA.debugLineNum = 4128932;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4128935;
 //BA.debugLineNum = 4128935;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
_totalcompanies = _salesarray.getSize();
RDebugUtils.currentLine=4128936;
 //BA.debugLineNum = 4128936;BA.debugLine="Dim sales(totalCompanies) As Int";
_sales = new int[_totalcompanies];
;
RDebugUtils.currentLine=4128937;
 //BA.debugLineNum = 4128937;BA.debugLine="Dim comId(totalCompanies) As Int";
_comid = new int[_totalcompanies];
;
RDebugUtils.currentLine=4128938;
 //BA.debugLineNum = 4128938;BA.debugLine="Dim sales1(totalCompanies) As Int";
_sales1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=4128939;
 //BA.debugLineNum = 4128939;BA.debugLine="Dim sales2(totalCompanies) As Int";
_sales2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=4128940;
 //BA.debugLineNum = 4128940;BA.debugLine="Dim purchase(totalCompanies) As Int";
_purchase = new int[_totalcompanies];
;
RDebugUtils.currentLine=4128941;
 //BA.debugLineNum = 4128941;BA.debugLine="Dim purchase1(totalCompanies) As Int";
_purchase1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=4128942;
 //BA.debugLineNum = 4128942;BA.debugLine="Dim purchase2(totalCompanies) As Int";
_purchase2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=4128943;
 //BA.debugLineNum = 4128943;BA.debugLine="Dim companyName(totalCompanies) As String";
_companyname = new String[_totalcompanies];
java.util.Arrays.fill(_companyname,"");
RDebugUtils.currentLine=4128944;
 //BA.debugLineNum = 4128944;BA.debugLine="Dim max_value(totalCompanies) As Int";
_max_value = new int[_totalcompanies];
;
RDebugUtils.currentLine=4128945;
 //BA.debugLineNum = 4128945;BA.debugLine="Dim maxSale As Int=0";
_maxsale = (int) (0);
RDebugUtils.currentLine=4128947;
 //BA.debugLineNum = 4128947;BA.debugLine="For i = 0 To totalCompanies - 1";
{
final int step144 = 1;
final int limit144 = (int) (_totalcompanies-1);
_i = (int) (0) ;
for (;_i <= limit144 ;_i = _i + step144 ) {
RDebugUtils.currentLine=4128948;
 //BA.debugLineNum = 4128948;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=4128949;
 //BA.debugLineNum = 4128949;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
_companyname[_i] = BA.ObjectToString(_record.GetDefault((Object)("company_name"),(Object)("Unknown")));
RDebugUtils.currentLine=4128950;
 //BA.debugLineNum = 4128950;BA.debugLine="comId(i) = record.GetDefault(\"comId\", 0)";
_comid[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("comId"),(Object)(0))));
RDebugUtils.currentLine=4128951;
 //BA.debugLineNum = 4128951;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
_sales[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_1"),(Object)(0))));
RDebugUtils.currentLine=4128952;
 //BA.debugLineNum = 4128952;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
_sales1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_2"),(Object)(0))));
RDebugUtils.currentLine=4128953;
 //BA.debugLineNum = 4128953;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
_sales2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_3"),(Object)(0))));
RDebugUtils.currentLine=4128954;
 //BA.debugLineNum = 4128954;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
_purchase[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_1"),(Object)(0))));
RDebugUtils.currentLine=4128955;
 //BA.debugLineNum = 4128955;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
_purchase1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_2"),(Object)(0))));
RDebugUtils.currentLine=4128956;
 //BA.debugLineNum = 4128956;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_\"";
_purchase2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_"),(Object)(0))));
RDebugUtils.currentLine=4128957;
 //BA.debugLineNum = 4128957;BA.debugLine="max_value(i) = record.GetDefault(\"max_value\"";
_max_value[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("max_value"),(Object)(0))));
RDebugUtils.currentLine=4128958;
 //BA.debugLineNum = 4128958;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
_maxsale = (int) (anywheresoftware.b4a.keywords.Common.Max(_maxsale,_max_value[_i]));
RDebugUtils.currentLine=4128959;
 //BA.debugLineNum = 4128959;BA.debugLine="Log(companyName(i))";
anywheresoftware.b4a.keywords.Common.LogImpl("34128959",_companyname[_i],0);
 }
};
RDebugUtils.currentLine=4128962;
 //BA.debugLineNum = 4128962;BA.debugLine="barPanel.RemoveAllViews";
mostCurrent._barpanel.RemoveAllViews();
RDebugUtils.currentLine=4128963;
 //BA.debugLineNum = 4128963;BA.debugLine="barPanel.Invalidate ' Force redraw";
mostCurrent._barpanel.Invalidate();
RDebugUtils.currentLine=4128965;
 //BA.debugLineNum = 4128965;BA.debugLine="Activity.Initialize(\"\")";
mostCurrent._activity.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128967;
 //BA.debugLineNum = 4128967;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
mostCurrent._legend = new String[]{"Sales1","Sales2","Sales3"};
RDebugUtils.currentLine=4128969;
 //BA.debugLineNum = 4128969;BA.debugLine="saleNxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._salenxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=4128970;
 //BA.debugLineNum = 4128970;BA.debugLine="saleBackBtn.Initialize(\"backbtn\")";
mostCurrent._salebackbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=4128972;
 //BA.debugLineNum = 4128972;BA.debugLine="Dim totalSalePanel As Panel";
_totalsalepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4128973;
 //BA.debugLineNum = 4128973;BA.debugLine="totalSalePanel.Initialize(\"\")";
_totalsalepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128974;
 //BA.debugLineNum = 4128974;BA.debugLine="ScrollView1.Panel.AddView(totalSalePanel,5dip";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_totalsalepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (28))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=4128976;
 //BA.debugLineNum = 4128976;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=4128977;
 //BA.debugLineNum = 4128977;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"stock.p";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"stock.png");
RDebugUtils.currentLine=4128979;
 //BA.debugLineNum = 4128979;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4128980;
 //BA.debugLineNum = 4128980;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128981;
 //BA.debugLineNum = 4128981;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=4128982;
 //BA.debugLineNum = 4128982;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=4128983;
 //BA.debugLineNum = 4128983;BA.debugLine="totalSalePanel.AddView(imgView, 0dip, 12.5dip";
_totalsalepanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_totalsalepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=4128985;
 //BA.debugLineNum = 4128985;BA.debugLine="Dim totalSaleLabel As Label";
_totalsalelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128986;
 //BA.debugLineNum = 4128986;BA.debugLine="totalSaleLabel.Initialize(\"\")";
_totalsalelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128987;
 //BA.debugLineNum = 4128987;BA.debugLine="totalSaleLabel.Text = \"Total Sales\"";
_totalsalelabel.setText(BA.ObjectToCharSequence("Total Sales"));
RDebugUtils.currentLine=4128988;
 //BA.debugLineNum = 4128988;BA.debugLine="totalSaleLabel.TextColor = Colors.Black";
_totalsalelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4128989;
 //BA.debugLineNum = 4128989;BA.debugLine="totalSaleLabel.Gravity = Gravity.CENTER_VERTI";
_totalsalelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4128990;
 //BA.debugLineNum = 4128990;BA.debugLine="totalSaleLabel.Typeface = Typeface.MONOSPACE";
_totalsalelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4128991;
 //BA.debugLineNum = 4128991;BA.debugLine="totalSalePanel.AddView(totalSaleLabel,imgView";
_totalsalepanel.AddView((android.view.View)(_totalsalelabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=4128992;
 //BA.debugLineNum = 4128992;BA.debugLine="AdjustFontSizeToHeight(totalSaleLabel,2)";
_adjustfontsizetoheight(_totalsalelabel,(float) (2));
RDebugUtils.currentLine=4128994;
 //BA.debugLineNum = 4128994;BA.debugLine="Dim shadowPanel As Panel";
_shadowpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4128995;
 //BA.debugLineNum = 4128995;BA.debugLine="shadowPanel.Initialize(\"\")";
_shadowpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4128996;
 //BA.debugLineNum = 4128996;BA.debugLine="shadowPanel.Color = Colors.ARGB(50, 138, 138,";
_shadowpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (138),(int) (138),(int) (138)));
RDebugUtils.currentLine=4128997;
 //BA.debugLineNum = 4128997;BA.debugLine="ScrollView1.Panel.AddView(shadowPanel, 25dip";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_shadowpanel.getObject()),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=4128999;
 //BA.debugLineNum = 4128999;BA.debugLine="ScrollView1.Panel.AddView(barPanel,25dip,tota";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._barpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=4129000;
 //BA.debugLineNum = 4129000;BA.debugLine="barPanel.Color = Colors.White";
mostCurrent._barpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4129001;
 //BA.debugLineNum = 4129001;BA.debugLine="barGraph.Initialize(Activity,barPanel,sales,s";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._barpanel,_sales,_sales1,_sales2,_companyname,mostCurrent._legend,_maxsale,"Sales Per Company",_comid,"Branch",mostCurrent._salenxtbtn,mostCurrent._salebackbtn);
RDebugUtils.currentLine=4129002;
 //BA.debugLineNum = 4129002;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purchas";
mostCurrent._legend = new String[]{"Purchase1","Purchase2","Purchase3"};
RDebugUtils.currentLine=4129004;
 //BA.debugLineNum = 4129004;BA.debugLine="Dim totalPurchasePanel As Panel";
_totalpurchasepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4129005;
 //BA.debugLineNum = 4129005;BA.debugLine="totalPurchasePanel.Initialize(\"\")";
_totalpurchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4129006;
 //BA.debugLineNum = 4129006;BA.debugLine="ScrollView1.Panel.AddView(totalPurchasePanel,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_totalpurchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (mostCurrent._barpanel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=4129008;
 //BA.debugLineNum = 4129008;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=4129009;
 //BA.debugLineNum = 4129009;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"stock.p";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"stock.png");
RDebugUtils.currentLine=4129011;
 //BA.debugLineNum = 4129011;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4129012;
 //BA.debugLineNum = 4129012;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4129013;
 //BA.debugLineNum = 4129013;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=4129014;
 //BA.debugLineNum = 4129014;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=4129015;
 //BA.debugLineNum = 4129015;BA.debugLine="totalPurchasePanel.AddView(imgView, 0dip, 12.";
_totalpurchasepanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_totalpurchasepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=4129017;
 //BA.debugLineNum = 4129017;BA.debugLine="Dim totalPurchaseLabel As Label";
_totalpurchaselabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4129018;
 //BA.debugLineNum = 4129018;BA.debugLine="totalPurchaseLabel.Initialize(\"\")";
_totalpurchaselabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4129019;
 //BA.debugLineNum = 4129019;BA.debugLine="totalPurchaseLabel.Text = \"Total Purchases\"";
_totalpurchaselabel.setText(BA.ObjectToCharSequence("Total Purchases"));
RDebugUtils.currentLine=4129020;
 //BA.debugLineNum = 4129020;BA.debugLine="totalPurchaseLabel.TextColor =Colors.Black";
_totalpurchaselabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4129021;
 //BA.debugLineNum = 4129021;BA.debugLine="totalPurchaseLabel.Gravity = Gravity.CENTER_V";
_totalpurchaselabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=4129022;
 //BA.debugLineNum = 4129022;BA.debugLine="totalPurchaseLabel.Typeface = Typeface.MONOSP";
_totalpurchaselabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=4129023;
 //BA.debugLineNum = 4129023;BA.debugLine="totalPurchasePanel.AddView(totalPurchaseLabel";
_totalpurchasepanel.AddView((android.view.View)(_totalpurchaselabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),_totalpurchasepanel.getHeight());
RDebugUtils.currentLine=4129024;
 //BA.debugLineNum = 4129024;BA.debugLine="AdjustFontSizeToHeight(totalPurchaseLabel,2)";
_adjustfontsizetoheight(_totalpurchaselabel,(float) (2));
RDebugUtils.currentLine=4129026;
 //BA.debugLineNum = 4129026;BA.debugLine="Dim shadowPurchPanel As Panel";
_shadowpurchpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4129027;
 //BA.debugLineNum = 4129027;BA.debugLine="shadowPurchPanel.Initialize(\"\")";
_shadowpurchpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4129028;
 //BA.debugLineNum = 4129028;BA.debugLine="shadowPurchPanel.Color = Colors.ARGB(50, 138,";
_shadowpurchpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (138),(int) (138),(int) (138)));
RDebugUtils.currentLine=4129029;
 //BA.debugLineNum = 4129029;BA.debugLine="ScrollView1.Panel.AddView(shadowPurchPanel, 2";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_shadowpurchpanel.getObject()),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()+mostCurrent._barpanel.getHeight()+_totalpurchaselabel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=4129031;
 //BA.debugLineNum = 4129031;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4129032;
 //BA.debugLineNum = 4129032;BA.debugLine="ScrollView1.Panel.AddView(purchasePanel,25dip";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()+mostCurrent._barpanel.getHeight()+_totalpurchaselabel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=4129033;
 //BA.debugLineNum = 4129033;BA.debugLine="purchNxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._purchnxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=4129034;
 //BA.debugLineNum = 4129034;BA.debugLine="purchBackBtn.Initialize(\"backbtn\")";
mostCurrent._purchbackbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=4129035;
 //BA.debugLineNum = 4129035;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel,";
mostCurrent._bargraph1._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_purchase,_purchase1,_purchase2,_companyname,mostCurrent._legend,_maxsale,"Purchases Per Company",_comid,"Branch",mostCurrent._purchnxtbtn,mostCurrent._purchbackbtn);
RDebugUtils.currentLine=4129036;
 //BA.debugLineNum = 4129036;BA.debugLine="Log($\"maxSale:${maxSale}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("34129036",("maxSale:"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_maxsale))+""),0);
RDebugUtils.currentLine=4129037;
 //BA.debugLineNum = 4129037;BA.debugLine="purchasePanel.Color = Colors.White";
mostCurrent._purchasepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=4129038;
 //BA.debugLineNum = 4129038;BA.debugLine="totalGraphDataHeight = totalSaleLabel.Height+";
_totalgraphdataheight = (int) (_totalsalelabel.getHeight()+mostCurrent._barpanel.getHeight()+_totalpurchaselabel.getHeight()+mostCurrent._purchasepanel.getHeight());
 break; }
case 2: {
RDebugUtils.currentLine=4129040;
 //BA.debugLineNum = 4129040;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4129041;
 //BA.debugLineNum = 4129041;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=4129043;
 //BA.debugLineNum = 4129043;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("34129043","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e227) {
			processBA.setLastException(e227);RDebugUtils.currentLine=4129048;
 //BA.debugLineNum = 4129048;BA.debugLine="ToastMessageShow(\"Error parsing sales data\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing sales data"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4129050;
 //BA.debugLineNum = 4129050;BA.debugLine="ScrollView1.Panel.Height = totalGraphDataHeight";
mostCurrent._scrollview1.getPanel().setHeight((int) (_totalgraphdataheight+_totalgetdataheight));
 }else {
RDebugUtils.currentLine=4129052;
 //BA.debugLineNum = 4129052;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4129054;
 //BA.debugLineNum = 4129054;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=4129055;
 //BA.debugLineNum = 4129055;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="Starter.company_selected = selectedCompany";
mostCurrent._starter._company_selected /*String*/  = _selectedcompany;
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="End Sub";
return "";
}
public static String  _nxtbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtbtn_click", null));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub nxtBtn_Click";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Log(\"sad\")";
anywheresoftware.b4a.keywords.Common.LogImpl("34325377","sad",0);
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="End Sub";
return "";
}
}