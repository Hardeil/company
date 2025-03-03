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
vis = vis | (branch.mostCurrent != null);
vis = vis | (device.mostCurrent != null);
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
            if (branch.previousOne != null) {
				__a = branch.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(branch.mostCurrent == null ? null : branch.mostCurrent.processBA);
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
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static String _company = "";
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public static String _phpurl = "";
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _navigate = null;
public static int _titlefontsize = 0;
public static int _primaryfontsize = 0;
public static int _secondaryfontsize = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public b4a.example.bargraph _bargraph = null;
public b4a.example.bargraph _bargraph1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _barpanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
public static String[] _legend = null;
public anywheresoftware.b4a.objects.PanelWrapper _purchasepanel = null;
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
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
 //BA.debugLineNum = 131074;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
mostCurrent._label1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (225),(int) (218),(int) (218)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (189),(int) (202),(int) (217))});
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="ScrollView1.Background = gradient";
mostCurrent._scrollview1.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="ScrollView1.Panel.Height = Activity.Height";
mostCurrent._scrollview1.getPanel().setHeight(mostCurrent._activity.getHeight());
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="barPanel.Initialize(\"\")";
mostCurrent._barpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="Panel1.AddView(barPanel,25dip,Panel2.Height+20dip";
mostCurrent._panel1.AddView((android.view.View)(mostCurrent._barpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (mostCurrent._panel2.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="Panel1.AddView(purchasePanel,25dip,barPanel.top+b";
mostCurrent._panel1.AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (mostCurrent._barpanel.getTop()+mostCurrent._barpanel.getHeight()+mostCurrent._panel2.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Try";
try {RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",main.getObject());
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("03670023",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="End Sub";
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
public static Object  _getmapvalueordefault(anywheresoftware.b4a.objects.collections.Map _m,String _key,Object _defaultvalue) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getmapvalueordefault", false))
	 {return ((Object) Debug.delegate(mostCurrent.activityBA, "getmapvalueordefault", new Object[] {_m,_key,_defaultvalue}));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="If m.ContainsKey(Key) Then";
if (_m.ContainsKey((Object)(_key))) { 
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Return m.Get(Key)";
if (true) return _m.Get((Object)(_key));
 }else {
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="End Sub";
return null;
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _scrollheight = 0;
anywheresoftware.b4a.objects.collections.List _salesarray = null;
int _numcolumns = 0;
int _pnlwidth = 0;
int _pnlheight = 0;
int _padding = 0;
int _leftposition = 0;
int _topposition = 0;
int _count = 0;
anywheresoftware.b4a.objects.collections.Map _record = null;
String _name = "";
int _company_id = 0;
int _total_count = 0;
int _total_pos = 0;
anywheresoftware.b4a.objects.PanelWrapper _panel = null;
anywheresoftware.b4a.objects.LabelWrapper _label17 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _myimage = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _resizedimage = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
int _panelwidth = 0;
int _labelheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _totalstore = null;
anywheresoftware.b4a.objects.LabelWrapper _totalstorelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpos = null;
anywheresoftware.b4a.objects.LabelWrapper _totalposlabel = null;
int _i = 0;
String _currentcomid = "";
anywheresoftware.b4a.objects.collections.List _branches = null;
int _totalbranches = 0;
String[] _branchnames = null;
int[] _branchsales1 = null;
int[] _branchsales2 = null;
int[] _branchsales3 = null;
int _j = 0;
anywheresoftware.b4a.objects.collections.Map _branchmap = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _totalcompanies = 0;
int[] _sales = null;
int[] _sales1 = null;
int[] _sales2 = null;
int[] _purchase = null;
int[] _purchase1 = null;
int[] _purchase2 = null;
String[] _companyname = null;
int[] _max_value = null;
int _maxsale = 0;
String[] _comname = null;
anywheresoftware.b4a.objects.ButtonWrapper _nxtbtn = null;
anywheresoftware.b4a.objects.ButtonWrapper _backbtn = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="Try";
try {RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","UpdateData")) {
case 0: {
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=3735567;
 //BA.debugLineNum = 3735567;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735568;
 //BA.debugLineNum = 3735568;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3735572;
 //BA.debugLineNum = 3735572;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
_numcolumns = (int) (2);
RDebugUtils.currentLine=3735573;
 //BA.debugLineNum = 3735573;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
_pnlwidth = (int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=3735574;
 //BA.debugLineNum = 3735574;BA.debugLine="Dim pnlHeight As Int = 280dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280));
RDebugUtils.currentLine=3735575;
 //BA.debugLineNum = 3735575;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=3735576;
 //BA.debugLineNum = 3735576;BA.debugLine="Dim leftPosition As Int = 50dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=3735577;
 //BA.debugLineNum = 3735577;BA.debugLine="Dim topPosition As Int = 77dip";
_topposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (77));
RDebugUtils.currentLine=3735578;
 //BA.debugLineNum = 3735578;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=3735579;
 //BA.debugLineNum = 3735579;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=3735580;
 //BA.debugLineNum = 3735580;BA.debugLine="pnlWidth = 490dip";
_pnlwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (490));
RDebugUtils.currentLine=3735581;
 //BA.debugLineNum = 3735581;BA.debugLine="pnlHeight = 300dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300));
RDebugUtils.currentLine=3735582;
 //BA.debugLineNum = 3735582;BA.debugLine="padding = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=3735583;
 //BA.debugLineNum = 3735583;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 };
RDebugUtils.currentLine=3735586;
 //BA.debugLineNum = 3735586;BA.debugLine="For Each record As Map In salesArray";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group27 = _salesarray;
final int groupLen27 = group27.getSize()
;int index27 = 0;
;
for (; index27 < groupLen27;index27++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group27.Get(index27)));
RDebugUtils.currentLine=3735587;
 //BA.debugLineNum = 3735587;BA.debugLine="Dim name As String = record.Get(\"company_nam";
_name = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=3735588;
 //BA.debugLineNum = 3735588;BA.debugLine="Dim company_id As Int = record.Get(\"comId\")";
_company_id = (int)(BA.ObjectToNumber(_record.Get((Object)("comId"))));
RDebugUtils.currentLine=3735589;
 //BA.debugLineNum = 3735589;BA.debugLine="Dim total_count As Int = record.Get(\"total_c";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("total_count"))));
RDebugUtils.currentLine=3735590;
 //BA.debugLineNum = 3735590;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDevi";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=3735593;
 //BA.debugLineNum = 3735593;BA.debugLine="Dim Panel As Panel";
_panel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3735594;
 //BA.debugLineNum = 3735594;BA.debugLine="Panel.Initialize(\"Panel\")";
_panel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=3735596;
 //BA.debugLineNum = 3735596;BA.debugLine="Panel.Color = Colors.Black";
_panel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3735599;
 //BA.debugLineNum = 3735599;BA.debugLine="Dim Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3735600;
 //BA.debugLineNum = 3735600;BA.debugLine="Panel2.Initialize(\"Panel2\")";
mostCurrent._panel2.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=3735601;
 //BA.debugLineNum = 3735601;BA.debugLine="Panel2.Color = Colors.Black";
mostCurrent._panel2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3735602;
 //BA.debugLineNum = 3735602;BA.debugLine="Panel2.Tag = name";
mostCurrent._panel2.setTag((Object)(_name));
RDebugUtils.currentLine=3735603;
 //BA.debugLineNum = 3735603;BA.debugLine="Panel2.SendToBack";
mostCurrent._panel2.SendToBack();
RDebugUtils.currentLine=3735607;
 //BA.debugLineNum = 3735607;BA.debugLine="Dim Label17 As Label";
_label17 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3735608;
 //BA.debugLineNum = 3735608;BA.debugLine="Label17.Initialize(\"Label17\")";
_label17.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=3735609;
 //BA.debugLineNum = 3735609;BA.debugLine="Label17.Text = name";
_label17.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=3735610;
 //BA.debugLineNum = 3735610;BA.debugLine="Label17.Tag = company_id";
_label17.setTag((Object)(_company_id));
RDebugUtils.currentLine=3735611;
 //BA.debugLineNum = 3735611;BA.debugLine="Label17.TextSize = 18";
_label17.setTextSize((float) (18));
RDebugUtils.currentLine=3735612;
 //BA.debugLineNum = 3735612;BA.debugLine="Label17.TextColor = Colors.White";
_label17.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3735613;
 //BA.debugLineNum = 3735613;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
_label17.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=3735614;
 //BA.debugLineNum = 3735614;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
_label17.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3735617;
 //BA.debugLineNum = 3735617;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3735618;
 //BA.debugLineNum = 3735618;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=3735619;
 //BA.debugLineNum = 3735619;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=3735620;
 //BA.debugLineNum = 3735620;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735621;
 //BA.debugLineNum = 3735621;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=3735622;
 //BA.debugLineNum = 3735622;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3735623;
 //BA.debugLineNum = 3735623;BA.debugLine="imgView.Bitmap = resizedImage";
_imgview.setBitmap((android.graphics.Bitmap)(_resizedimage.getObject()));
 }else {
RDebugUtils.currentLine=3735626;
 //BA.debugLineNum = 3735626;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("03735626","Error loading image",0);
 };
RDebugUtils.currentLine=3735629;
 //BA.debugLineNum = 3735629;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
_panelwidth = (int) (_panel.getWidth()/(double)3);
RDebugUtils.currentLine=3735630;
 //BA.debugLineNum = 3735630;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=3735631;
 //BA.debugLineNum = 3735631;BA.debugLine="Dim labelheight As Int = 35dip";
_labelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35));
RDebugUtils.currentLine=3735634;
 //BA.debugLineNum = 3735634;BA.debugLine="panelWidth = Panel.Width /2";
_panelwidth = (int) (_panel.getWidth()/(double)2);
RDebugUtils.currentLine=3735636;
 //BA.debugLineNum = 3735636;BA.debugLine="Dim totalStore As Label";
_totalstore = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3735637;
 //BA.debugLineNum = 3735637;BA.debugLine="totalStore.Initialize(\"\")";
_totalstore.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3735638;
 //BA.debugLineNum = 3735638;BA.debugLine="totalStore.Text = total_count";
_totalstore.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=3735639;
 //BA.debugLineNum = 3735639;BA.debugLine="totalStore.TextColor = Colors.Black";
_totalstore.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3735640;
 //BA.debugLineNum = 3735640;BA.debugLine="totalStore.TextSize = primaryFontSize";
_totalstore.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=3735641;
 //BA.debugLineNum = 3735641;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
_totalstore.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3735642;
 //BA.debugLineNum = 3735642;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
_totalstore.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=3735645;
 //BA.debugLineNum = 3735645;BA.debugLine="Dim totalStoreLabel As Label";
_totalstorelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3735646;
 //BA.debugLineNum = 3735646;BA.debugLine="totalStoreLabel.Initialize(\"\")";
_totalstorelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3735647;
 //BA.debugLineNum = 3735647;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
_totalstorelabel.setText(BA.ObjectToCharSequence(" Total Store"));
RDebugUtils.currentLine=3735648;
 //BA.debugLineNum = 3735648;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
_totalstorelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=3735649;
 //BA.debugLineNum = 3735649;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSize";
_totalstorelabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=3735650;
 //BA.debugLineNum = 3735650;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
_totalstorelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3735651;
 //BA.debugLineNum = 3735651;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPAC";
_totalstorelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3735652;
 //BA.debugLineNum = 3735652;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text.";
_totalstorelabel.setText(BA.ObjectToCharSequence(_totalstorelabel.getText().toUpperCase()));
RDebugUtils.currentLine=3735655;
 //BA.debugLineNum = 3735655;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3735656;
 //BA.debugLineNum = 3735656;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3735657;
 //BA.debugLineNum = 3735657;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=3735658;
 //BA.debugLineNum = 3735658;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3735659;
 //BA.debugLineNum = 3735659;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=3735660;
 //BA.debugLineNum = 3735660;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3735661;
 //BA.debugLineNum = 3735661;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=3735664;
 //BA.debugLineNum = 3735664;BA.debugLine="Dim totalPosLabel As Label";
_totalposlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3735665;
 //BA.debugLineNum = 3735665;BA.debugLine="totalPosLabel.Initialize(\"\")";
_totalposlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3735666;
 //BA.debugLineNum = 3735666;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
_totalposlabel.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=3735667;
 //BA.debugLineNum = 3735667;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
_totalposlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=3735668;
 //BA.debugLineNum = 3735668;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
_totalposlabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=3735669;
 //BA.debugLineNum = 3735669;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
_totalposlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3735670;
 //BA.debugLineNum = 3735670;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
_totalposlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=3735671;
 //BA.debugLineNum = 3735671;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToUp";
_totalposlabel.setText(BA.ObjectToCharSequence(_totalposlabel.getText().toUpperCase()));
RDebugUtils.currentLine=3735673;
 //BA.debugLineNum = 3735673;BA.debugLine="For i = 0 To salesArray.Size - 1";
{
final int step92 = 1;
final int limit92 = (int) (_salesarray.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit92 ;_i = _i + step92 ) {
RDebugUtils.currentLine=3735675;
 //BA.debugLineNum = 3735675;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=3735676;
 //BA.debugLineNum = 3735676;BA.debugLine="Dim currentComId As String = record.Get(\"comI";
_currentcomid = BA.ObjectToString(_record.Get((Object)("comId")));
RDebugUtils.currentLine=3735679;
 //BA.debugLineNum = 3735679;BA.debugLine="If currentComId = 1 Then";
if ((_currentcomid).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=3735682;
 //BA.debugLineNum = 3735682;BA.debugLine="If record.ContainsKey(\"branches\") Then";
if (_record.ContainsKey((Object)("branches"))) { 
RDebugUtils.currentLine=3735683;
 //BA.debugLineNum = 3735683;BA.debugLine="Dim branches As List = record.Get(\"branches\"";
_branches = new anywheresoftware.b4a.objects.collections.List();
_branches = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_record.Get((Object)("branches"))));
RDebugUtils.currentLine=3735684;
 //BA.debugLineNum = 3735684;BA.debugLine="Dim totalBranches As Int = branches.Size";
_totalbranches = _branches.getSize();
RDebugUtils.currentLine=3735687;
 //BA.debugLineNum = 3735687;BA.debugLine="Dim branchNames(totalBranches) As String";
_branchnames = new String[_totalbranches];
java.util.Arrays.fill(_branchnames,"");
RDebugUtils.currentLine=3735688;
 //BA.debugLineNum = 3735688;BA.debugLine="Dim branchSales1(totalBranches) As Int";
_branchsales1 = new int[_totalbranches];
;
RDebugUtils.currentLine=3735689;
 //BA.debugLineNum = 3735689;BA.debugLine="Dim branchSales2(totalBranches) As Int";
_branchsales2 = new int[_totalbranches];
;
RDebugUtils.currentLine=3735690;
 //BA.debugLineNum = 3735690;BA.debugLine="Dim branchSales3(totalBranches) As Int";
_branchsales3 = new int[_totalbranches];
;
RDebugUtils.currentLine=3735693;
 //BA.debugLineNum = 3735693;BA.debugLine="For j = 0 To totalBranches - 1";
{
final int step103 = 1;
final int limit103 = (int) (_totalbranches-1);
_j = (int) (0) ;
for (;_j <= limit103 ;_j = _j + step103 ) {
RDebugUtils.currentLine=3735694;
 //BA.debugLineNum = 3735694;BA.debugLine="Dim branchMap As Map = branches.Get(j)";
_branchmap = new anywheresoftware.b4a.objects.collections.Map();
_branchmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_branches.Get(_j)));
RDebugUtils.currentLine=3735695;
 //BA.debugLineNum = 3735695;BA.debugLine="branchNames(j) = branchMap.GetDefault(\"b";
_branchnames[_j] = (BA.ObjectToString(_branchmap.GetDefault((Object)("branch_name"),(Object)(""))));
RDebugUtils.currentLine=3735696;
 //BA.debugLineNum = 3735696;BA.debugLine="branchSales1(j) = branchMap.GetDefault(\"";
_branchsales1[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales1"),(Object)(0))));
RDebugUtils.currentLine=3735697;
 //BA.debugLineNum = 3735697;BA.debugLine="branchSales2(j) = branchMap.GetDefault(\"";
_branchsales2[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales2"),(Object)(0))));
RDebugUtils.currentLine=3735698;
 //BA.debugLineNum = 3735698;BA.debugLine="branchSales3(j) = branchMap.GetDefault(\"";
_branchsales3[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales3"),(Object)(0))));
 }
};
RDebugUtils.currentLine=3735709;
 //BA.debugLineNum = 3735709;BA.debugLine="Dim legend() As String = Array As String(";
mostCurrent._legend = new String[]{"Sales1","Sales2","Sales3"};
 }else {
RDebugUtils.currentLine=3735712;
 //BA.debugLineNum = 3735712;BA.debugLine="Log($\"Company: ${name} has no branches inform";
anywheresoftware.b4a.keywords.Common.LogImpl("03735712",("Company: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_name))+" has no branches information."),0);
 };
 };
 }
};
RDebugUtils.currentLine=3735721;
 //BA.debugLineNum = 3735721;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=3735722;
 //BA.debugLineNum = 3735722;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
RDebugUtils.currentLine=3735723;
 //BA.debugLineNum = 3735723;BA.debugLine="If count Mod numColumns = 0 Then";
if (_count%_numcolumns==0) { 
RDebugUtils.currentLine=3735725;
 //BA.debugLineNum = 3735725;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=3735726;
 //BA.debugLineNum = 3735726;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
_topposition = (int) (_topposition+_pnlheight+_padding);
 }else {
RDebugUtils.currentLine=3735729;
 //BA.debugLineNum = 3735729;BA.debugLine="leftPosition = leftPosition + pnlWidth + p";
_leftposition = (int) (_leftposition+_pnlwidth+_padding);
 };
RDebugUtils.currentLine=3735731;
 //BA.debugLineNum = 3735731;BA.debugLine="scrollHeight = scrollHeight + 175dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (175)));
 }else {
RDebugUtils.currentLine=3735733;
 //BA.debugLineNum = 3735733;BA.debugLine="topPosition = topPosition + pnlHeight + pad";
_topposition = (int) (_topposition+_pnlheight+_padding);
RDebugUtils.currentLine=3735734;
 //BA.debugLineNum = 3735734;BA.debugLine="scrollHeight = scrollHeight + 300dip + padd";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300))+_padding);
 };
RDebugUtils.currentLine=3735738;
 //BA.debugLineNum = 3735738;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=3735739;
 //BA.debugLineNum = 3735739;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 1dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3735740;
 //BA.debugLineNum = 3735740;BA.debugLine="Panel.Background = cd";
_panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 }
};
RDebugUtils.currentLine=3735743;
 //BA.debugLineNum = 3735743;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
_totalcompanies = _salesarray.getSize();
RDebugUtils.currentLine=3735744;
 //BA.debugLineNum = 3735744;BA.debugLine="Dim sales(totalCompanies) As Int";
_sales = new int[_totalcompanies];
;
RDebugUtils.currentLine=3735745;
 //BA.debugLineNum = 3735745;BA.debugLine="Dim sales1(totalCompanies) As Int";
_sales1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=3735746;
 //BA.debugLineNum = 3735746;BA.debugLine="Dim sales2(totalCompanies) As Int";
_sales2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=3735747;
 //BA.debugLineNum = 3735747;BA.debugLine="Dim purchase(totalCompanies) As Int";
_purchase = new int[_totalcompanies];
;
RDebugUtils.currentLine=3735748;
 //BA.debugLineNum = 3735748;BA.debugLine="Dim purchase1(totalCompanies) As Int";
_purchase1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=3735749;
 //BA.debugLineNum = 3735749;BA.debugLine="Dim purchase2(totalCompanies) As Int";
_purchase2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=3735750;
 //BA.debugLineNum = 3735750;BA.debugLine="Dim companyName(totalCompanies) As String";
_companyname = new String[_totalcompanies];
java.util.Arrays.fill(_companyname,"");
RDebugUtils.currentLine=3735751;
 //BA.debugLineNum = 3735751;BA.debugLine="Dim max_value(totalCompanies) As Int";
_max_value = new int[_totalcompanies];
;
RDebugUtils.currentLine=3735752;
 //BA.debugLineNum = 3735752;BA.debugLine="Dim maxSale As Int=0";
_maxsale = (int) (0);
RDebugUtils.currentLine=3735754;
 //BA.debugLineNum = 3735754;BA.debugLine="For i = 0 To totalCompanies - 1";
{
final int step143 = 1;
final int limit143 = (int) (_totalcompanies-1);
_i = (int) (0) ;
for (;_i <= limit143 ;_i = _i + step143 ) {
RDebugUtils.currentLine=3735755;
 //BA.debugLineNum = 3735755;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=3735756;
 //BA.debugLineNum = 3735756;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
_companyname[_i] = BA.ObjectToString(_record.GetDefault((Object)("company_name"),(Object)("Unknown")));
RDebugUtils.currentLine=3735757;
 //BA.debugLineNum = 3735757;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
_sales[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_1"),(Object)(0))));
RDebugUtils.currentLine=3735758;
 //BA.debugLineNum = 3735758;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
_sales1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_2"),(Object)(0))));
RDebugUtils.currentLine=3735759;
 //BA.debugLineNum = 3735759;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
_sales2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_3"),(Object)(0))));
RDebugUtils.currentLine=3735760;
 //BA.debugLineNum = 3735760;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
_purchase[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_1"),(Object)(0))));
RDebugUtils.currentLine=3735761;
 //BA.debugLineNum = 3735761;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
_purchase1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_2"),(Object)(0))));
RDebugUtils.currentLine=3735762;
 //BA.debugLineNum = 3735762;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_\"";
_purchase2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_"),(Object)(0))));
RDebugUtils.currentLine=3735763;
 //BA.debugLineNum = 3735763;BA.debugLine="max_value(i) = record.GetDefault(\"max_value\"";
_max_value[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("max_value"),(Object)(0))));
RDebugUtils.currentLine=3735764;
 //BA.debugLineNum = 3735764;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
_maxsale = (int) (anywheresoftware.b4a.keywords.Common.Max(_maxsale,_max_value[_i]));
 }
};
RDebugUtils.currentLine=3735767;
 //BA.debugLineNum = 3735767;BA.debugLine="barPanel.RemoveAllViews";
mostCurrent._barpanel.RemoveAllViews();
RDebugUtils.currentLine=3735768;
 //BA.debugLineNum = 3735768;BA.debugLine="barPanel.Invalidate ' Force redraw";
mostCurrent._barpanel.Invalidate();
RDebugUtils.currentLine=3735770;
 //BA.debugLineNum = 3735770;BA.debugLine="Dim comName() As String = Array As String(\"EZ";
_comname = new String[]{"EZWARE","EZWARE1","EZWARE2","EZWARE3"};
RDebugUtils.currentLine=3735771;
 //BA.debugLineNum = 3735771;BA.debugLine="Dim nxtBtn As Button";
_nxtbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3735772;
 //BA.debugLineNum = 3735772;BA.debugLine="Dim backBtn As Button";
_backbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3735773;
 //BA.debugLineNum = 3735773;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
mostCurrent._legend = new String[]{"Sales1","Sales2","Sales3"};
RDebugUtils.currentLine=3735775;
 //BA.debugLineNum = 3735775;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purchas";
mostCurrent._legend = new String[]{"Purchase1","Purchase2","Purchase3"};
RDebugUtils.currentLine=3735776;
 //BA.debugLineNum = 3735776;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel,";
mostCurrent._bargraph1._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_purchase,_purchase1,_purchase2,_companyname,mostCurrent._legend,_maxsale,"Total Purchase of the Company");
 break; }
case 1: {
RDebugUtils.currentLine=3735778;
 //BA.debugLineNum = 3735778;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3735779;
 //BA.debugLineNum = 3735779;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=3735781;
 //BA.debugLineNum = 3735781;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("03735781","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e170) {
			processBA.setLastException(e170);RDebugUtils.currentLine=3735784;
 //BA.debugLineNum = 3735784;BA.debugLine="ToastMessageShow(\"Error parsing sales data\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing sales data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=3735787;
 //BA.debugLineNum = 3735787;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3735789;
 //BA.debugLineNum = 3735789;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=3735790;
 //BA.debugLineNum = 3735790;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="Starter.company_selected = selectedCompany";
mostCurrent._starter._company_selected /*String*/  = _selectedcompany;
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="End Sub";
return "";
}
}