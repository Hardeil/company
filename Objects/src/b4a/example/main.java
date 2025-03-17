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
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sortbtn1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _defbtn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sortbtn2 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sales1btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sales2btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sales3btn = null;
public static String[] _legend = null;
public static int _height = 0;
public anywheresoftware.b4a.objects.PanelWrapper _companypanel = null;
public static int _totalgraphdataheight = 0;
public static int _totalgetdataheight = 0;
public static String _sortdefaultvalue = "";
public static int _salesdata1 = 0;
public static int _currentpage = 0;
public static boolean _bargraphinitialized = false;
public static String _phpurlcompany = "";
public static float _calculatedsize = 0f;
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
anywheresoftware.b4a.keywords.Common.LogImpl("7196615",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="End Sub";
return "";
}
public static String  _loadgraphdata() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadgraphdata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadgraphdata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub LoadGraphData";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Try";
try {RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
mostCurrent._phpurlcompany = ("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"&company_sales="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_salesdata1))+"&sort_type="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+"");
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="Job1.Initialize(\"GetCompany\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetCompany",main.getObject());
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="Job1.Download(PHPURLCompany)";
_job1._download /*String*/ (null,mostCurrent._phpurlcompany);
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Graph Data..."));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="Log(\"LoadGraphData Error: \" & LastException.Mess";
anywheresoftware.b4a.keywords.Common.LogImpl("7262155","LoadGraphData Error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
RDebugUtils.currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="ToastMessageShow(\"Error initiating graph load: \"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error initiating graph load: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static float  _adjustfontsizetoheight(anywheresoftware.b4a.objects.LabelWrapper _lbl,float _fontscalefactor) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "adjustfontsizetoheight", false))
	 {return ((Float) Debug.delegate(mostCurrent.activityBA, "adjustfontsizetoheight", new Object[] {_lbl,_fontscalefactor}));}
float _fontsize = 0f;
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub AdjustFontSizeToHeight(lbl As Label, fontScale";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Dim fontSize As Float = lbl.Height * fontScaleFac";
_fontsize = (float) (_lbl.getHeight()*_fontscalefactor/(double)_getdevicedensity());
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Return fontSize";
if (true) return _fontsize;
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="End Sub";
return 0f;
}
public static float  _getdevicedensity() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getdevicedensity", false))
	 {return ((Float) Debug.delegate(mostCurrent.activityBA, "getdevicedensity", null));}
int _pixelwidth = 0;
int _dipwidth = 0;
float _dense = 0f;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub GetDeviceDensity As Float";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim pixelWidth As Int = 100%x ' Screen width in p";
_pixelwidth = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA);
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Dim dipWidth As Int = 100dip  ' 100 DIPs in pixel";
_dipwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="Dim Dense As Float = pixelWidth / dipWidth";
_dense = (float) (_pixelwidth/(double)_dipwidth);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="Return Dense";
if (true) return _dense;
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="End Sub";
return 0f;
}
public static String  _defbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "defbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "defbtn_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub defBtn_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="sortDefaultValue = \"\" ' Reset to default (no sort";
mostCurrent._sortdefaultvalue = "";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Log(\"Default sorting applied\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7786434","Default sorting applied",0);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="LoadGraphData ' Reload data without sorting";
_loadgraphdata();
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="End Sub";
return "";
}
public static Object  _getmapvalueordefault(anywheresoftware.b4a.objects.collections.Map _m,String _key,Object _defaultvalue) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getmapvalueordefault", false))
	 {return ((Object) Debug.delegate(mostCurrent.activityBA, "getmapvalueordefault", new Object[] {_m,_key,_defaultvalue}));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If m.ContainsKey(Key) Then";
if (_m.ContainsKey((Object)(_key))) { 
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Return m.Get(Key)";
if (true) return _m.Get((Object)(_key));
 }else {
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.PanelWrapper _totalpurchasepanel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpurchaselabel = null;
anywheresoftware.b4a.objects.PanelWrapper _shadowpurchpanel = null;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Try";
try {RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","GetCompany","UpdateData")) {
case 0: {
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=327695;
 //BA.debugLineNum = 327695;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=327697;
 //BA.debugLineNum = 327697;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=327698;
 //BA.debugLineNum = 327698;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=327699;
 //BA.debugLineNum = 327699;BA.debugLine="Dim rowNum As Int = 3";
_rownum = (int) (3);
RDebugUtils.currentLine=327700;
 //BA.debugLineNum = 327700;BA.debugLine="Dim mainPanelWidth As Int = 0";
_mainpanelwidth = (int) (0);
RDebugUtils.currentLine=327701;
 //BA.debugLineNum = 327701;BA.debugLine="Dim panelHeight As Int = 150dip ' Adjust heig";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150));
RDebugUtils.currentLine=327702;
 //BA.debugLineNum = 327702;BA.debugLine="height = panelHeight - 70dip";
_height = (int) (_panelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=327704;
 //BA.debugLineNum = 327704;BA.debugLine="For Each record As Map In salesArray";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group20 = _salesarray;
final int groupLen20 = group20.getSize()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group20.Get(index20)));
RDebugUtils.currentLine=327705;
 //BA.debugLineNum = 327705;BA.debugLine="If count Mod 3 = 0 Then";
if (_count%3==0) { 
RDebugUtils.currentLine=327706;
 //BA.debugLineNum = 327706;BA.debugLine="height = height + panelHeight";
_height = (int) (_height+_panelheight);
 };
RDebugUtils.currentLine=327708;
 //BA.debugLineNum = 327708;BA.debugLine="Dim col As Int = count Mod 3  ' Column posit";
_col = (int) (_count%3);
RDebugUtils.currentLine=327709;
 //BA.debugLineNum = 327709;BA.debugLine="Dim row As Int = Floor(count / 3)";
_row = (int) (anywheresoftware.b4a.keywords.Common.Floor(_count/(double)3));
RDebugUtils.currentLine=327710;
 //BA.debugLineNum = 327710;BA.debugLine="Dim name As String = record.Get(\"company_nam";
_name = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=327711;
 //BA.debugLineNum = 327711;BA.debugLine="Dim company_id As Int = record.Get(\"company_";
_company_id = (int)(BA.ObjectToNumber(_record.Get((Object)("company_id"))));
RDebugUtils.currentLine=327712;
 //BA.debugLineNum = 327712;BA.debugLine="Dim total_count As Int = record.Get(\"total_b";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("total_branch_count"))));
RDebugUtils.currentLine=327713;
 //BA.debugLineNum = 327713;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDevi";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=327714;
 //BA.debugLineNum = 327714;BA.debugLine="Dim dashPanel As Panel";
_dashpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=327715;
 //BA.debugLineNum = 327715;BA.debugLine="dashPanel.Initialize(\"\")";
_dashpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327716;
 //BA.debugLineNum = 327716;BA.debugLine="ScrollView1.Panel.AddView(dashPanel, 5dip, P";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_dashpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),mostCurrent._panel2.getHeight(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=327719;
 //BA.debugLineNum = 327719;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=327720;
 //BA.debugLineNum = 327720;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"dashbo";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dashboard.png");
RDebugUtils.currentLine=327722;
 //BA.debugLineNum = 327722;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=327723;
 //BA.debugLineNum = 327723;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327724;
 //BA.debugLineNum = 327724;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=327725;
 //BA.debugLineNum = 327725;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=327726;
 //BA.debugLineNum = 327726;BA.debugLine="dashPanel.AddView(imgView, 0dip, 12.5dip, 15";
_dashpanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_dashpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=327728;
 //BA.debugLineNum = 327728;BA.debugLine="Dim dashLabel As Label";
_dashlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=327729;
 //BA.debugLineNum = 327729;BA.debugLine="dashLabel.Initialize(\"\")";
_dashlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327730;
 //BA.debugLineNum = 327730;BA.debugLine="dashLabel.Text = \"Dashboard\"";
_dashlabel.setText(BA.ObjectToCharSequence("Dashboard"));
RDebugUtils.currentLine=327731;
 //BA.debugLineNum = 327731;BA.debugLine="dashLabel.TextColor = Colors.ARGB(50,156,0,0";
_dashlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (156),(int) (0),(int) (0)));
RDebugUtils.currentLine=327732;
 //BA.debugLineNum = 327732;BA.debugLine="dashLabel.Gravity = Gravity.CENTER_VERTICAL";
_dashlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=327733;
 //BA.debugLineNum = 327733;BA.debugLine="dashLabel.Typeface = Typeface.MONOSPACE";
_dashlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=327734;
 //BA.debugLineNum = 327734;BA.debugLine="dashPanel.AddView(dashLabel, imgView.Width+5";
_dashpanel.AddView((android.view.View)(_dashlabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_dashpanel.getWidth(),_dashpanel.getHeight());
RDebugUtils.currentLine=327735;
 //BA.debugLineNum = 327735;BA.debugLine="calculatedSize = AdjustFontSizeToHeight(dash";
_calculatedsize = _adjustfontsizetoheight(_dashlabel,(float) (2));
RDebugUtils.currentLine=327736;
 //BA.debugLineNum = 327736;BA.debugLine="dashLabel.TextSize = calculatedSize";
_dashlabel.setTextSize(_calculatedsize);
RDebugUtils.currentLine=327739;
 //BA.debugLineNum = 327739;BA.debugLine="companyPanel.Initialize(\"Panel\")";
mostCurrent._companypanel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=327740;
 //BA.debugLineNum = 327740;BA.debugLine="ScrollView1.Panel.AddView(companyPanel, 5dip";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._companypanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),_dashpanel.getHeight(),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),_height);
RDebugUtils.currentLine=327743;
 //BA.debugLineNum = 327743;BA.debugLine="mainPanelWidth = companyPanel.Width / rowNum";
_mainpanelwidth = (int) (mostCurrent._companypanel.getWidth()/(double)_rownum);
RDebugUtils.currentLine=327744;
 //BA.debugLineNum = 327744;BA.debugLine="Dim Panel As Panel";
_panel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=327745;
 //BA.debugLineNum = 327745;BA.debugLine="Panel.Initialize(\"\")";
_panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327746;
 //BA.debugLineNum = 327746;BA.debugLine="companyPanel.AddView(Panel, col * (mainPanel";
mostCurrent._companypanel.AddView((android.view.View)(_panel.getObject()),(int) (_col*(_mainpanelwidth+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)))),(int) (mostCurrent._panel2.getHeight()+(_row*(_panelheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))))),(int) (_mainpanelwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),_panelheight);
RDebugUtils.currentLine=327748;
 //BA.debugLineNum = 327748;BA.debugLine="Dim PanelTitle As Panel";
