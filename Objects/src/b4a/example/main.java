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
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Try";
try {RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",main.getObject());
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("6196615",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _adjustfontsizetoheight(anywheresoftware.b4a.objects.LabelWrapper _lbl,float _fontnum) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "adjustfontsizetoheight", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "adjustfontsizetoheight", new Object[] {_lbl,_fontnum}));}
float _fontsize = 0f;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub AdjustFontSizeToHeight(lbl As Label,fontNum As";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Dim fontSize As Float = lbl.Height * fontNum / Ge";
_fontsize = (float) (_lbl.getHeight()*_fontnum/(double)_getdevicedensity());
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="lbl.TextSize = fontSize";
_lbl.setTextSize(_fontsize);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="End Sub";
return "";
}
public static float  _getdevicedensity() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getdevicedensity", false))
	 {return ((Float) Debug.delegate(mostCurrent.activityBA, "getdevicedensity", null));}
int _pixelwidth = 0;
int _dipwidth = 0;
float _dense = 0f;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub GetDeviceDensity As Float";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim pixelWidth As Int = 100%x ' Screen width in p";
_pixelwidth = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA);
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim dipWidth As Int = 100dip  ' 100 DIPs in pixel";
_dipwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Dim Dense As Float = pixelWidth / dipWidth";
_dense = (float) (_pixelwidth/(double)_dipwidth);
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="Return Dense";
if (true) return _dense;
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="End Sub";
return 0f;
}
public static Object  _getmapvalueordefault(anywheresoftware.b4a.objects.collections.Map _m,String _key,Object _defaultvalue) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getmapvalueordefault", false))
	 {return ((Object) Debug.delegate(mostCurrent.activityBA, "getmapvalueordefault", new Object[] {_m,_key,_defaultvalue}));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="If m.ContainsKey(Key) Then";
if (_m.ContainsKey((Object)(_key))) { 
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Return m.Get(Key)";
if (true) return _m.Get((Object)(_key));
 }else {
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.PanelWrapper _companypanel = null;
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
int[] _comid = null;
int[] _sales1 = null;
int[] _sales2 = null;
int[] _purchase = null;
int[] _purchase1 = null;
int[] _purchase2 = null;
String[] _companyname = null;
int[] _max_value = null;
int _maxsale = 0;
anywheresoftware.b4a.objects.PanelWrapper _totalsalepanel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalsalelabel = null;
anywheresoftware.b4a.objects.PanelWrapper _shadowpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _totalpurchasepanel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpurchaselabel = null;
anywheresoftware.b4a.objects.PanelWrapper _shadowpurchpanel = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Try";
try {RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","UpdateData")) {
case 0: {
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=262159;
 //BA.debugLineNum = 262159;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=262160;
 //BA.debugLineNum = 262160;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=262162;
 //BA.debugLineNum = 262162;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=262163;
 //BA.debugLineNum = 262163;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="Dim rowNum As Int = 3";
_rownum = (int) (3);
RDebugUtils.currentLine=262166;
 //BA.debugLineNum = 262166;BA.debugLine="Dim mainPanelWidth As Int = 0";
_mainpanelwidth = (int) (0);
RDebugUtils.currentLine=262167;
 //BA.debugLineNum = 262167;BA.debugLine="Dim panelHeight As Int = 150dip ' Adjust heig";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150));
RDebugUtils.currentLine=262168;
 //BA.debugLineNum = 262168;BA.debugLine="height = panelHeight - 70dip";
_height = (int) (_panelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=262170;
 //BA.debugLineNum = 262170;BA.debugLine="For Each record As Map In salesArray";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group20 = _salesarray;
final int groupLen20 = group20.getSize()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group20.Get(index20)));
RDebugUtils.currentLine=262172;
 //BA.debugLineNum = 262172;BA.debugLine="If count Mod 3 = 0 Then";
if (_count%3==0) { 
RDebugUtils.currentLine=262173;
 //BA.debugLineNum = 262173;BA.debugLine="height = height + panelHeight";
_height = (int) (_height+_panelheight);
 };
RDebugUtils.currentLine=262176;
 //BA.debugLineNum = 262176;BA.debugLine="Dim col As Int = count Mod 3  ' Column posi";
_col = (int) (_count%3);
RDebugUtils.currentLine=262177;
 //BA.debugLineNum = 262177;BA.debugLine="Dim row As Int = Floor(count / 3)";
_row = (int) (anywheresoftware.b4a.keywords.Common.Floor(_count/(double)3));
RDebugUtils.currentLine=262179;
 //BA.debugLineNum = 262179;BA.debugLine="Dim name As String = record.Get(\"company_na";
_name = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=262180;
 //BA.debugLineNum = 262180;BA.debugLine="Dim company_id As Int = record.Get(\"comId\")";
_company_id = (int)(BA.ObjectToNumber(_record.Get((Object)("comId"))));
RDebugUtils.currentLine=262181;
 //BA.debugLineNum = 262181;BA.debugLine="Dim total_count As Int = record.Get(\"total_";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("total_count"))));
RDebugUtils.currentLine=262182;
 //BA.debugLineNum = 262182;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDev";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=262184;
 //BA.debugLineNum = 262184;BA.debugLine="Dim dashPanel As Panel";
_dashpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262185;
 //BA.debugLineNum = 262185;BA.debugLine="dashPanel.Initialize(\"\")";
_dashpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262186;
 //BA.debugLineNum = 262186;BA.debugLine="ScrollView1.Panel.AddView(dashPanel, 5dip,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_dashpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),mostCurrent._panel2.getHeight(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=262189;
 //BA.debugLineNum = 262189;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=262190;
 //BA.debugLineNum = 262190;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"dashb";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dashboard.png");
RDebugUtils.currentLine=262192;
 //BA.debugLineNum = 262192;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=262193;
 //BA.debugLineNum = 262193;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262194;
 //BA.debugLineNum = 262194;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=262195;
 //BA.debugLineNum = 262195;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=262196;
 //BA.debugLineNum = 262196;BA.debugLine="dashPanel.AddView(imgView, 0dip, 12.5dip, 1";
_dashpanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_dashpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=262198;
 //BA.debugLineNum = 262198;BA.debugLine="Dim dashLabel As Label";
_dashlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262199;
 //BA.debugLineNum = 262199;BA.debugLine="dashLabel.Initialize(\"\")";
_dashlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262200;
 //BA.debugLineNum = 262200;BA.debugLine="dashLabel.Text = \"Dashboard\"";
_dashlabel.setText(BA.ObjectToCharSequence("Dashboard"));
RDebugUtils.currentLine=262201;
 //BA.debugLineNum = 262201;BA.debugLine="dashLabel.TextColor = Colors.ARGB(50,156,0,";
_dashlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (156),(int) (0),(int) (0)));
RDebugUtils.currentLine=262202;
 //BA.debugLineNum = 262202;BA.debugLine="dashLabel.Gravity = Gravity.CENTER_VERTICAL";
_dashlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=262203;
 //BA.debugLineNum = 262203;BA.debugLine="dashLabel.Typeface = Typeface.MONOSPACE";
_dashlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=262204;
 //BA.debugLineNum = 262204;BA.debugLine="dashPanel.AddView(dashLabel, imgView.Width+";
_dashpanel.AddView((android.view.View)(_dashlabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_dashpanel.getWidth(),_dashpanel.getHeight());
RDebugUtils.currentLine=262205;
 //BA.debugLineNum = 262205;BA.debugLine="AdjustFontSizeToHeight(dashLabel,2)";
_adjustfontsizetoheight(_dashlabel,(float) (2));
RDebugUtils.currentLine=262207;
 //BA.debugLineNum = 262207;BA.debugLine="Dim companyPanel As Panel";
_companypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262208;
 //BA.debugLineNum = 262208;BA.debugLine="companyPanel.Initialize(\"Panel\")";
_companypanel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=262209;
 //BA.debugLineNum = 262209;BA.debugLine="ScrollView1.Panel.AddView(companyPanel, 5di";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_companypanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),_dashpanel.getHeight(),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),_height);
RDebugUtils.currentLine=262212;
 //BA.debugLineNum = 262212;BA.debugLine="mainPanelWidth = companyPanel.Width / rowNu";
_mainpanelwidth = (int) (_companypanel.getWidth()/(double)_rownum);
RDebugUtils.currentLine=262213;
 //BA.debugLineNum = 262213;BA.debugLine="Dim Panel As Panel";
_panel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262214;
 //BA.debugLineNum = 262214;BA.debugLine="Panel.Initialize(\"\")";
_panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262215;
 //BA.debugLineNum = 262215;BA.debugLine="companyPanel.AddView(Panel, col * (mainPane";
_companypanel.AddView((android.view.View)(_panel.getObject()),(int) (_col*(_mainpanelwidth+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)))),(int) (mostCurrent._panel2.getHeight()+(_row*(_panelheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))))),(int) (_mainpanelwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),_panelheight);
RDebugUtils.currentLine=262217;
 //BA.debugLineNum = 262217;BA.debugLine="Dim PanelTitle As Panel";
