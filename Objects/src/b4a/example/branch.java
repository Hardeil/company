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

public class branch extends Activity implements B4AActivity{
	public static branch mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.branch");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (branch).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.branch");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.branch", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (branch) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (branch) Resume **");
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
		return branch.class;
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
            BA.LogInfo("** Activity (branch) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (branch) Pause event (activity is not paused). **");
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
            branch mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (branch) Resume **");
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
public static String _company_name = "";
public static String _branch_selected = "";
public static String _phpurl = "";
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeltitle = null;
public static int _titlefontsize = 0;
public static int _primaryfontsize = 0;
public static int _secondaryfontsize = 0;
public static int _num = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _home = null;
public anywheresoftware.b4a.objects.LabelWrapper _branches = null;
public anywheresoftware.b4a.objects.PanelWrapper _popuppanel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _target_countlabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _target_id_display = null;
public anywheresoftware.b4a.objects.LabelWrapper _totaltarget = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel = null;
public b4a.example.main _main = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.PanelWrapper _popuppanelbackground = null;
int _leftposition = 0;
anywheresoftware.b4a.objects.LabelWrapper _closebutton = null;
anywheresoftware.b4a.objects.LabelWrapper _popuptext = null;
anywheresoftware.b4a.objects.ButtonWrapper _edit_button = null;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Activity.LoadLayout(\"Branch\")";
mostCurrent._activity.LoadLayout("Branch",mostCurrent.activityBA);
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="home.TextSize = 16 '";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="Panel3.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="Panel3.Color = Colors.Transparent";
mostCurrent._panel3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=917518;
 //BA.debugLineNum = 917518;BA.debugLine="branches.Initialize(\"\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=917520;
 //BA.debugLineNum = 917520;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="Panel3.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=917526;
 //BA.debugLineNum = 917526;BA.debugLine="popupPanel.Initialize(\"\")";
mostCurrent._popuppanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=917527;
 //BA.debugLineNum = 917527;BA.debugLine="popupPanel.Color = Colors.ARGB(200, 0, 0, 0) ' Se";
mostCurrent._popuppanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (200),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=917528;
 //BA.debugLineNum = 917528;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917529;
 //BA.debugLineNum = 917529;BA.debugLine="Activity.AddView(popupPanel, 0, 0, Activity.Width";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._popuppanel.getObject()),(int) (0),(int) (0),mostCurrent._activity.getWidth(),mostCurrent._activity.getHeight());
RDebugUtils.currentLine=917534;
 //BA.debugLineNum = 917534;BA.debugLine="Dim popupPanelBackground As Panel";
_popuppanelbackground = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=917535;
 //BA.debugLineNum = 917535;BA.debugLine="popupPanelBackground.Initialize(\"\")";
_popuppanelbackground.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=917536;
 //BA.debugLineNum = 917536;BA.debugLine="popupPanelBackground.Color = Colors.White";
_popuppanelbackground.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=917537;
 //BA.debugLineNum = 917537;BA.debugLine="popupPanel.AddView(popupPanelBackground, 70dip, 5";
mostCurrent._popuppanel.AddView((android.view.View)(_popuppanelbackground.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (550)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500))));
RDebugUtils.currentLine=917538;
 //BA.debugLineNum = 917538;BA.debugLine="Dim leftPosition As Int = (popupPanel.Width - pop";
_leftposition = (int) ((mostCurrent._popuppanel.getWidth()-_popuppanelbackground.getWidth())/(double)2);
RDebugUtils.currentLine=917539;
 //BA.debugLineNum = 917539;BA.debugLine="popupPanelBackground.Left = leftPosition";
_popuppanelbackground.setLeft(_leftposition);
RDebugUtils.currentLine=917542;
 //BA.debugLineNum = 917542;BA.debugLine="Dim closeButton As Label";
_closebutton = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=917543;
 //BA.debugLineNum = 917543;BA.debugLine="closeButton.Initialize(\"closeButton\")";
_closebutton.Initialize(mostCurrent.activityBA,"closeButton");
RDebugUtils.currentLine=917544;
 //BA.debugLineNum = 917544;BA.debugLine="closeButton.Text = \"X\"";
_closebutton.setText(BA.ObjectToCharSequence("X"));
RDebugUtils.currentLine=917545;
 //BA.debugLineNum = 917545;BA.debugLine="closeButton.TextSize = 20";
_closebutton.setTextSize((float) (20));
RDebugUtils.currentLine=917546;
 //BA.debugLineNum = 917546;BA.debugLine="closeButton.TextColor = Colors.Red";
_closebutton.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=917547;
 //BA.debugLineNum = 917547;BA.debugLine="closeButton.Typeface = Typeface.DEFAULT_BOLD";
_closebutton.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=917548;
 //BA.debugLineNum = 917548;BA.debugLine="popupPanelBackground.AddView(closeButton, popupPa";