_paneltitle = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=327749;
 //BA.debugLineNum = 327749;BA.debugLine="PanelTitle.Initialize(\"Panel2\")";
_paneltitle.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=327750;
 //BA.debugLineNum = 327750;BA.debugLine="PanelTitle.Color = Colors.Black";
_paneltitle.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=327751;
 //BA.debugLineNum = 327751;BA.debugLine="PanelTitle.Tag = name";
_paneltitle.setTag((Object)(_name));
RDebugUtils.currentLine=327752;
 //BA.debugLineNum = 327752;BA.debugLine="Panel.AddView(PanelTitle, 0, 0, Panel.Width,";
_panel.AddView((android.view.View)(_paneltitle.getObject()),(int) (0),(int) (0),_panel.getWidth(),(int) (_panelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))));
RDebugUtils.currentLine=327755;
 //BA.debugLineNum = 327755;BA.debugLine="Dim Label17 As Label";
_label17 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=327756;
 //BA.debugLineNum = 327756;BA.debugLine="Label17.Initialize(\"Label17\")";
_label17.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=327757;
 //BA.debugLineNum = 327757;BA.debugLine="Label17.Text = name.ToUpperCase";
_label17.setText(BA.ObjectToCharSequence(_name.toUpperCase()));
RDebugUtils.currentLine=327758;
 //BA.debugLineNum = 327758;BA.debugLine="Label17.Tag = company_id";