_paneltitle = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262218;
 //BA.debugLineNum = 262218;BA.debugLine="PanelTitle.Initialize(\"Panel2\")";
_paneltitle.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=262219;
 //BA.debugLineNum = 262219;BA.debugLine="PanelTitle.Color = Colors.Black";
_paneltitle.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262220;
 //BA.debugLineNum = 262220;BA.debugLine="PanelTitle.Tag = name";
_paneltitle.setTag((Object)(_name));
RDebugUtils.currentLine=262221;
 //BA.debugLineNum = 262221;BA.debugLine="Panel.AddView(PanelTitle, 0, 0, Panel.Width";
_panel.AddView((android.view.View)(_paneltitle.getObject()),(int) (0),(int) (0),_panel.getWidth(),(int) (_panelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))));
RDebugUtils.currentLine=262224;
 //BA.debugLineNum = 262224;BA.debugLine="Dim Label17 As Label";
_label17 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262225;
 //BA.debugLineNum = 262225;BA.debugLine="Label17.Initialize(\"Label17\")";
_label17.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=262226;
 //BA.debugLineNum = 262226;BA.debugLine="Label17.Text = name.ToUpperCase";
_label17.setText(BA.ObjectToCharSequence(_name.toUpperCase()));
RDebugUtils.currentLine=262227;
 //BA.debugLineNum = 262227;BA.debugLine="Label17.Tag = company_id";