_popuppanelbackground.AddView((android.view.View)(_closebutton.getObject()),(int) (_popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=917550;
 //BA.debugLineNum = 917550;BA.debugLine="target_id_display.Initialize(\"target_id_display\")";
mostCurrent._target_id_display.Initialize(mostCurrent.activityBA,"target_id_display");
RDebugUtils.currentLine=917551;
 //BA.debugLineNum = 917551;BA.debugLine="target_id_display.TextSize = 20";
mostCurrent._target_id_display.setTextSize((float) (20));
RDebugUtils.currentLine=917552;
 //BA.debugLineNum = 917552;BA.debugLine="target_id_display.TextColor = Colors.Red";
mostCurrent._target_id_display.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=917553;
 //BA.debugLineNum = 917553;BA.debugLine="target_id_display.Typeface = Typeface.DEFAULT_BOL";
mostCurrent._target_id_display.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=917554;
 //BA.debugLineNum = 917554;BA.debugLine="popupPanelBackground.AddView(target_id_display, p";
_popuppanelbackground.AddView((android.view.View)(mostCurrent._target_id_display.getObject()),(int) (_popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=917558;
 //BA.debugLineNum = 917558;BA.debugLine="Dim popupText As Label";
_popuptext = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=917559;
 //BA.debugLineNum = 917559;BA.debugLine="popupText.Initialize(\"\")";
_popuptext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=917560;
 //BA.debugLineNum = 917560;BA.debugLine="popupText.Text = \"Edit Target\"";
_popuptext.setText(BA.ObjectToCharSequence("Edit Target"));
RDebugUtils.currentLine=917561;
 //BA.debugLineNum = 917561;BA.debugLine="popupText.TextColor = Colors.Black";
_popuptext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=917562;
 //BA.debugLineNum = 917562;BA.debugLine="popupText.TextSize = 58";
_popuptext.setTextSize((float) (58));
RDebugUtils.currentLine=917563;
 //BA.debugLineNum = 917563;BA.debugLine="popupText.Gravity = Gravity.CENTER";
_popuptext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=917564;
 //BA.debugLineNum = 917564;BA.debugLine="popupPanelBackground.AddView(popupText, 25dip, 10";
_popuppanelbackground.AddView((android.view.View)(_popuptext.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=917566;
 //BA.debugLineNum = 917566;BA.debugLine="target_countLabel.Initialize(\"\")";
mostCurrent._target_countlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=917567;
 //BA.debugLineNum = 917567;BA.debugLine="target_countLabel.TextColor = Colors.Black";
mostCurrent._target_countlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=917568;
 //BA.debugLineNum = 917568;BA.debugLine="target_countLabel.TextSize = 58";
mostCurrent._target_countlabel.setTextSize((float) (58));
RDebugUtils.currentLine=917569;
 //BA.debugLineNum = 917569;BA.debugLine="target_countLabel.Gravity = Gravity.CENTER";
mostCurrent._target_countlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=917570;
 //BA.debugLineNum = 917570;BA.debugLine="popupPanelBackground.AddView(target_countLabel, 2";
_popuppanelbackground.AddView((android.view.View)(mostCurrent._target_countlabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=917571;
 //BA.debugLineNum = 917571;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
RDebugUtils.currentLine=917573;
 //BA.debugLineNum = 917573;BA.debugLine="Dim edit_button As Button";
_edit_button = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=917574;
 //BA.debugLineNum = 917574;BA.debugLine="edit_button.Initialize(\"edit_button\")";
_edit_button.Initialize(mostCurrent.activityBA,"edit_button");
RDebugUtils.currentLine=917575;
 //BA.debugLineNum = 917575;BA.debugLine="edit_button.Text = \"Update\"";
_edit_button.setText(BA.ObjectToCharSequence("Update"));
RDebugUtils.currentLine=917576;
 //BA.debugLineNum = 917576;BA.debugLine="edit_button.TextColor = Colors.Black";
_edit_button.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=917577;
 //BA.debugLineNum = 917577;BA.debugLine="edit_button.TextSize = 58";
_edit_button.setTextSize((float) (58));
RDebugUtils.currentLine=917578;
 //BA.debugLineNum = 917578;BA.debugLine="edit_button.Gravity = Gravity.CENTER";
_edit_button.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=917579;
 //BA.debugLineNum = 917579;BA.debugLine="popupPanelBackground.AddView(edit_button, 25dip,";
_popuppanelbackground.AddView((android.view.View)(_edit_button.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=917581;
 //BA.debugLineNum = 917581;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=917582;
 //BA.debugLineNum = 917582;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="totalTarget.Initialize(\"\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="Panel.Initialize(\"\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Panel.RemoveAllViews";
mostCurrent._panel.RemoveAllViews();
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="PHPURL = \"https://192.168.8.141/Company/fetch.php";
mostCurrent._phpurl = "https://192.168.8.141/Company/fetch.php?action=get_branch&company_id="+mostCurrent._starter._company_selected /*String*/ ;
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",branch.getObject());
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="branch";
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _closebutton_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closebutton_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closebutton_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub closeButton_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static String  _edit_button_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edit_button_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edit_button_click", null));}
int _target_id = 0;
int _new_value = 0;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub edit_button_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Dim target_id As Int = target_id_display.Text '";
_target_id = (int)(Double.parseDouble(mostCurrent._target_id_display.getText()));
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim new_value As Int = target_countLabel.Text '";
_new_value = (int)(Double.parseDouble(mostCurrent._target_countlabel.getText()));
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_target_id)) && anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_new_value))) { 
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="UpdateData_Remote(target_id, new_value)";
_updatedata_remote(_target_id,_new_value);
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Log(\"Updated target \" & target_id & \" with value";
anywheresoftware.b4a.keywords.Common.LogImpl("8983046","Updated target "+BA.NumberToString(_target_id)+" with value "+BA.NumberToString(_new_value),0);
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 }else {
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="Log(\"Invalid input values\")";
anywheresoftware.b4a.keywords.Common.LogImpl("8983049","Invalid input values",0);
 };
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="End Sub";
return "";
}
public static String  _updatedata_remote(int _target_id,int _new_value) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatedata_remote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updatedata_remote", new Object[] {_target_id,_new_value}));}
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.141/Co";
mostCurrent._phpurl = ("https://192.168.8.141/Company/fetch.php?action=target_update&id="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_target_id))+"&value="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_new_value))+"");
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
_job._initialize /*String*/ (null,processBA,"UpdateData",branch.getObject());
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="job.Download(PHPURL)";
_job._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
int _scrollheight = 0;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _numcolumns = 0;
int _pnlwidth = 0;
int _pnlheight = 0;
int _padding = 0;
int _leftposition = 0;
int _topposition = 0;
int _count = 0;
anywheresoftware.b4a.objects.collections.Map _record = null;
String _companyname = "";
String _id = "";
String _name = "";
int _total_count = 0;
int _total_pos = 0;
String _totalpur1 = "";
String _totalpur2 = "";
String _totalpur3 = "";
String _totalsales1 = "";
String _totalsales2 = "";
String _totalsales3 = "";
String _target_id = "";
anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient = null;
anywheresoftware.b4a.objects.LabelWrapper _branchnamelabel = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _myimage = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _resizedimage = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
int _panelwidth = 0;
int _labelheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _purchase1 = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase1title = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase2 = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase2title = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase3 = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase3title = null;
anywheresoftware.b4a.objects.LabelWrapper _sale1 = null;
anywheresoftware.b4a.objects.LabelWrapper _sale1title = null;
anywheresoftware.b4a.objects.LabelWrapper _sale2 = null;
anywheresoftware.b4a.objects.LabelWrapper _sale2title = null;
anywheresoftware.b4a.objects.LabelWrapper _sale3 = null;
anywheresoftware.b4a.objects.LabelWrapper _sale3title = null;
anywheresoftware.b4a.objects.LabelWrapper _totaltargettitle = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpos = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpostitle = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="Try";
try {RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","UpdateData")) {
case 0: {
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
_numcolumns = (int) (2);
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
_pnlwidth = (int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="Dim pnlHeight As Int = 280dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280));
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="Dim leftPosition As Int = 50dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=851987;
 //BA.debugLineNum = 851987;BA.debugLine="Dim topPosition As Int = 0";
_topposition = (int) (0);
RDebugUtils.currentLine=851988;
 //BA.debugLineNum = 851988;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=851990;
 //BA.debugLineNum = 851990;BA.debugLine="pnlWidth = 490dip";
_pnlwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (490));
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="pnlHeight = 300dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300));
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="padding = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=851993;
 //BA.debugLineNum = 851993;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 };
RDebugUtils.currentLine=851996;
 //BA.debugLineNum = 851996;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group24 = mostCurrent._tabledetails;
final int groupLen24 = group24.getSize()
;int index24 = 0;
;
for (; index24 < groupLen24;index24++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group24.Get(index24)));
RDebugUtils.currentLine=851998;
 //BA.debugLineNum = 851998;BA.debugLine="Dim companyName As String = record.Get(\"comp";
_companyname = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=851999;
 //BA.debugLineNum = 851999;BA.debugLine="Dim id As String = record.Get(\"id\")";
_id = BA.ObjectToString(_record.Get((Object)("id")));
RDebugUtils.currentLine=852000;
 //BA.debugLineNum = 852000;BA.debugLine="Dim name As String = record.Get(\"branch_name";
_name = BA.ObjectToString(_record.Get((Object)("branch_name")));
RDebugUtils.currentLine=852001;
 //BA.debugLineNum = 852001;BA.debugLine="Dim total_count As Int = record.Get(\"target_";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("target_no"))));
RDebugUtils.currentLine=852002;
 //BA.debugLineNum = 852002;BA.debugLine="Dim total_pos As Int = record.Get(\"total_dev";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("total_device"))));
RDebugUtils.currentLine=852003;
 //BA.debugLineNum = 852003;BA.debugLine="Dim totalPur1 As String = record.Get(\"purcha";
_totalpur1 = BA.ObjectToString(_record.Get((Object)("purchase_1")));
RDebugUtils.currentLine=852004;
 //BA.debugLineNum = 852004;BA.debugLine="Dim totalPur2 As String = record.Get(\"purcha";
_totalpur2 = BA.ObjectToString(_record.Get((Object)("purchase_2")));
RDebugUtils.currentLine=852005;
 //BA.debugLineNum = 852005;BA.debugLine="Dim totalPur3 As String = record.Get(\"purcha";
_totalpur3 = BA.ObjectToString(_record.Get((Object)("purchase_3")));
RDebugUtils.currentLine=852006;
 //BA.debugLineNum = 852006;BA.debugLine="Dim totalSales1 As String = record.Get(\"tota";
_totalsales1 = BA.ObjectToString(_record.Get((Object)("total_sales1")));
RDebugUtils.currentLine=852007;
 //BA.debugLineNum = 852007;BA.debugLine="Dim totalSales2 As String = record.Get(\"tota";
_totalsales2 = BA.ObjectToString(_record.Get((Object)("total_sales2")));
RDebugUtils.currentLine=852008;
 //BA.debugLineNum = 852008;BA.debugLine="Dim totalSales3 As String = record.Get(\"tota";
_totalsales3 = BA.ObjectToString(_record.Get((Object)("total_sales3")));
RDebugUtils.currentLine=852009;
 //BA.debugLineNum = 852009;BA.debugLine="Dim target_id As String = record.Get(\"branch";
_target_id = BA.ObjectToString(_record.Get((Object)("branch_target_id")));
RDebugUtils.currentLine=852010;
 //BA.debugLineNum = 852010;BA.debugLine="target_countLabel.Text = total_count";
mostCurrent._target_countlabel.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=852011;
 //BA.debugLineNum = 852011;BA.debugLine="branches.Text = \"Branches - \"&companyName";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_companyname));
RDebugUtils.currentLine=852012;
 //BA.debugLineNum = 852012;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=852014;
 //BA.debugLineNum = 852014;BA.debugLine="LabelTitle.Text = companyName";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_companyname));
RDebugUtils.currentLine=852015;
 //BA.debugLineNum = 852015;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCas";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=852016;
 //BA.debugLineNum = 852016;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
mostCurrent._labeltitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852019;
 //BA.debugLineNum = 852019;BA.debugLine="Panel.Initialize(\"Panel\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=852020;
 //BA.debugLineNum = 852020;BA.debugLine="ScrollView1.Panel.AddView(Panel, leftPositio";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._panel.getObject()),_leftposition,(int) (_topposition+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),_pnlwidth,_pnlheight);
RDebugUtils.currentLine=852021;
 //BA.debugLineNum = 852021;BA.debugLine="Panel.Color = Colors.Black";
mostCurrent._panel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852024;
 //BA.debugLineNum = 852024;BA.debugLine="Dim Panel2 As Panel";
_panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=852025;
 //BA.debugLineNum = 852025;BA.debugLine="Panel2.Initialize(\"Panel2\")";
_panel2.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=852027;
 //BA.debugLineNum = 852027;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=852028;
 //BA.debugLineNum = 852028;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As I";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=852030;
 //BA.debugLineNum = 852030;BA.debugLine="Panel2.Background = gradient";
_panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=852031;
 //BA.debugLineNum = 852031;BA.debugLine="Panel2.Tag = name";
_panel2.setTag((Object)(_name));
RDebugUtils.currentLine=852032;
 //BA.debugLineNum = 852032;BA.debugLine="Panel2.SendToBack";
_panel2.SendToBack();
RDebugUtils.currentLine=852033;
 //BA.debugLineNum = 852033;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y";
mostCurrent._panel.AddView((android.view.View)(_panel2.getObject()),(int) (0),(int) (0),mostCurrent._panel.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=852036;
 //BA.debugLineNum = 852036;BA.debugLine="Dim BranchNameLabel As Label";
_branchnamelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852037;
 //BA.debugLineNum = 852037;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
_branchnamelabel.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=852038;
 //BA.debugLineNum = 852038;BA.debugLine="BranchNameLabel.Text = name";
_branchnamelabel.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=852039;
 //BA.debugLineNum = 852039;BA.debugLine="BranchNameLabel.Tag = id";
_branchnamelabel.setTag((Object)(_id));
RDebugUtils.currentLine=852040;
 //BA.debugLineNum = 852040;BA.debugLine="BranchNameLabel.TextSize = 18";
_branchnamelabel.setTextSize((float) (18));
RDebugUtils.currentLine=852041;
 //BA.debugLineNum = 852041;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
_branchnamelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=852042;
 //BA.debugLineNum = 852042;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPAC";
_branchnamelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852043;
 //BA.debugLineNum = 852043;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VER";
_branchnamelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=852044;
 //BA.debugLineNum = 852044;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip,";
_panel2.AddView((android.view.View)(_branchnamelabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panel2.getWidth(),_panel2.getHeight());
RDebugUtils.currentLine=852046;
 //BA.debugLineNum = 852046;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=852047;
 //BA.debugLineNum = 852047;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=852048;
 //BA.debugLineNum = 852048;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=852049;
 //BA.debugLineNum = 852049;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=852050;
 //BA.debugLineNum = 852050;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=852051;
 //BA.debugLineNum = 852051;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852052;
 //BA.debugLineNum = 852052;BA.debugLine="imgView.Bitmap = resizedImage";
_imgview.setBitmap((android.graphics.Bitmap)(_resizedimage.getObject()));
RDebugUtils.currentLine=852053;
 //BA.debugLineNum = 852053;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x,";
_panel2.AddView((android.view.View)(_imgview.getObject()),(int) (_panel2.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),_panel2.getHeight());
 }else {
RDebugUtils.currentLine=852055;
 //BA.debugLineNum = 852055;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("8852055","Error loading image",0);
 };
RDebugUtils.currentLine=852058;
 //BA.debugLineNum = 852058;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)3);
RDebugUtils.currentLine=852059;
 //BA.debugLineNum = 852059;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=852060;
 //BA.debugLineNum = 852060;BA.debugLine="Dim labelheight As Int = 35dip";
_labelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35));
RDebugUtils.currentLine=852062;
 //BA.debugLineNum = 852062;BA.debugLine="Dim purchase1 As Label";
_purchase1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852063;
 //BA.debugLineNum = 852063;BA.debugLine="purchase1.Initialize(\"\")";
_purchase1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852064;
 //BA.debugLineNum = 852064;BA.debugLine="purchase1.Text = totalPur1";
_purchase1.setText(BA.ObjectToCharSequence(_totalpur1));
RDebugUtils.currentLine=852065;
 //BA.debugLineNum = 852065;BA.debugLine="purchase1.TextColor = Colors.Black";
_purchase1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852066;
 //BA.debugLineNum = 852066;BA.debugLine="purchase1.TextSize = primaryFontSize";
_purchase1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=852067;
 //BA.debugLineNum = 852067;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
_purchase1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852068;
 //BA.debugLineNum = 852068;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
_purchase1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=852069;
 //BA.debugLineNum = 852069;BA.debugLine="Panel.AddView(purchase1,0,Panel2.Height+padd";
mostCurrent._panel.AddView((android.view.View)(_purchase1.getObject()),(int) (0),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=852071;
 //BA.debugLineNum = 852071;BA.debugLine="Dim purchase1Title As Label";
_purchase1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852072;
 //BA.debugLineNum = 852072;BA.debugLine="purchase1Title.Initialize(\"\")";
_purchase1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852073;
 //BA.debugLineNum = 852073;BA.debugLine="purchase1Title.Text = \"First Purchase\"";
_purchase1title.setText(BA.ObjectToCharSequence("First Purchase"));
RDebugUtils.currentLine=852074;
 //BA.debugLineNum = 852074;BA.debugLine="purchase1Title.TextColor = Colors.Gray";
_purchase1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=852075;
 //BA.debugLineNum = 852075;BA.debugLine="purchase1Title.TextSize = secondaryFontSize";
_purchase1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=852076;
 //BA.debugLineNum = 852076;BA.debugLine="purchase1Title.Gravity = Gravity.CENTER";
_purchase1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852077;
 //BA.debugLineNum = 852077;BA.debugLine="purchase1Title.Typeface = Typeface.MONOSPACE";
_purchase1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852078;
 //BA.debugLineNum = 852078;BA.debugLine="purchase1Title.Text = purchase1Title.Text.To";
_purchase1title.setText(BA.ObjectToCharSequence(_purchase1title.getText().toUpperCase()));
RDebugUtils.currentLine=852079;
 //BA.debugLineNum = 852079;BA.debugLine="Panel.AddView(purchase1Title,0,purchase1.top";
mostCurrent._panel.AddView((android.view.View)(_purchase1title.getObject()),(int) (0),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852081;
 //BA.debugLineNum = 852081;BA.debugLine="Dim purchase2 As Label";
_purchase2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852082;
 //BA.debugLineNum = 852082;BA.debugLine="purchase2.Initialize(\"\")";
_purchase2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852083;
 //BA.debugLineNum = 852083;BA.debugLine="purchase2.Text = totalPur2";
_purchase2.setText(BA.ObjectToCharSequence(_totalpur2));
RDebugUtils.currentLine=852084;
 //BA.debugLineNum = 852084;BA.debugLine="purchase2.TextColor = Colors.Black";
_purchase2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852085;
 //BA.debugLineNum = 852085;BA.debugLine="purchase2.TextSize = primaryFontSize";
_purchase2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=852086;
 //BA.debugLineNum = 852086;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
_purchase2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852087;
 //BA.debugLineNum = 852087;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
_purchase2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=852088;
 //BA.debugLineNum = 852088;BA.debugLine="Panel.AddView(purchase2,panelWidth,Panel2.He";
mostCurrent._panel.AddView((android.view.View)(_purchase2.getObject()),_panelwidth,(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=852090;
 //BA.debugLineNum = 852090;BA.debugLine="Dim purchase2Title As Label";
_purchase2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852091;
 //BA.debugLineNum = 852091;BA.debugLine="purchase2Title.Initialize(\"\")";
_purchase2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852092;
 //BA.debugLineNum = 852092;BA.debugLine="purchase2Title.Text = \"Second Purchase\"";
_purchase2title.setText(BA.ObjectToCharSequence("Second Purchase"));
RDebugUtils.currentLine=852093;
 //BA.debugLineNum = 852093;BA.debugLine="purchase2Title.TextColor = Colors.Gray";
_purchase2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=852094;
 //BA.debugLineNum = 852094;BA.debugLine="purchase2Title.TextSize = secondaryFontSize";
_purchase2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=852095;
 //BA.debugLineNum = 852095;BA.debugLine="purchase2Title.Gravity = Gravity.CENTER";
_purchase2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852096;
 //BA.debugLineNum = 852096;BA.debugLine="purchase2Title.Typeface = Typeface.MONOSPACE";
_purchase2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852097;
 //BA.debugLineNum = 852097;BA.debugLine="purchase2Title.Text = purchase2Title.Text.To";
_purchase2title.setText(BA.ObjectToCharSequence(_purchase2title.getText().toUpperCase()));
RDebugUtils.currentLine=852098;
 //BA.debugLineNum = 852098;BA.debugLine="Panel.AddView(purchase2Title,panelWidth,purc";
mostCurrent._panel.AddView((android.view.View)(_purchase2title.getObject()),_panelwidth,(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852100;
 //BA.debugLineNum = 852100;BA.debugLine="Dim purchase3 As Label";
_purchase3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852101;
 //BA.debugLineNum = 852101;BA.debugLine="purchase3.Initialize(\"\")";
_purchase3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852102;
 //BA.debugLineNum = 852102;BA.debugLine="purchase3.Text = totalPur3";
_purchase3.setText(BA.ObjectToCharSequence(_totalpur3));
RDebugUtils.currentLine=852103;
 //BA.debugLineNum = 852103;BA.debugLine="purchase3.TextColor = Colors.Black";
_purchase3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852104;
 //BA.debugLineNum = 852104;BA.debugLine="purchase3.TextSize = primaryFontSize";
_purchase3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=852105;
 //BA.debugLineNum = 852105;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
_purchase3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852106;
 //BA.debugLineNum = 852106;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
_purchase3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=852107;
 //BA.debugLineNum = 852107;BA.debugLine="Panel.AddView(purchase3,panelWidth*2,Panel2.";
mostCurrent._panel.AddView((android.view.View)(_purchase3.getObject()),(int) (_panelwidth*2),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=852109;
 //BA.debugLineNum = 852109;BA.debugLine="Dim purchase3Title As Label";
_purchase3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852110;
 //BA.debugLineNum = 852110;BA.debugLine="purchase3Title.Initialize(\"\")";
_purchase3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852111;
 //BA.debugLineNum = 852111;BA.debugLine="purchase3Title.Text = \"Third Purchase\"";
_purchase3title.setText(BA.ObjectToCharSequence("Third Purchase"));
RDebugUtils.currentLine=852112;
 //BA.debugLineNum = 852112;BA.debugLine="purchase3Title.TextColor = Colors.Gray";
_purchase3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=852113;
 //BA.debugLineNum = 852113;BA.debugLine="purchase3Title.TextSize = secondaryFontSize";
_purchase3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=852114;
 //BA.debugLineNum = 852114;BA.debugLine="purchase3Title.Gravity = Gravity.CENTER";
_purchase3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852115;
 //BA.debugLineNum = 852115;BA.debugLine="purchase3Title.Typeface = Typeface.MONOSPACE";
_purchase3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852116;
 //BA.debugLineNum = 852116;BA.debugLine="purchase3Title.Text = purchase3Title.Text.To";
_purchase3title.setText(BA.ObjectToCharSequence(_purchase3title.getText().toUpperCase()));
RDebugUtils.currentLine=852117;
 //BA.debugLineNum = 852117;BA.debugLine="Panel.AddView(purchase3Title,panelWidth*2,pu";
mostCurrent._panel.AddView((android.view.View)(_purchase3title.getObject()),(int) (_panelwidth*2),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852119;
 //BA.debugLineNum = 852119;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852120;
 //BA.debugLineNum = 852120;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852121;
 //BA.debugLineNum = 852121;BA.debugLine="sale1.Text = totalSales1";
_sale1.setText(BA.ObjectToCharSequence(_totalsales1));
RDebugUtils.currentLine=852122;
 //BA.debugLineNum = 852122;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852123;
 //BA.debugLineNum = 852123;BA.debugLine="sale1.TextSize = primaryFontSize";
_sale1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=852124;
 //BA.debugLineNum = 852124;BA.debugLine="sale1.Gravity = Gravity.CENTER";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852125;
 //BA.debugLineNum = 852125;BA.debugLine="sale1.Typeface = Typeface.SERIF";
_sale1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=852126;
 //BA.debugLineNum = 852126;BA.debugLine="Panel.AddView(sale1,0,purchase3Title.Height+";
mostCurrent._panel.AddView((android.view.View)(_sale1.getObject()),(int) (0),(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852128;
 //BA.debugLineNum = 852128;BA.debugLine="Dim sale1Title As Label";
_sale1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852129;
 //BA.debugLineNum = 852129;BA.debugLine="sale1Title.Initialize(\"\")";
_sale1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852130;
 //BA.debugLineNum = 852130;BA.debugLine="sale1Title.Text = \"First Sale\"";
_sale1title.setText(BA.ObjectToCharSequence("First Sale"));
RDebugUtils.currentLine=852131;
 //BA.debugLineNum = 852131;BA.debugLine="sale1Title.TextColor = Colors.Gray";
_sale1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=852132;
 //BA.debugLineNum = 852132;BA.debugLine="sale1Title.TextSize = secondaryFontSize";
_sale1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=852133;
 //BA.debugLineNum = 852133;BA.debugLine="sale1Title.Gravity = Gravity.CENTER";
_sale1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852134;
 //BA.debugLineNum = 852134;BA.debugLine="sale1Title.Typeface = Typeface.MONOSPACE";
_sale1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852135;
 //BA.debugLineNum = 852135;BA.debugLine="sale1Title.Text = sale1Title.Text.ToUpperCas";
_sale1title.setText(BA.ObjectToCharSequence(_sale1title.getText().toUpperCase()));
RDebugUtils.currentLine=852136;
 //BA.debugLineNum = 852136;BA.debugLine="Panel.AddView(sale1Title,0,sale1.top+padding";
mostCurrent._panel.AddView((android.view.View)(_sale1title.getObject()),(int) (0),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852138;
 //BA.debugLineNum = 852138;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852139;
 //BA.debugLineNum = 852139;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852140;
 //BA.debugLineNum = 852140;BA.debugLine="sale2.Text = totalSales2";
_sale2.setText(BA.ObjectToCharSequence(_totalsales2));
RDebugUtils.currentLine=852141;
 //BA.debugLineNum = 852141;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852142;
 //BA.debugLineNum = 852142;BA.debugLine="sale2.TextSize = primaryFontSize";
_sale2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=852143;
 //BA.debugLineNum = 852143;BA.debugLine="sale2.Gravity = Gravity.CENTER";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852144;
 //BA.debugLineNum = 852144;BA.debugLine="sale2.Typeface = Typeface.SERIF";
_sale2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=852145;
 //BA.debugLineNum = 852145;BA.debugLine="Panel.AddView(sale2,panelWidth,purchase3Titl";
mostCurrent._panel.AddView((android.view.View)(_sale2.getObject()),_panelwidth,(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852147;
 //BA.debugLineNum = 852147;BA.debugLine="Dim sale2Title As Label";
_sale2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852148;
 //BA.debugLineNum = 852148;BA.debugLine="sale2Title.Initialize(\"\")";
_sale2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852149;
 //BA.debugLineNum = 852149;BA.debugLine="sale2Title.Text = \" Second Sale\"";
_sale2title.setText(BA.ObjectToCharSequence(" Second Sale"));
RDebugUtils.currentLine=852150;
 //BA.debugLineNum = 852150;BA.debugLine="sale2Title.TextColor = Colors.Gray";
_sale2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=852151;
 //BA.debugLineNum = 852151;BA.debugLine="sale2Title.TextSize = secondaryFontSize";
_sale2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=852152;
 //BA.debugLineNum = 852152;BA.debugLine="sale2Title.Gravity = Gravity.CENTER";
_sale2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852153;
 //BA.debugLineNum = 852153;BA.debugLine="sale2Title.Typeface = Typeface.MONOSPACE";
_sale2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852154;
 //BA.debugLineNum = 852154;BA.debugLine="sale2Title.Text = sale2Title.Text.ToUpperCas";
_sale2title.setText(BA.ObjectToCharSequence(_sale2title.getText().toUpperCase()));
RDebugUtils.currentLine=852155;
 //BA.debugLineNum = 852155;BA.debugLine="Panel.AddView(sale2Title,panelWidth,sale2.to";
mostCurrent._panel.AddView((android.view.View)(_sale2title.getObject()),_panelwidth,(int) (_sale2.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852157;
 //BA.debugLineNum = 852157;BA.debugLine="Dim sale3 As Label";
_sale3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852158;
 //BA.debugLineNum = 852158;BA.debugLine="sale3.Initialize(\"\")";
_sale3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852159;
 //BA.debugLineNum = 852159;BA.debugLine="sale3.Text = totalSales3";
_sale3.setText(BA.ObjectToCharSequence(_totalsales3));
RDebugUtils.currentLine=852160;
 //BA.debugLineNum = 852160;BA.debugLine="sale3.TextColor = Colors.Black";
_sale3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852161;
 //BA.debugLineNum = 852161;BA.debugLine="sale3.TextSize = primaryFontSize";
_sale3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=852162;
 //BA.debugLineNum = 852162;BA.debugLine="sale3.Gravity = Gravity.CENTER";
_sale3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852163;
 //BA.debugLineNum = 852163;BA.debugLine="sale3.Typeface = Typeface.SERIF";
_sale3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=852164;
 //BA.debugLineNum = 852164;BA.debugLine="Panel.AddView(sale3,panelWidth*2,sale2Title.";
mostCurrent._panel.AddView((android.view.View)(_sale3.getObject()),(int) (_panelwidth*2),(int) (_sale2title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852166;
 //BA.debugLineNum = 852166;BA.debugLine="Dim sale3Title As Label";
_sale3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852167;
 //BA.debugLineNum = 852167;BA.debugLine="sale3Title.Initialize(\"\")";
_sale3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852168;
 //BA.debugLineNum = 852168;BA.debugLine="sale3Title.Text = \" Third Sale\"";
_sale3title.setText(BA.ObjectToCharSequence(" Third Sale"));
RDebugUtils.currentLine=852169;
 //BA.debugLineNum = 852169;BA.debugLine="sale3Title.TextColor = Colors.Gray";
_sale3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=852170;
 //BA.debugLineNum = 852170;BA.debugLine="sale3Title.TextSize = secondaryFontSize";
_sale3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=852171;
 //BA.debugLineNum = 852171;BA.debugLine="sale3Title.Gravity = Gravity.CENTER";
_sale3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852172;
 //BA.debugLineNum = 852172;BA.debugLine="sale3Title.Typeface = Typeface.MONOSPACE";
_sale3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852173;
 //BA.debugLineNum = 852173;BA.debugLine="sale3Title.Text = sale3Title.Text.ToUpperCas";
_sale3title.setText(BA.ObjectToCharSequence(_sale3title.getText().toUpperCase()));
RDebugUtils.currentLine=852174;
 //BA.debugLineNum = 852174;BA.debugLine="Panel.AddView(sale3Title,panelWidth*2,sale1.";
mostCurrent._panel.AddView((android.view.View)(_sale3title.getObject()),(int) (_panelwidth*2),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852176;
 //BA.debugLineNum = 852176;BA.debugLine="panelWidth = Panel.Width /2";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)2);
RDebugUtils.currentLine=852178;
 //BA.debugLineNum = 852178;BA.debugLine="totalTarget.Initialize(\"totalTarget\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"totalTarget");
RDebugUtils.currentLine=852179;
 //BA.debugLineNum = 852179;BA.debugLine="totalTarget.Text = total_count";
mostCurrent._totaltarget.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=852180;
 //BA.debugLineNum = 852180;BA.debugLine="totalTarget.Tag = target_id";
mostCurrent._totaltarget.setTag((Object)(_target_id));
RDebugUtils.currentLine=852181;
 //BA.debugLineNum = 852181;BA.debugLine="totalTarget.TextColor = Colors.Black";
mostCurrent._totaltarget.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852182;
 //BA.debugLineNum = 852182;BA.debugLine="totalTarget.Color = Colors.White";
mostCurrent._totaltarget.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=852183;
 //BA.debugLineNum = 852183;BA.debugLine="totalTarget.TextSize = primaryFontSize";
mostCurrent._totaltarget.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=852184;
 //BA.debugLineNum = 852184;BA.debugLine="totalTarget.Gravity = Gravity.CENTER";
mostCurrent._totaltarget.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852185;
 //BA.debugLineNum = 852185;BA.debugLine="totalTarget.Typeface = Typeface.SERIF";
mostCurrent._totaltarget.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=852186;
 //BA.debugLineNum = 852186;BA.debugLine="Panel.AddView(totalTarget,2dip,sale3Title.He";
mostCurrent._panel.AddView((android.view.View)(mostCurrent._totaltarget.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_sale3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852188;
 //BA.debugLineNum = 852188;BA.debugLine="Dim totalTargetTitle As Label";
_totaltargettitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852189;
 //BA.debugLineNum = 852189;BA.debugLine="totalTargetTitle.Initialize(\"totalTargetTitl";
_totaltargettitle.Initialize(mostCurrent.activityBA,"totalTargetTitles");
RDebugUtils.currentLine=852190;
 //BA.debugLineNum = 852190;BA.debugLine="totalTargetTitle.Text = \" Total Target\"";
_totaltargettitle.setText(BA.ObjectToCharSequence(" Total Target"));
RDebugUtils.currentLine=852191;
 //BA.debugLineNum = 852191;BA.debugLine="totalTargetTitle.tag = 20";
_totaltargettitle.setTag((Object)(20));
RDebugUtils.currentLine=852192;
 //BA.debugLineNum = 852192;BA.debugLine="totalTargetTitle.TextColor = Colors.Gray";
_totaltargettitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=852193;
 //BA.debugLineNum = 852193;BA.debugLine="totalTargetTitle.TextSize = secondaryFontSiz";
_totaltargettitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=852194;
 //BA.debugLineNum = 852194;BA.debugLine="totalTargetTitle.Gravity = Gravity.CENTER";
_totaltargettitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852195;
 //BA.debugLineNum = 852195;BA.debugLine="totalTargetTitle.Typeface = Typeface.MONOSPA";
_totaltargettitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852196;
 //BA.debugLineNum = 852196;BA.debugLine="totalTargetTitle.Text = totalTargetTitle.Tex";
_totaltargettitle.setText(BA.ObjectToCharSequence(_totaltargettitle.getText().toUpperCase()));
RDebugUtils.currentLine=852197;
 //BA.debugLineNum = 852197;BA.debugLine="Panel.AddView(totalTargetTitle,0,totalTarget";
mostCurrent._panel.AddView((android.view.View)(_totaltargettitle.getObject()),(int) (0),(int) (mostCurrent._totaltarget.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852199;
 //BA.debugLineNum = 852199;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852200;
 //BA.debugLineNum = 852200;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852201;
 //BA.debugLineNum = 852201;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=852202;
 //BA.debugLineNum = 852202;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=852203;
 //BA.debugLineNum = 852203;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=852204;
 //BA.debugLineNum = 852204;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852205;
 //BA.debugLineNum = 852205;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=852206;
 //BA.debugLineNum = 852206;BA.debugLine="Panel.AddView(totalPos,panelWidth,totalTarge";
mostCurrent._panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,(int) (_totaltargettitle.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852208;
 //BA.debugLineNum = 852208;BA.debugLine="Dim totalPosTitle As Label";
_totalpostitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=852209;
 //BA.debugLineNum = 852209;BA.debugLine="totalPosTitle.Initialize(\"\")";
_totalpostitle.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=852210;
 //BA.debugLineNum = 852210;BA.debugLine="totalPosTitle.Text = \" Total Pos\"";
_totalpostitle.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=852211;
 //BA.debugLineNum = 852211;BA.debugLine="totalPosTitle.TextColor = Colors.Gray";
_totalpostitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=852212;
 //BA.debugLineNum = 852212;BA.debugLine="totalPosTitle.TextSize = secondaryFontSize";
_totalpostitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=852213;
 //BA.debugLineNum = 852213;BA.debugLine="totalPosTitle.Gravity = Gravity.CENTER";
_totalpostitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=852214;
 //BA.debugLineNum = 852214;BA.debugLine="totalPosTitle.Typeface = Typeface.MONOSPACE";
_totalpostitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=852215;
 //BA.debugLineNum = 852215;BA.debugLine="totalPosTitle.Text = totalPosTitle.Text.ToUp";
_totalpostitle.setText(BA.ObjectToCharSequence(_totalpostitle.getText().toUpperCase()));
RDebugUtils.currentLine=852216;
 //BA.debugLineNum = 852216;BA.debugLine="Panel.AddView(totalPosTitle,panelWidth,total";
mostCurrent._panel.AddView((android.view.View)(_totalpostitle.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=852219;
 //BA.debugLineNum = 852219;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=852220;
 //BA.debugLineNum = 852220;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 2dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (156),(int) (0),(int) (0)));
RDebugUtils.currentLine=852221;
 //BA.debugLineNum = 852221;BA.debugLine="Panel.Background = cd";
mostCurrent._panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=852227;
 //BA.debugLineNum = 852227;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=852228;
 //BA.debugLineNum = 852228;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
RDebugUtils.currentLine=852229;
 //BA.debugLineNum = 852229;BA.debugLine="If count Mod numColumns = 0 Then";
if (_count%_numcolumns==0) { 
RDebugUtils.currentLine=852230;
 //BA.debugLineNum = 852230;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=852231;
 //BA.debugLineNum = 852231;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
_topposition = (int) (_topposition+_pnlheight+_padding);
 }else {
RDebugUtils.currentLine=852233;
 //BA.debugLineNum = 852233;BA.debugLine="leftPosition = leftPosition + pnlWidth + p";
_leftposition = (int) (_leftposition+_pnlwidth+_padding);
 };
RDebugUtils.currentLine=852235;
 //BA.debugLineNum = 852235;BA.debugLine="scrollHeight = scrollHeight + 175dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (175)));
 }else {
RDebugUtils.currentLine=852237;
 //BA.debugLineNum = 852237;BA.debugLine="topPosition = topPosition + pnlHeight + pad";
_topposition = (int) (_topposition+_pnlheight+_padding);
RDebugUtils.currentLine=852238;
 //BA.debugLineNum = 852238;BA.debugLine="scrollHeight = scrollHeight + 290dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (290)));
 };
 }
};
RDebugUtils.currentLine=852243;
 //BA.debugLineNum = 852243;BA.debugLine="ScrollView1.Panel.Height = scrollHeight";
mostCurrent._scrollview1.getPanel().setHeight(_scrollheight);
 break; }
case 1: {
RDebugUtils.currentLine=852247;
 //BA.debugLineNum = 852247;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=852249;
 //BA.debugLineNum = 852249;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=852251;
 //BA.debugLineNum = 852251;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("8852251","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e241) {
			processBA.setLastException(e241);RDebugUtils.currentLine=852255;
 //BA.debugLineNum = 852255;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=852258;
 //BA.debugLineNum = 852258;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=852261;
 //BA.debugLineNum = 852261;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=852262;
 //BA.debugLineNum = 852262;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="branch_selected = selectedCompany";
_branch_selected = _selectedcompany;
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="StartActivity(\"Device\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Device"));
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="End Sub";
return "";
}
public static String  _totaltarget_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltarget_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltarget_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub totalTarget_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim target_id_btn As Label = Sender ' Get the cli";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="target_id_display.Text = target_id";
mostCurrent._target_id_display.setText(BA.ObjectToCharSequence(_target_id));
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="End Sub";
return "";
}
public static String  _totaltargettitle_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltargettitle_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltargettitle_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub totalTargetTitle_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Dim target_id_btn As Label = Sender ' Get the cli";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="Log(target_id&\"This is clicked id\")";
anywheresoftware.b4a.keywords.Common.LogImpl("81114117",_target_id+"This is clicked id",0);
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="End Sub";
return "";
}
}