_label17.setTag((Object)(_company_id));
RDebugUtils.currentLine=327759;
 //BA.debugLineNum = 327759;BA.debugLine="Label17.TextSize = 18";
_label17.setTextSize((float) (18));
RDebugUtils.currentLine=327760;
 //BA.debugLineNum = 327760;BA.debugLine="Label17.TextColor = Colors.White";
_label17.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=327761;
 //BA.debugLineNum = 327761;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
_label17.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=327762;
 //BA.debugLineNum = 327762;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
_label17.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=327763;
 //BA.debugLineNum = 327763;BA.debugLine="PanelTitle.AddView(Label17, 5dip, 0dip, Pane";
_paneltitle.AddView((android.view.View)(_label17.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_paneltitle.getWidth(),_paneltitle.getHeight());
RDebugUtils.currentLine=327765;
 //BA.debugLineNum = 327765;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=327766;
 //BA.debugLineNum = 327766;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=327767;
 //BA.debugLineNum = 327767;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=327768;
 //BA.debugLineNum = 327768;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=327769;
 //BA.debugLineNum = 327769;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=327770;
 //BA.debugLineNum = 327770;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327771;
 //BA.debugLineNum = 327771;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=327772;
 //BA.debugLineNum = 327772;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=327773;
 //BA.debugLineNum = 327773;BA.debugLine="PanelTitle.AddView(imgView, PanelTitle.Widt";
_paneltitle.AddView((android.view.View)(_imgview.getObject()),(int) (_paneltitle.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),(int) (_paneltitle.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 }else {
RDebugUtils.currentLine=327775;
 //BA.debugLineNum = 327775;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7327775","Error loading image",0);
 };
RDebugUtils.currentLine=327778;
 //BA.debugLineNum = 327778;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
_panelwidth = (int) (_panel.getWidth()/(double)3);
RDebugUtils.currentLine=327779;
 //BA.debugLineNum = 327779;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=327780;
 //BA.debugLineNum = 327780;BA.debugLine="Dim labelheight As Int = panelHeight - Panel";
_labelheight = (int) (_panelheight-_paneltitle.getHeight());
RDebugUtils.currentLine=327781;
 //BA.debugLineNum = 327781;BA.debugLine="panelWidth = Panel.Width /2";
_panelwidth = (int) (_panel.getWidth()/(double)2);
RDebugUtils.currentLine=327783;
 //BA.debugLineNum = 327783;BA.debugLine="Dim totalStore As Label";
_totalstore = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=327784;
 //BA.debugLineNum = 327784;BA.debugLine="totalStore.Initialize(\"\")";
_totalstore.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327785;
 //BA.debugLineNum = 327785;BA.debugLine="totalStore.Text = total_count";
_totalstore.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=327786;
 //BA.debugLineNum = 327786;BA.debugLine="totalStore.TextColor = Colors.Black";
_totalstore.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=327787;
 //BA.debugLineNum = 327787;BA.debugLine="totalStore.TextSize = primaryFontSize";
_totalstore.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=327788;
 //BA.debugLineNum = 327788;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
_totalstore.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=327789;
 //BA.debugLineNum = 327789;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
_totalstore.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=327790;
 //BA.debugLineNum = 327790;BA.debugLine="Panel.AddView(totalStore,0,PanelTitle.Height";
_panel.AddView((android.view.View)(_totalstore.getObject()),(int) (0),_paneltitle.getHeight(),_panelwidth,(int) (_labelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))));
RDebugUtils.currentLine=327793;
 //BA.debugLineNum = 327793;BA.debugLine="Dim totalStoreLabel As Label";
_totalstorelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=327794;
 //BA.debugLineNum = 327794;BA.debugLine="totalStoreLabel.Initialize(\"\")";
_totalstorelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327795;
 //BA.debugLineNum = 327795;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
_totalstorelabel.setText(BA.ObjectToCharSequence(" Total Store"));
RDebugUtils.currentLine=327796;
 //BA.debugLineNum = 327796;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
_totalstorelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=327797;
 //BA.debugLineNum = 327797;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSize";
_totalstorelabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=327798;
 //BA.debugLineNum = 327798;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
_totalstorelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=327799;
 //BA.debugLineNum = 327799;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPAC";
_totalstorelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=327800;
 //BA.debugLineNum = 327800;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text.";
_totalstorelabel.setText(BA.ObjectToCharSequence(_totalstorelabel.getText().toUpperCase()));
RDebugUtils.currentLine=327801;
 //BA.debugLineNum = 327801;BA.debugLine="Panel.AddView(totalStoreLabel,0,totalStore.t";
_panel.AddView((android.view.View)(_totalstorelabel.getObject()),(int) (0),(int) (_totalstore.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=327803;
 //BA.debugLineNum = 327803;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=327804;
 //BA.debugLineNum = 327804;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327805;
 //BA.debugLineNum = 327805;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=327806;
 //BA.debugLineNum = 327806;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=327807;
 //BA.debugLineNum = 327807;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=327808;
 //BA.debugLineNum = 327808;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=327809;
 //BA.debugLineNum = 327809;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=327810;
 //BA.debugLineNum = 327810;BA.debugLine="Panel.AddView(totalPos,panelWidth,PanelTitle";
_panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,_paneltitle.getHeight(),_panelwidth,(int) (_labelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))));
RDebugUtils.currentLine=327813;
 //BA.debugLineNum = 327813;BA.debugLine="Dim totalPosLabel As Label";
_totalposlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=327814;
 //BA.debugLineNum = 327814;BA.debugLine="totalPosLabel.Initialize(\"\")";
_totalposlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327815;
 //BA.debugLineNum = 327815;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
_totalposlabel.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=327816;
 //BA.debugLineNum = 327816;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
_totalposlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=327817;
 //BA.debugLineNum = 327817;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
_totalposlabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=327818;
 //BA.debugLineNum = 327818;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
_totalposlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=327819;
 //BA.debugLineNum = 327819;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
_totalposlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=327820;
 //BA.debugLineNum = 327820;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToUp";
_totalposlabel.setText(BA.ObjectToCharSequence(_totalposlabel.getText().toUpperCase()));
RDebugUtils.currentLine=327821;
 //BA.debugLineNum = 327821;BA.debugLine="Panel.AddView(totalPosLabel,panelWidth,total";
_panel.AddView((android.view.View)(_totalposlabel.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=327824;
 //BA.debugLineNum = 327824;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=327825;
 //BA.debugLineNum = 327825;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 0dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=327826;
 //BA.debugLineNum = 327826;BA.debugLine="Panel.Background = cd";
_panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=327827;
 //BA.debugLineNum = 327827;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 }
};
RDebugUtils.currentLine=327830;
 //BA.debugLineNum = 327830;BA.debugLine="totalGetDataHeight = Panel2.Height+companyPan";
_totalgetdataheight = (int) (mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight());
 break; }
case 1: {
RDebugUtils.currentLine=327832;
 //BA.debugLineNum = 327832;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=327836;
 //BA.debugLineNum = 327836;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=327837;
 //BA.debugLineNum = 327837;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=327838;
 //BA.debugLineNum = 327838;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=327841;
 //BA.debugLineNum = 327841;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
_totalcompanies = _salesarray.getSize();
RDebugUtils.currentLine=327842;
 //BA.debugLineNum = 327842;BA.debugLine="Dim sales(totalCompanies) As Int";
_sales = new int[_totalcompanies];
;
RDebugUtils.currentLine=327843;
 //BA.debugLineNum = 327843;BA.debugLine="Dim comId(totalCompanies) As Int";
_comid = new int[_totalcompanies];
;
RDebugUtils.currentLine=327844;
 //BA.debugLineNum = 327844;BA.debugLine="Dim sales1(totalCompanies) As Int";
_sales1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=327845;
 //BA.debugLineNum = 327845;BA.debugLine="Dim sales2(totalCompanies) As Int";
_sales2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=327846;
 //BA.debugLineNum = 327846;BA.debugLine="Dim purchase(totalCompanies) As Int";
_purchase = new int[_totalcompanies];
;
RDebugUtils.currentLine=327847;
 //BA.debugLineNum = 327847;BA.debugLine="Dim purchase1(totalCompanies) As Int";
_purchase1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=327848;
 //BA.debugLineNum = 327848;BA.debugLine="Dim purchase2(totalCompanies) As Int";
_purchase2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=327849;
 //BA.debugLineNum = 327849;BA.debugLine="Dim companyName(totalCompanies) As String";
_companyname = new String[_totalcompanies];
java.util.Arrays.fill(_companyname,"");
RDebugUtils.currentLine=327850;
 //BA.debugLineNum = 327850;BA.debugLine="Dim max_value(totalCompanies) As Int";
_max_value = new int[_totalcompanies];
;
RDebugUtils.currentLine=327851;
 //BA.debugLineNum = 327851;BA.debugLine="Dim maxSale As Int=0";
_maxsale = (int) (0);
RDebugUtils.currentLine=327853;
 //BA.debugLineNum = 327853;BA.debugLine="For i = 0 To totalCompanies - 1";
{
final int step142 = 1;
final int limit142 = (int) (_totalcompanies-1);
_i = (int) (0) ;
for (;_i <= limit142 ;_i = _i + step142 ) {
RDebugUtils.currentLine=327854;
 //BA.debugLineNum = 327854;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=327855;
 //BA.debugLineNum = 327855;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
_companyname[_i] = BA.ObjectToString(_record.GetDefault((Object)("company_name"),(Object)("Unknown")));
RDebugUtils.currentLine=327856;
 //BA.debugLineNum = 327856;BA.debugLine="comId(i) = record.GetDefault(\"comId\", 0)";
_comid[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("comId"),(Object)(0))));
RDebugUtils.currentLine=327857;
 //BA.debugLineNum = 327857;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
_sales[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_1"),(Object)(0))));
RDebugUtils.currentLine=327858;
 //BA.debugLineNum = 327858;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
_sales1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_2"),(Object)(0))));
RDebugUtils.currentLine=327859;
 //BA.debugLineNum = 327859;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
_sales2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_3"),(Object)(0))));
RDebugUtils.currentLine=327860;
 //BA.debugLineNum = 327860;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
_purchase[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_1"),(Object)(0))));
RDebugUtils.currentLine=327861;
 //BA.debugLineNum = 327861;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
_purchase1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_2"),(Object)(0))));
RDebugUtils.currentLine=327862;
 //BA.debugLineNum = 327862;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_3";
_purchase2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_3"),(Object)(0))));
RDebugUtils.currentLine=327863;
 //BA.debugLineNum = 327863;BA.debugLine="max_value(i) = record.GetDefault(\"max_sales\"";
_max_value[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("max_sales"),(Object)(0))));
RDebugUtils.currentLine=327864;
 //BA.debugLineNum = 327864;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
_maxsale = (int) (anywheresoftware.b4a.keywords.Common.Max(_maxsale,_max_value[_i]));
RDebugUtils.currentLine=327865;
 //BA.debugLineNum = 327865;BA.debugLine="Log(companyName(i) & sales(i))";
anywheresoftware.b4a.keywords.Common.LogImpl("7327865",_companyname[_i]+BA.NumberToString(_sales[_i]),0);
 }
};
RDebugUtils.currentLine=327868;
 //BA.debugLineNum = 327868;BA.debugLine="Activity.Initialize(\"\")";