_label17.setTag((Object)(_company_id));
RDebugUtils.currentLine=262228;
 //BA.debugLineNum = 262228;BA.debugLine="Label17.TextSize = 18";
_label17.setTextSize((float) (18));
RDebugUtils.currentLine=262229;
 //BA.debugLineNum = 262229;BA.debugLine="Label17.TextColor = Colors.White";
_label17.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=262230;
 //BA.debugLineNum = 262230;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
_label17.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=262231;
 //BA.debugLineNum = 262231;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
_label17.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=262232;
 //BA.debugLineNum = 262232;BA.debugLine="PanelTitle.AddView(Label17, 5dip, 0dip, Pan";
_paneltitle.AddView((android.view.View)(_label17.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_paneltitle.getWidth(),_paneltitle.getHeight());
RDebugUtils.currentLine=262233;
 //BA.debugLineNum = 262233;BA.debugLine="AdjustFontSizeToHeight(Label17,2)";
_adjustfontsizetoheight(_label17,(float) (2));
RDebugUtils.currentLine=262235;
 //BA.debugLineNum = 262235;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=262236;
 //BA.debugLineNum = 262236;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrow";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=262237;
 //BA.debugLineNum = 262237;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=262238;
 //BA.debugLineNum = 262238;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resiz";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=262239;
 //BA.debugLineNum = 262239;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=262240;
 //BA.debugLineNum = 262240;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262241;
 //BA.debugLineNum = 262241;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=262242;
 //BA.debugLineNum = 262242;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=262243;
 //BA.debugLineNum = 262243;BA.debugLine="PanelTitle.AddView(imgView, PanelTitle.Wid";
_paneltitle.AddView((android.view.View)(_imgview.getObject()),(int) (_paneltitle.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),(int) (_paneltitle.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 }else {
RDebugUtils.currentLine=262245;
 //BA.debugLineNum = 262245;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6262245","Error loading image",0);
 };
RDebugUtils.currentLine=262248;
 //BA.debugLineNum = 262248;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
_panelwidth = (int) (_panel.getWidth()/(double)3);
RDebugUtils.currentLine=262249;
 //BA.debugLineNum = 262249;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=262250;
 //BA.debugLineNum = 262250;BA.debugLine="Dim labelheight As Int = panelHeight - Pane";
_labelheight = (int) (_panelheight-_paneltitle.getHeight());
RDebugUtils.currentLine=262251;
 //BA.debugLineNum = 262251;BA.debugLine="panelWidth = Panel.Width /2";
_panelwidth = (int) (_panel.getWidth()/(double)2);
RDebugUtils.currentLine=262253;
 //BA.debugLineNum = 262253;BA.debugLine="Dim totalStore As Label";
_totalstore = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262254;
 //BA.debugLineNum = 262254;BA.debugLine="totalStore.Initialize(\"\")";
_totalstore.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262255;
 //BA.debugLineNum = 262255;BA.debugLine="totalStore.Text = total_count";
_totalstore.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=262256;
 //BA.debugLineNum = 262256;BA.debugLine="totalStore.TextColor = Colors.Black";
_totalstore.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262257;
 //BA.debugLineNum = 262257;BA.debugLine="totalStore.TextSize = primaryFontSize";
_totalstore.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=262258;
 //BA.debugLineNum = 262258;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
_totalstore.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262259;
 //BA.debugLineNum = 262259;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
_totalstore.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=262260;
 //BA.debugLineNum = 262260;BA.debugLine="Panel.AddView(totalStore,0,PanelTitle.Heigh";
_panel.AddView((android.view.View)(_totalstore.getObject()),(int) (0),_paneltitle.getHeight(),_panelwidth,(int) (_labelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))));
RDebugUtils.currentLine=262261;
 //BA.debugLineNum = 262261;BA.debugLine="AdjustFontSizeToHeight(totalStore,1.3)";
_adjustfontsizetoheight(_totalstore,(float) (1.3));
RDebugUtils.currentLine=262263;
 //BA.debugLineNum = 262263;BA.debugLine="Dim totalStoreLabel As Label";
_totalstorelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262264;
 //BA.debugLineNum = 262264;BA.debugLine="totalStoreLabel.Initialize(\"\")";
_totalstorelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262265;
 //BA.debugLineNum = 262265;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
_totalstorelabel.setText(BA.ObjectToCharSequence(" Total Store"));
RDebugUtils.currentLine=262266;
 //BA.debugLineNum = 262266;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
_totalstorelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=262267;
 //BA.debugLineNum = 262267;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSiz";
_totalstorelabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=262268;
 //BA.debugLineNum = 262268;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
_totalstorelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262269;
 //BA.debugLineNum = 262269;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPA";
_totalstorelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=262270;
 //BA.debugLineNum = 262270;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text";
_totalstorelabel.setText(BA.ObjectToCharSequence(_totalstorelabel.getText().toUpperCase()));
RDebugUtils.currentLine=262271;
 //BA.debugLineNum = 262271;BA.debugLine="Panel.AddView(totalStoreLabel,0,totalStore.";
_panel.AddView((android.view.View)(_totalstorelabel.getObject()),(int) (0),(int) (_totalstore.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=262273;
 //BA.debugLineNum = 262273;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262274;
 //BA.debugLineNum = 262274;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262275;
 //BA.debugLineNum = 262275;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=262276;
 //BA.debugLineNum = 262276;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262277;
 //BA.debugLineNum = 262277;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=262278;
 //BA.debugLineNum = 262278;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262279;
 //BA.debugLineNum = 262279;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=262280;
 //BA.debugLineNum = 262280;BA.debugLine="Panel.AddView(totalPos,panelWidth,PanelTitl";
_panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,_paneltitle.getHeight(),_panelwidth,(int) (_labelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))));
RDebugUtils.currentLine=262281;
 //BA.debugLineNum = 262281;BA.debugLine="AdjustFontSizeToHeight(totalPos,1.3)";
_adjustfontsizetoheight(_totalpos,(float) (1.3));
RDebugUtils.currentLine=262283;
 //BA.debugLineNum = 262283;BA.debugLine="Dim totalPosLabel As Label";
_totalposlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262284;
 //BA.debugLineNum = 262284;BA.debugLine="totalPosLabel.Initialize(\"\")";
_totalposlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262285;
 //BA.debugLineNum = 262285;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
_totalposlabel.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=262286;
 //BA.debugLineNum = 262286;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
_totalposlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=262287;
 //BA.debugLineNum = 262287;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
_totalposlabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=262288;
 //BA.debugLineNum = 262288;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
_totalposlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262289;
 //BA.debugLineNum = 262289;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
_totalposlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=262290;
 //BA.debugLineNum = 262290;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToU";
_totalposlabel.setText(BA.ObjectToCharSequence(_totalposlabel.getText().toUpperCase()));
RDebugUtils.currentLine=262291;
 //BA.debugLineNum = 262291;BA.debugLine="Panel.AddView(totalPosLabel,panelWidth,tota";