mostCurrent._activity.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327870;
 //BA.debugLineNum = 327870;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
mostCurrent._legend = new String[]{"Sales1","Sales2","Sales3"};
RDebugUtils.currentLine=327872;
 //BA.debugLineNum = 327872;BA.debugLine="If barGraphInitialized = False Then";
if (_bargraphinitialized==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=327873;
 //BA.debugLineNum = 327873;BA.debugLine="saleNxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._salenxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=327874;
 //BA.debugLineNum = 327874;BA.debugLine="saleBackBtn.Initialize(\"backbtn\")";
mostCurrent._salebackbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=327875;
 //BA.debugLineNum = 327875;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
mostCurrent._sortbtn1.Initialize(mostCurrent.activityBA,"sortBtn1");
RDebugUtils.currentLine=327876;
 //BA.debugLineNum = 327876;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
mostCurrent._sortbtn2.Initialize(mostCurrent.activityBA,"sortBtn2");
RDebugUtils.currentLine=327877;
 //BA.debugLineNum = 327877;BA.debugLine="defBtn.Initialize(\"defBtn\")";
mostCurrent._defbtn.Initialize(mostCurrent.activityBA,"defBtn");
RDebugUtils.currentLine=327878;
 //BA.debugLineNum = 327878;BA.debugLine="sales1btn.Initialize(\"sales1btn\")";
mostCurrent._sales1btn.Initialize(mostCurrent.activityBA,"sales1btn");
RDebugUtils.currentLine=327879;
 //BA.debugLineNum = 327879;BA.debugLine="sales2btn.Initialize(\"sales2btn\")";
mostCurrent._sales2btn.Initialize(mostCurrent.activityBA,"sales2btn");
RDebugUtils.currentLine=327880;
 //BA.debugLineNum = 327880;BA.debugLine="sales3btn.Initialize(\"sales3btn\")";
mostCurrent._sales3btn.Initialize(mostCurrent.activityBA,"sales3btn");
RDebugUtils.currentLine=327881;
 //BA.debugLineNum = 327881;BA.debugLine="Dim totalSalePanel As Panel";
_totalsalepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=327882;
 //BA.debugLineNum = 327882;BA.debugLine="totalSalePanel.Initialize(\"\")";
_totalsalepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327883;
 //BA.debugLineNum = 327883;BA.debugLine="ScrollView1.Panel.AddView(totalSalePanel,5di";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_totalsalepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (28))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=327885;
 //BA.debugLineNum = 327885;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=327886;
 //BA.debugLineNum = 327886;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"stock.";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"stock.png");
RDebugUtils.currentLine=327888;
 //BA.debugLineNum = 327888;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=327889;
 //BA.debugLineNum = 327889;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327890;
 //BA.debugLineNum = 327890;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=327891;
 //BA.debugLineNum = 327891;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=327892;
 //BA.debugLineNum = 327892;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=327893;
 //BA.debugLineNum = 327893;BA.debugLine="totalSalePanel.AddView(imgView, 0dip, 12.5di";
_totalsalepanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_totalsalepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=327895;
 //BA.debugLineNum = 327895;BA.debugLine="Dim totalSaleLabel As Label";
_totalsalelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=327896;
 //BA.debugLineNum = 327896;BA.debugLine="totalSaleLabel.Initialize(\"\")";
_totalsalelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327897;
 //BA.debugLineNum = 327897;BA.debugLine="totalSaleLabel.Text = \"Total Sales\"";
_totalsalelabel.setText(BA.ObjectToCharSequence("Total Sales"));
RDebugUtils.currentLine=327898;
 //BA.debugLineNum = 327898;BA.debugLine="totalSaleLabel.TextColor = Colors.Black";
_totalsalelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=327899;
 //BA.debugLineNum = 327899;BA.debugLine="totalSaleLabel.Gravity = Gravity.CENTER_VERT";
_totalsalelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=327900;
 //BA.debugLineNum = 327900;BA.debugLine="totalSaleLabel.Typeface = Typeface.MONOSPACE";
_totalsalelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=327901;
 //BA.debugLineNum = 327901;BA.debugLine="totalSalePanel.AddView(totalSaleLabel,imgVie";
_totalsalepanel.AddView((android.view.View)(_totalsalelabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=327904;
 //BA.debugLineNum = 327904;BA.debugLine="ScrollView1.Panel.AddView(barPanel,25dip,tot";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._barpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=327905;
 //BA.debugLineNum = 327905;BA.debugLine="barPanel.Color = Colors.White";
mostCurrent._barpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=327907;
 //BA.debugLineNum = 327907;BA.debugLine="barPanel.RemoveAllViews";
mostCurrent._barpanel.RemoveAllViews();
RDebugUtils.currentLine=327908;
 //BA.debugLineNum = 327908;BA.debugLine="barPanel.Invalidate ' Force a redraw";
mostCurrent._barpanel.Invalidate();
RDebugUtils.currentLine=327911;
 //BA.debugLineNum = 327911;BA.debugLine="barGraph.Initialize(Activity,barPanel,sales,";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._barpanel,_sales,_sales1,_sales2,_companyname,mostCurrent._legend,_maxsale,"Total Sale of the Company",_comid,"Branch",mostCurrent._salenxtbtn,mostCurrent._salebackbtn,mostCurrent._sortbtn1,mostCurrent._sortbtn2,mostCurrent._defbtn,mostCurrent._sales1btn,mostCurrent._sales2btn,mostCurrent._sales3btn);
RDebugUtils.currentLine=327912;
 //BA.debugLineNum = 327912;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purcha";
mostCurrent._legend = new String[]{"Purchase1","Purchase2","Purchase3"};
RDebugUtils.currentLine=327913;
 //BA.debugLineNum = 327913;BA.debugLine="barGraphInitialized = True";
_bargraphinitialized = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=327914;
 //BA.debugLineNum = 327914;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 }else {
RDebugUtils.currentLine=327916;
 //BA.debugLineNum = 327916;BA.debugLine="barGraph.sale_1 = sales";
mostCurrent._bargraph._sale_1 /*int[]*/  = _sales;
RDebugUtils.currentLine=327917;
 //BA.debugLineNum = 327917;BA.debugLine="barGraph.sale_2 = sales1";
mostCurrent._bargraph._sale_2 /*int[]*/  = _sales1;
RDebugUtils.currentLine=327918;
 //BA.debugLineNum = 327918;BA.debugLine="barGraph.sale_3 = sales2";
mostCurrent._bargraph._sale_3 /*int[]*/  = _sales2;
RDebugUtils.currentLine=327919;
 //BA.debugLineNum = 327919;BA.debugLine="barGraph.product1 = companyName";
mostCurrent._bargraph._product1 /*String[]*/  = _companyname;
RDebugUtils.currentLine=327920;
 //BA.debugLineNum = 327920;BA.debugLine="barGraph.comId1 = sales ' Assuming comId1 sh";
mostCurrent._bargraph._comid1 /*int[]*/  = _sales;
RDebugUtils.currentLine=327921;
 //BA.debugLineNum = 327921;BA.debugLine="barGraph.UpdateGraph";
mostCurrent._bargraph._updategraph /*String*/ (null);
 };
RDebugUtils.currentLine=327923;
 //BA.debugLineNum = 327923;BA.debugLine="If barGraphInitialized = False Then";
if (_bargraphinitialized==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=327924;
 //BA.debugLineNum = 327924;BA.debugLine="Dim totalPurchasePanel As Panel";
_totalpurchasepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=327925;
 //BA.debugLineNum = 327925;BA.debugLine="totalPurchasePanel.Initialize(\"\")";
_totalpurchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327926;
 //BA.debugLineNum = 327926;BA.debugLine="ScrollView1.Panel.AddView(totalPurchasePanel";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_totalpurchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),(int) (mostCurrent._barpanel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=327928;
 //BA.debugLineNum = 327928;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=327929;
 //BA.debugLineNum = 327929;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"stock.";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"stock.png");
RDebugUtils.currentLine=327931;
 //BA.debugLineNum = 327931;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=327932;
 //BA.debugLineNum = 327932;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327933;
 //BA.debugLineNum = 327933;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=327934;
 //BA.debugLineNum = 327934;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=327935;
 //BA.debugLineNum = 327935;BA.debugLine="totalPurchasePanel.AddView(imgView, 0dip, 12";
_totalpurchasepanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_totalpurchasepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=327937;
 //BA.debugLineNum = 327937;BA.debugLine="Dim totalPurchaseLabel As Label";
_totalpurchaselabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=327938;
 //BA.debugLineNum = 327938;BA.debugLine="totalPurchaseLabel.Initialize(\"\")";
_totalpurchaselabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327939;
 //BA.debugLineNum = 327939;BA.debugLine="totalPurchaseLabel.Text = \"Total Purchases\"";
_totalpurchaselabel.setText(BA.ObjectToCharSequence("Total Purchases"));
RDebugUtils.currentLine=327940;
 //BA.debugLineNum = 327940;BA.debugLine="totalPurchaseLabel.TextColor =Colors.Black";
_totalpurchaselabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=327941;
 //BA.debugLineNum = 327941;BA.debugLine="totalPurchaseLabel.Gravity = Gravity.CENTER_";
_totalpurchaselabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=327942;
 //BA.debugLineNum = 327942;BA.debugLine="totalPurchaseLabel.Typeface = Typeface.MONOS";
_totalpurchaselabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=327943;
 //BA.debugLineNum = 327943;BA.debugLine="totalPurchasePanel.AddView(totalPurchaseLabe";
_totalpurchasepanel.AddView((android.view.View)(_totalpurchaselabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),_totalpurchasepanel.getHeight());
RDebugUtils.currentLine=327946;
 //BA.debugLineNum = 327946;BA.debugLine="Dim shadowPurchPanel As Panel";
_shadowpurchpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=327947;
 //BA.debugLineNum = 327947;BA.debugLine="shadowPurchPanel.Initialize(\"\")";
_shadowpurchpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327948;
 //BA.debugLineNum = 327948;BA.debugLine="shadowPurchPanel.Color = Colors.ARGB(50, 138";
_shadowpurchpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (138),(int) (138),(int) (138)));
RDebugUtils.currentLine=327949;
 //BA.debugLineNum = 327949;BA.debugLine="ScrollView1.Panel.AddView(shadowPurchPanel,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_shadowpurchpanel.getObject()),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()+mostCurrent._barpanel.getHeight()+_totalpurchaselabel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=327951;
 //BA.debugLineNum = 327951;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327952;
 //BA.debugLineNum = 327952;BA.debugLine="purchasePanel.Color = Colors.White";
mostCurrent._purchasepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=327953;
 //BA.debugLineNum = 327953;BA.debugLine="ScrollView1.Panel.AddView(purchasePanel,25di";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (_totalsalelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight()+mostCurrent._barpanel.getHeight()+_totalpurchaselabel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=327954;
 //BA.debugLineNum = 327954;BA.debugLine="purchNxtBtn.Initialize(\"\")";
mostCurrent._purchnxtbtn.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327955;
 //BA.debugLineNum = 327955;BA.debugLine="purchBackBtn.Initialize(\"\")";
mostCurrent._purchbackbtn.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=327956;
 //BA.debugLineNum = 327956;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
mostCurrent._sortbtn1.Initialize(mostCurrent.activityBA,"sortBtn1");
RDebugUtils.currentLine=327957;
 //BA.debugLineNum = 327957;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
mostCurrent._sortbtn2.Initialize(mostCurrent.activityBA,"sortBtn2");
RDebugUtils.currentLine=327958;
 //BA.debugLineNum = 327958;BA.debugLine="defBtn.Initialize(\"defBtn\")";
mostCurrent._defbtn.Initialize(mostCurrent.activityBA,"defBtn");
RDebugUtils.currentLine=327959;
 //BA.debugLineNum = 327959;BA.debugLine="sales1btn.Initialize(\"sales1btn\")";
mostCurrent._sales1btn.Initialize(mostCurrent.activityBA,"sales1btn");
RDebugUtils.currentLine=327960;
 //BA.debugLineNum = 327960;BA.debugLine="sales2btn.Initialize(\"sales2btn\")";
mostCurrent._sales2btn.Initialize(mostCurrent.activityBA,"sales2btn");
RDebugUtils.currentLine=327961;
 //BA.debugLineNum = 327961;BA.debugLine="sales3btn.Initialize(\"sales3btn\")";
mostCurrent._sales3btn.Initialize(mostCurrent.activityBA,"sales3btn");
RDebugUtils.currentLine=327963;
 //BA.debugLineNum = 327963;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel";
mostCurrent._bargraph1._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_purchase,_purchase1,_purchase2,_companyname,mostCurrent._legend,_maxsale,"Total Purchase Per Company",_comid,"Branch",mostCurrent._purchnxtbtn,mostCurrent._purchbackbtn,mostCurrent._sortbtn1,mostCurrent._sortbtn2,mostCurrent._defbtn,mostCurrent._sales1btn,mostCurrent._sales2btn,mostCurrent._sales3btn);
 };