_panel.AddView((android.view.View)(_totalposlabel.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=262293;
 //BA.debugLineNum = 262293;BA.debugLine="For i = 0 To salesArray.Size - 1";
{
final int step122 = 1;
final int limit122 = (int) (_salesarray.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit122 ;_i = _i + step122 ) {
RDebugUtils.currentLine=262295;
 //BA.debugLineNum = 262295;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=262296;
 //BA.debugLineNum = 262296;BA.debugLine="Dim currentComId As String = record.Get(\"co";
_currentcomid = BA.ObjectToString(_record.Get((Object)("comId")));
RDebugUtils.currentLine=262299;
 //BA.debugLineNum = 262299;BA.debugLine="If currentComId = 1 Then";
if ((_currentcomid).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=262302;
 //BA.debugLineNum = 262302;BA.debugLine="If record.ContainsKey(\"branches\") Then";
if (_record.ContainsKey((Object)("branches"))) { 
RDebugUtils.currentLine=262303;
 //BA.debugLineNum = 262303;BA.debugLine="Dim branches As List = record.Get(\"branch";
_branches = new anywheresoftware.b4a.objects.collections.List();
_branches = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_record.Get((Object)("branches"))));
RDebugUtils.currentLine=262304;
 //BA.debugLineNum = 262304;BA.debugLine="Dim totalBranches As Int = branches.Size";
_totalbranches = _branches.getSize();
RDebugUtils.currentLine=262307;
 //BA.debugLineNum = 262307;BA.debugLine="Dim branchNames(totalBranches) As String";
_branchnames = new String[_totalbranches];
java.util.Arrays.fill(_branchnames,"");
RDebugUtils.currentLine=262308;
 //BA.debugLineNum = 262308;BA.debugLine="Dim branchSales1(totalBranches) As Int";
_branchsales1 = new int[_totalbranches];
;
RDebugUtils.currentLine=262309;
 //BA.debugLineNum = 262309;BA.debugLine="Dim branchSales2(totalBranches) As Int";
_branchsales2 = new int[_totalbranches];
;
RDebugUtils.currentLine=262310;
 //BA.debugLineNum = 262310;BA.debugLine="Dim branchSales3(totalBranches) As Int";
_branchsales3 = new int[_totalbranches];
;
RDebugUtils.currentLine=262313;
 //BA.debugLineNum = 262313;BA.debugLine="For j = 0 To totalBranches - 1";
{
final int step133 = 1;
final int limit133 = (int) (_totalbranches-1);
_j = (int) (0) ;
for (;_j <= limit133 ;_j = _j + step133 ) {
RDebugUtils.currentLine=262314;
 //BA.debugLineNum = 262314;BA.debugLine="Dim branchMap As Map = branches.Get(j";
_branchmap = new anywheresoftware.b4a.objects.collections.Map();
_branchmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_branches.Get(_j)));
RDebugUtils.currentLine=262315;
 //BA.debugLineNum = 262315;BA.debugLine="branchNames(j) = branchMap.GetDefault";
_branchnames[_j] = (BA.ObjectToString(_branchmap.GetDefault((Object)("branch_name"),(Object)(""))));
RDebugUtils.currentLine=262316;
 //BA.debugLineNum = 262316;BA.debugLine="branchSales1(j) = branchMap.GetDefaul";
_branchsales1[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales1"),(Object)(0))));
RDebugUtils.currentLine=262317;
 //BA.debugLineNum = 262317;BA.debugLine="branchSales2(j) = branchMap.GetDefaul";
_branchsales2[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales2"),(Object)(0))));
RDebugUtils.currentLine=262318;
 //BA.debugLineNum = 262318;BA.debugLine="branchSales3(j) = branchMap.GetDefaul";
_branchsales3[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales3"),(Object)(0))));
 }
};
RDebugUtils.currentLine=262322;
 //BA.debugLineNum = 262322;BA.debugLine="Dim legend() As String = Array As Stri";
mostCurrent._legend = new String[]{"Sales1","Sales2","Sales3"};
 }else {
RDebugUtils.currentLine=262326;
 //BA.debugLineNum = 262326;BA.debugLine="Log($\"Company: ${name} has no branches in";
anywheresoftware.b4a.keywords.Common.LogImpl("6262326",("Company: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_name))+" has no branches information."),0);
 };
 };
 }
};
RDebugUtils.currentLine=262333;
 //BA.debugLineNum = 262333;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=262334;
 //BA.debugLineNum = 262334;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 0dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262335;
 //BA.debugLineNum = 262335;BA.debugLine="Panel.Background = cd";
_panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=262336;
 //BA.debugLineNum = 262336;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 }
};
RDebugUtils.currentLine=262339;
 //BA.debugLineNum = 262339;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
_totalcompanies = _salesarray.getSize();
RDebugUtils.currentLine=262340;
 //BA.debugLineNum = 262340;BA.debugLine="Dim sales(totalCompanies) As Int";
_sales = new int[_totalcompanies];
;
RDebugUtils.currentLine=262341;
 //BA.debugLineNum = 262341;BA.debugLine="Dim comId(totalCompanies) As Int";
_comid = new int[_totalcompanies];
;
RDebugUtils.currentLine=262342;
 //BA.debugLineNum = 262342;BA.debugLine="Dim sales1(totalCompanies) As Int";
_sales1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=262343;
 //BA.debugLineNum = 262343;BA.debugLine="Dim sales2(totalCompanies) As Int";
_sales2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=262344;
 //BA.debugLineNum = 262344;BA.debugLine="Dim purchase(totalCompanies) As Int";
_purchase = new int[_totalcompanies];
;
RDebugUtils.currentLine=262345;
 //BA.debugLineNum = 262345;BA.debugLine="Dim purchase1(totalCompanies) As Int";
_purchase1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=262346;
 //BA.debugLineNum = 262346;BA.debugLine="Dim purchase2(totalCompanies) As Int";
_purchase2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=262347;
 //BA.debugLineNum = 262347;BA.debugLine="Dim companyName(totalCompanies) As String";
_companyname = new String[_totalcompanies];
java.util.Arrays.fill(_companyname,"");
RDebugUtils.currentLine=262348;
 //BA.debugLineNum = 262348;BA.debugLine="Dim max_value(totalCompanies) As Int";
_max_value = new int[_totalcompanies];
;
RDebugUtils.currentLine=262349;
 //BA.debugLineNum = 262349;BA.debugLine="Dim maxSale As Int=0";
_maxsale = (int) (0);
RDebugUtils.currentLine=262351;
 //BA.debugLineNum = 262351;BA.debugLine="For i = 0 To totalCompanies - 1";
{
final int step162 = 1;
final int limit162 = (int) (_totalcompanies-1);
_i = (int) (0) ;
for (;_i <= limit162 ;_i = _i + step162 ) {
RDebugUtils.currentLine=262352;
 //BA.debugLineNum = 262352;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=262353;
 //BA.debugLineNum = 262353;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
_companyname[_i] = BA.ObjectToString(_record.GetDefault((Object)("company_name"),(Object)("Unknown")));
RDebugUtils.currentLine=262354;
 //BA.debugLineNum = 262354;BA.debugLine="comId(i) = record.GetDefault(\"comId\", 0)";
_comid[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("comId"),(Object)(0))));
RDebugUtils.currentLine=262355;
 //BA.debugLineNum = 262355;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
_sales[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_1"),(Object)(0))));
RDebugUtils.currentLine=262356;
 //BA.debugLineNum = 262356;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
_sales1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_2"),(Object)(0))));
RDebugUtils.currentLine=262357;
 //BA.debugLineNum = 262357;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
_sales2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_3"),(Object)(0))));
RDebugUtils.currentLine=262358;
 //BA.debugLineNum = 262358;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
_purchase[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_1"),(Object)(0))));
RDebugUtils.currentLine=262359;
 //BA.debugLineNum = 262359;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
_purchase1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_2"),(Object)(0))));
RDebugUtils.currentLine=262360;
 //BA.debugLineNum = 262360;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_\"";
_purchase2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_"),(Object)(0))));
RDebugUtils.currentLine=262361;
 //BA.debugLineNum = 262361;BA.debugLine="max_value(i) = record.GetDefault(\"max_value\"";
_max_value[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("max_value"),(Object)(0))));
RDebugUtils.currentLine=262362;
 //BA.debugLineNum = 262362;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
_maxsale = (int) (anywheresoftware.b4a.keywords.Common.Max(_maxsale,_max_value[_i]));
 }
};
RDebugUtils.currentLine=262365;
 //BA.debugLineNum = 262365;BA.debugLine="barPanel.RemoveAllViews";
mostCurrent._barpanel.RemoveAllViews();
RDebugUtils.currentLine=262366;
 //BA.debugLineNum = 262366;BA.debugLine="barPanel.Invalidate ' Force redraw";
mostCurrent._barpanel.Invalidate();
RDebugUtils.currentLine=262368;
 //BA.debugLineNum = 262368;BA.debugLine="Activity.Initialize(\"\")";
mostCurrent._activity.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262370;
 //BA.debugLineNum = 262370;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
mostCurrent._legend = new String[]{"Sales1","Sales2","Sales3"};
RDebugUtils.currentLine=262372;
 //BA.debugLineNum = 262372;BA.debugLine="saleNxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._salenxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=262373;
 //BA.debugLineNum = 262373;BA.debugLine="saleBackBtn.Initialize(\"backbtn\")";
mostCurrent._salebackbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=262375;
 //BA.debugLineNum = 262375;BA.debugLine="Dim totalSalePanel As Panel";
_totalsalepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262376;
 //BA.debugLineNum = 262376;BA.debugLine="totalSalePanel.Initialize(\"\")";
_totalsalepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262377;
 //BA.debugLineNum = 262377;BA.debugLine="ScrollView1.Panel.AddView(totalSalePanel,5dip";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_totalsalepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (mostCurrent._panel2.getHeight()+_companypanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (28))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=262379;
 //BA.debugLineNum = 262379;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=262380;
 //BA.debugLineNum = 262380;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"stock.p";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"stock.png");