RDebugUtils.currentLine=327967;
 //BA.debugLineNum = 327967;BA.debugLine="totalGraphDataHeight = 1000dip";
_totalgraphdataheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1000));
RDebugUtils.currentLine=327969;
 //BA.debugLineNum = 327969;BA.debugLine="Log($\"maxSale:${maxSale}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7327969",("maxSale:"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_maxsale))+""),0);
 break; }
case 2: {
RDebugUtils.currentLine=327971;
 //BA.debugLineNum = 327971;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=327972;
 //BA.debugLineNum = 327972;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=327974;
 //BA.debugLineNum = 327974;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("7327974","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e245) {
			processBA.setLastException(e245);RDebugUtils.currentLine=327980;
 //BA.debugLineNum = 327980;BA.debugLine="Log(\"\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7327980","",0);
 };
RDebugUtils.currentLine=327982;
 //BA.debugLineNum = 327982;BA.debugLine="ScrollView1.Panel.Height = totalGraphDataHeight";
mostCurrent._scrollview1.getPanel().setHeight((int) (_totalgraphdataheight+_totalgetdataheight));
 }else {
RDebugUtils.currentLine=327985;
 //BA.debugLineNum = 327985;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=327987;
 //BA.debugLineNum = 327987;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=327988;
 //BA.debugLineNum = 327988;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Starter.company_selected = selectedCompany";
mostCurrent._starter._company_selected /*String*/  = _selectedcompany;
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="End Sub";
return "";
}
public static String  _nxtbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtbtn_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub nxtBtn_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Log(\"sad\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7655361","sad",0);
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _sales1btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sales1btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sales1btn_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub sales1btn_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim btn As RadioButton = Sender ' Assuming it's a";
_btn = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_btn = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="salesData1 = 1 ' Set to integer value for Sales1";
_salesdata1 = (int) (1);
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="Log(\"Sales 1 Button clicked: \" & index)";
anywheresoftware.b4a.keywords.Common.LogImpl("7917509","Sales 1 Button clicked: "+_index,0);
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7917510",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="LoadGraphData";
_loadgraphdata();
 };
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="End Sub";
return "";
}
public static String  _sales2btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sales2btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sales2btn_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub sales2btn_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Dim btn As RadioButton = Sender";
_btn = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_btn = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="salesData1 = 2 ' Set to integer value for Sales2";
_salesdata1 = (int) (2);
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="Log(\"Sales 2 Button clicked: \" & index)";
anywheresoftware.b4a.keywords.Common.LogImpl("7983045","Sales 2 Button clicked: "+_index,0);
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7983046",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="LoadGraphData";
_loadgraphdata();
 };
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="End Sub";
return "";
}
public static String  _sales3btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sales3btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sales3btn_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub sales3btn_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim btn As RadioButton = Sender";
_btn = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_btn = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="salesData1 = 3 ' Set to integer value for Sales3";
_salesdata1 = (int) (3);
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="Log(\"Sales 3 Button clicked: \" & index)";
anywheresoftware.b4a.keywords.Common.LogImpl("71048581","Sales 3 Button clicked: "+_index,0);
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("71048582",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="If sortDefaultValue = \"asc\" Or sortDefaultValue =";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="LoadGraphData";
_loadgraphdata();
 };
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn1_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
boolean[] _checkedsales = null;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub sortBtn1_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"asc\"";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7851973",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="If Not(barGraphInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_bargraphinitialized)) { 
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Graph not yet initialized."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
_checkedsales = mostCurrent._bargraph._getcheckedsales /*boolean[]*/ (null);
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="If checkedSales.Length > 0 Then";
if (_checkedsales.length>0) { 
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="Select Case salesData1";
switch (_salesdata1) {
case 1: {
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="If Not(checkedSales(0)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (0)])) { 
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851987;
 //BA.debugLineNum = 851987;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 2: {
RDebugUtils.currentLine=851990;
 //BA.debugLineNum = 851990;BA.debugLine="If Not(checkedSales(1)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (1)])) { 
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 3: {
RDebugUtils.currentLine=851995;
 //BA.debugLineNum = 851995;BA.debugLine="If Not(checkedSales(2)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (2)])) { 
RDebugUtils.currentLine=851996;
 //BA.debugLineNum = 851996;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851997;
 //BA.debugLineNum = 851997;BA.debugLine="Return";
if (true) return "";
 };
 break; }
}
;
 };
RDebugUtils.currentLine=852002;
 //BA.debugLineNum = 852002;BA.debugLine="LoadGraphData";
_loadgraphdata();
RDebugUtils.currentLine=852003;
 //BA.debugLineNum = 852003;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn2_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
boolean[] _checkedsales = null;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub sortBtn2_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"desc\"";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7720901",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="If Not(barGraphInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_bargraphinitialized)) { 
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Graph not yet initialized."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
_checkedsales = mostCurrent._bargraph._getcheckedsales /*boolean[]*/ (null);
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="If checkedSales.Length > 0 Then";
if (_checkedsales.length>0) { 
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="Select Case salesData1";
switch (_salesdata1) {
case 1: {
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="If Not(checkedSales(0)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (0)])) { 
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 2: {
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="If Not(checkedSales(1)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (1)])) { 
RDebugUtils.currentLine=720919;
 //BA.debugLineNum = 720919;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720920;
 //BA.debugLineNum = 720920;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 3: {
RDebugUtils.currentLine=720923;
 //BA.debugLineNum = 720923;BA.debugLine="If Not(checkedSales(2)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (2)])) { 
RDebugUtils.currentLine=720924;
 //BA.debugLineNum = 720924;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720925;
 //BA.debugLineNum = 720925;BA.debugLine="Return";
if (true) return "";
 };
 break; }
}
;
 };
RDebugUtils.currentLine=720930;
 //BA.debugLineNum = 720930;BA.debugLine="LoadGraphData";
_loadgraphdata();
RDebugUtils.currentLine=720931;
 //BA.debugLineNum = 720931;BA.debugLine="End Sub";
return "";
}
}