RDebugUtils.currentLine=262382;
 //BA.debugLineNum = 262382;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=262383;
 //BA.debugLineNum = 262383;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262384;
 //BA.debugLineNum = 262384;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=262385;
 //BA.debugLineNum = 262385;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=262386;
 //BA.debugLineNum = 262386;BA.debugLine="totalSalePanel.AddView(imgView, 0dip, 12.5dip";
_totalsalepanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_totalsalepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=262388;
 //BA.debugLineNum = 262388;BA.debugLine="Dim totalSaleLabel As Label";
_totalsalelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262389;
 //BA.debugLineNum = 262389;BA.debugLine="totalSaleLabel.Initialize(\"\")";
_totalsalelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262390;
 //BA.debugLineNum = 262390;BA.debugLine="totalSaleLabel.Text = \"Total Sales\"";
_totalsalelabel.setText(BA.ObjectToCharSequence("Total Sales"));
RDebugUtils.currentLine=262391;
 //BA.debugLineNum = 262391;BA.debugLine="totalSaleLabel.TextColor = Colors.Black";
_totalsalelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262392;
 //BA.debugLineNum = 262392;BA.debugLine="totalSaleLabel.Gravity = Gravity.CENTER_VERTI";
_totalsalelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=262393;
 //BA.debugLineNum = 262393;BA.debugLine="totalSaleLabel.Typeface = Typeface.MONOSPACE";
_totalsalelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=262394;
 //BA.debugLineNum = 262394;BA.debugLine="totalSalePanel.AddView(totalSaleLabel,imgView";
_totalsalepanel.AddView((android.view.View)(_totalsalelabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=262395;
 //BA.debugLineNum = 262395;BA.debugLine="AdjustFontSizeToHeight(totalSaleLabel,2)";
_adjustfontsizetoheight(_totalsalelabel,(float) (2));
RDebugUtils.currentLine=262397;
 //BA.debugLineNum = 262397;BA.debugLine="Dim shadowPanel As Panel";
_shadowpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262398;
 //BA.debugLineNum = 262398;BA.debugLine="shadowPanel.Initialize(\"\")";
_shadowpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262399;
 //BA.debugLineNum = 262399;BA.debugLine="shadowPanel.Color = Colors.ARGB(50, 138, 138,";
_shadowpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (138),(int) (138),(int) (138)));
RDebugUtils.currentLine=262400;
 //BA.debugLineNum = 262400;BA.debugLine="ScrollView1.Panel.AddView(shadowPanel, 25dip";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_shadowpanel.getObject()),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+_companypanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=262402;
 //BA.debugLineNum = 262402;BA.debugLine="ScrollView1.Panel.AddView(barPanel,25dip,tota";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._barpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+_companypanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=262403;
 //BA.debugLineNum = 262403;BA.debugLine="barPanel.Color = Colors.White";
mostCurrent._barpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=262404;
 //BA.debugLineNum = 262404;BA.debugLine="barGraph.Initialize(Activity,barPanel,sales,s";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._barpanel,_sales,_sales1,_sales2,_companyname,mostCurrent._legend,_maxsale,"Sales Per Company",_comid,"Branch",mostCurrent._salenxtbtn,mostCurrent._salebackbtn);
RDebugUtils.currentLine=262405;
 //BA.debugLineNum = 262405;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purchas";
mostCurrent._legend = new String[]{"Purchase1","Purchase2","Purchase3"};
RDebugUtils.currentLine=262407;
 //BA.debugLineNum = 262407;BA.debugLine="Dim totalPurchasePanel As Panel";
_totalpurchasepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262408;
 //BA.debugLineNum = 262408;BA.debugLine="totalPurchasePanel.Initialize(\"\")";
_totalpurchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262409;
 //BA.debugLineNum = 262409;BA.debugLine="ScrollView1.Panel.AddView(totalPurchasePanel,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_totalpurchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (mostCurrent._barpanel.getHeight()+mostCurrent._panel2.getHeight()+_companypanel.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=262411;
 //BA.debugLineNum = 262411;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=262412;
 //BA.debugLineNum = 262412;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"stock.p";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"stock.png");
RDebugUtils.currentLine=262414;
 //BA.debugLineNum = 262414;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=262415;
 //BA.debugLineNum = 262415;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262416;
 //BA.debugLineNum = 262416;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=262417;
 //BA.debugLineNum = 262417;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=262418;
 //BA.debugLineNum = 262418;BA.debugLine="totalPurchasePanel.AddView(imgView, 0dip, 12.";
_totalpurchasepanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_totalpurchasepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=262420;
 //BA.debugLineNum = 262420;BA.debugLine="Dim totalPurchaseLabel As Label";
_totalpurchaselabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262421;
 //BA.debugLineNum = 262421;BA.debugLine="totalPurchaseLabel.Initialize(\"\")";
_totalpurchaselabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262422;
 //BA.debugLineNum = 262422;BA.debugLine="totalPurchaseLabel.Text = \"Total Purchases\"";
_totalpurchaselabel.setText(BA.ObjectToCharSequence("Total Purchases"));
RDebugUtils.currentLine=262423;
 //BA.debugLineNum = 262423;BA.debugLine="totalPurchaseLabel.TextColor =Colors.Black";
_totalpurchaselabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262424;
 //BA.debugLineNum = 262424;BA.debugLine="totalPurchaseLabel.Gravity = Gravity.CENTER_V";
_totalpurchaselabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=262425;
 //BA.debugLineNum = 262425;BA.debugLine="totalPurchaseLabel.Typeface = Typeface.MONOSP";
_totalpurchaselabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=262426;
 //BA.debugLineNum = 262426;BA.debugLine="totalPurchasePanel.AddView(totalPurchaseLabel";
_totalpurchasepanel.AddView((android.view.View)(_totalpurchaselabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),_totalpurchasepanel.getHeight());
RDebugUtils.currentLine=262427;
 //BA.debugLineNum = 262427;BA.debugLine="AdjustFontSizeToHeight(totalPurchaseLabel,2)";
_adjustfontsizetoheight(_totalpurchaselabel,(float) (2));
RDebugUtils.currentLine=262429;
 //BA.debugLineNum = 262429;BA.debugLine="Dim shadowPurchPanel As Panel";
_shadowpurchpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262430;
 //BA.debugLineNum = 262430;BA.debugLine="shadowPurchPanel.Initialize(\"\")";
_shadowpurchpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262431;
 //BA.debugLineNum = 262431;BA.debugLine="shadowPurchPanel.Color = Colors.ARGB(50, 138,";
_shadowpurchpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (138),(int) (138),(int) (138)));
RDebugUtils.currentLine=262432;
 //BA.debugLineNum = 262432;BA.debugLine="ScrollView1.Panel.AddView(shadowPurchPanel, 2";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_shadowpurchpanel.getObject()),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+_companypanel.getHeight()+mostCurrent._barpanel.getHeight()+_totalpurchaselabel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=262434;
 //BA.debugLineNum = 262434;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262435;
 //BA.debugLineNum = 262435;BA.debugLine="ScrollView1.Panel.AddView(purchasePanel,25dip";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+_companypanel.getHeight()+mostCurrent._barpanel.getHeight()+_totalpurchaselabel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=262436;
 //BA.debugLineNum = 262436;BA.debugLine="purchNxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._purchnxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=262437;
 //BA.debugLineNum = 262437;BA.debugLine="purchBackBtn.Initialize(\"backbtn\")";
mostCurrent._purchbackbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=262438;
 //BA.debugLineNum = 262438;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel,";
mostCurrent._bargraph1._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_purchase,_purchase1,_purchase2,_companyname,mostCurrent._legend,_maxsale,"Purchases Per Company",_comid,"Branch",mostCurrent._purchnxtbtn,mostCurrent._purchbackbtn);
RDebugUtils.currentLine=262439;
 //BA.debugLineNum = 262439;BA.debugLine="Log($\"maxSale:${maxSale}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("6262439",("maxSale:"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_maxsale))+""),0);
RDebugUtils.currentLine=262440;
 //BA.debugLineNum = 262440;BA.debugLine="purchasePanel.Color = Colors.White";
mostCurrent._purchasepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=262441;
 //BA.debugLineNum = 262441;BA.debugLine="ScrollView1.Panel.Height = totalSaleLabel.Hei";
mostCurrent._scrollview1.getPanel().setHeight((int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+_companypanel.getHeight()+mostCurrent._barpanel.getHeight()+_totalpurchaselabel.getHeight()+mostCurrent._purchasepanel.getHeight()));
 break; }
case 1: {
RDebugUtils.currentLine=262443;
 //BA.debugLineNum = 262443;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=262444;
 //BA.debugLineNum = 262444;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=262446;
 //BA.debugLineNum = 262446;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("6262446","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e244) {
			processBA.setLastException(e244);RDebugUtils.currentLine=262449;
 //BA.debugLineNum = 262449;BA.debugLine="ToastMessageShow(\"Error parsing sales data\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing sales data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=262452;
 //BA.debugLineNum = 262452;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262454;
 //BA.debugLineNum = 262454;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=262455;
 //BA.debugLineNum = 262455;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Starter.company_selected = selectedCompany";
mostCurrent._starter._company_selected /*String*/  = _selectedcompany;
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="End Sub";
return "";
}
public static String  _nxtbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtbtn_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub nxtBtn_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Log(\"sad\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6589825","sad",0);
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return "";
}
}