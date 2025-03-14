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
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public static String _phpurl = "";
public static String _phpurl1 = "";
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
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
public b4a.example.bargraph _bargraph = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nxtbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _backbtn = null;
public anywheresoftware.b4a.objects.PanelWrapper _purchasepanel = null;
public static int _currentpage = 0;
public static int _totalsales = 0;
public static boolean _bargraphinitialized = false;
public anywheresoftware.b4a.objects.PanelWrapper _panel4 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollviewpanel4 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sortbtn1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _defbtn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sortbtn2 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _salesbtn1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _salesbtn2 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _salesbtn3 = null;
public static int _salesdata1 = 0;
public static int _salesdatadefault = 0;
public static String _sortdefaultvalue = "";
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
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Activity.LoadLayout(\"Branch\")";
mostCurrent._activity.LoadLayout("Branch",mostCurrent.activityBA);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="home.TextSize = 16";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="Panel3.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="Panel3.Color = Colors.Transparent";
mostCurrent._panel3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=1114123;
 //BA.debugLineNum = 1114123;BA.debugLine="branches.Initialize(\"\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1114126;
 //BA.debugLineNum = 1114126;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1114127;
 //BA.debugLineNum = 1114127;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=1114128;
 //BA.debugLineNum = 1114128;BA.debugLine="Panel3.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=1114130;
 //BA.debugLineNum = 1114130;BA.debugLine="popupPanel.Initialize(\"\")";
mostCurrent._popuppanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1114131;
 //BA.debugLineNum = 1114131;BA.debugLine="popupPanel.Color = Colors.ARGB(200, 0, 0, 0)";
mostCurrent._popuppanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (200),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=1114132;
 //BA.debugLineNum = 1114132;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114133;
 //BA.debugLineNum = 1114133;BA.debugLine="Activity.AddView(popupPanel, 0, 0, Activity.Width";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._popuppanel.getObject()),(int) (0),(int) (0),mostCurrent._activity.getWidth(),mostCurrent._activity.getHeight());
RDebugUtils.currentLine=1114135;
 //BA.debugLineNum = 1114135;BA.debugLine="Dim popupPanelBackground As Panel";
_popuppanelbackground = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1114136;
 //BA.debugLineNum = 1114136;BA.debugLine="popupPanelBackground.Initialize(\"\")";
_popuppanelbackground.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1114137;
 //BA.debugLineNum = 1114137;BA.debugLine="popupPanelBackground.Color = Colors.White";
_popuppanelbackground.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1114138;
 //BA.debugLineNum = 1114138;BA.debugLine="popupPanel.AddView(popupPanelBackground, 70dip, 5";
mostCurrent._popuppanel.AddView((android.view.View)(_popuppanelbackground.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (550)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500))));
RDebugUtils.currentLine=1114139;
 //BA.debugLineNum = 1114139;BA.debugLine="Dim leftPosition As Int = (popupPanel.Width - pop";
_leftposition = (int) ((mostCurrent._popuppanel.getWidth()-_popuppanelbackground.getWidth())/(double)2);
RDebugUtils.currentLine=1114140;
 //BA.debugLineNum = 1114140;BA.debugLine="popupPanelBackground.Left = leftPosition";
_popuppanelbackground.setLeft(_leftposition);
RDebugUtils.currentLine=1114142;
 //BA.debugLineNum = 1114142;BA.debugLine="Dim closeButton As Label";
_closebutton = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1114143;
 //BA.debugLineNum = 1114143;BA.debugLine="closeButton.Initialize(\"closeButton\")";
_closebutton.Initialize(mostCurrent.activityBA,"closeButton");
RDebugUtils.currentLine=1114144;
 //BA.debugLineNum = 1114144;BA.debugLine="closeButton.Text = \"X\"";
_closebutton.setText(BA.ObjectToCharSequence("X"));
RDebugUtils.currentLine=1114145;
 //BA.debugLineNum = 1114145;BA.debugLine="closeButton.TextSize = 20";
_closebutton.setTextSize((float) (20));
RDebugUtils.currentLine=1114146;
 //BA.debugLineNum = 1114146;BA.debugLine="closeButton.TextColor = Colors.Red";
_closebutton.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1114147;
 //BA.debugLineNum = 1114147;BA.debugLine="closeButton.Typeface = Typeface.DEFAULT_BOLD";
_closebutton.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1114148;
 //BA.debugLineNum = 1114148;BA.debugLine="popupPanelBackground.AddView(closeButton, popupPa";
_popuppanelbackground.AddView((android.view.View)(_closebutton.getObject()),(int) (_popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=1114150;
 //BA.debugLineNum = 1114150;BA.debugLine="target_id_display.Initialize(\"target_id_display\")";
mostCurrent._target_id_display.Initialize(mostCurrent.activityBA,"target_id_display");
RDebugUtils.currentLine=1114151;
 //BA.debugLineNum = 1114151;BA.debugLine="target_id_display.TextSize = 20";
mostCurrent._target_id_display.setTextSize((float) (20));
RDebugUtils.currentLine=1114152;
 //BA.debugLineNum = 1114152;BA.debugLine="target_id_display.TextColor = Colors.Red";
mostCurrent._target_id_display.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1114153;
 //BA.debugLineNum = 1114153;BA.debugLine="target_id_display.Typeface = Typeface.DEFAULT_BOL";
mostCurrent._target_id_display.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1114154;
 //BA.debugLineNum = 1114154;BA.debugLine="popupPanelBackground.AddView(target_id_display, p";
_popuppanelbackground.AddView((android.view.View)(mostCurrent._target_id_display.getObject()),(int) (_popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=1114156;
 //BA.debugLineNum = 1114156;BA.debugLine="Dim popupText As Label";
_popuptext = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1114157;
 //BA.debugLineNum = 1114157;BA.debugLine="popupText.Initialize(\"\")";
_popuptext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1114158;
 //BA.debugLineNum = 1114158;BA.debugLine="popupText.Text = \"Edit Target\"";
_popuptext.setText(BA.ObjectToCharSequence("Edit Target"));
RDebugUtils.currentLine=1114159;
 //BA.debugLineNum = 1114159;BA.debugLine="popupText.TextColor = Colors.Black";
_popuptext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1114160;
 //BA.debugLineNum = 1114160;BA.debugLine="popupText.TextSize = 58";
_popuptext.setTextSize((float) (58));
RDebugUtils.currentLine=1114161;
 //BA.debugLineNum = 1114161;BA.debugLine="popupText.Gravity = Gravity.CENTER";
_popuptext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1114162;
 //BA.debugLineNum = 1114162;BA.debugLine="popupPanelBackground.AddView(popupText, 25dip, 10";
_popuppanelbackground.AddView((android.view.View)(_popuptext.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=1114164;
 //BA.debugLineNum = 1114164;BA.debugLine="target_countLabel.Initialize(\"\")";
mostCurrent._target_countlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1114165;
 //BA.debugLineNum = 1114165;BA.debugLine="target_countLabel.TextColor = Colors.Black";
mostCurrent._target_countlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1114166;
 //BA.debugLineNum = 1114166;BA.debugLine="target_countLabel.TextSize = 58";
mostCurrent._target_countlabel.setTextSize((float) (58));
RDebugUtils.currentLine=1114167;
 //BA.debugLineNum = 1114167;BA.debugLine="target_countLabel.Gravity = Gravity.CENTER";
mostCurrent._target_countlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1114168;
 //BA.debugLineNum = 1114168;BA.debugLine="popupPanelBackground.AddView(target_countLabel, 2";
_popuppanelbackground.AddView((android.view.View)(mostCurrent._target_countlabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=1114169;
 //BA.debugLineNum = 1114169;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
RDebugUtils.currentLine=1114171;
 //BA.debugLineNum = 1114171;BA.debugLine="Dim edit_button As Button";
_edit_button = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1114172;
 //BA.debugLineNum = 1114172;BA.debugLine="edit_button.Initialize(\"edit_button\")";
_edit_button.Initialize(mostCurrent.activityBA,"edit_button");
RDebugUtils.currentLine=1114173;
 //BA.debugLineNum = 1114173;BA.debugLine="edit_button.Text = \"Update\"";
_edit_button.setText(BA.ObjectToCharSequence("Update"));
RDebugUtils.currentLine=1114174;
 //BA.debugLineNum = 1114174;BA.debugLine="edit_button.TextColor = Colors.Black";
_edit_button.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1114175;
 //BA.debugLineNum = 1114175;BA.debugLine="edit_button.TextSize = 58";
_edit_button.setTextSize((float) (58));
RDebugUtils.currentLine=1114176;
 //BA.debugLineNum = 1114176;BA.debugLine="edit_button.Gravity = Gravity.CENTER";
_edit_button.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1114177;
 //BA.debugLineNum = 1114177;BA.debugLine="popupPanelBackground.AddView(edit_button, 25dip,";
_popuppanelbackground.AddView((android.view.View)(_edit_button.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=1114179;
 //BA.debugLineNum = 1114179;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1114180;
 //BA.debugLineNum = 1114180;BA.debugLine="Panel4.AddView(purchasePanel, 0, 0dip, Activity.W";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (470)));
RDebugUtils.currentLine=1114182;
 //BA.debugLineNum = 1114182;BA.debugLine="scrollViewPanel4.Initialize(Panel4.Height - purch";
mostCurrent._scrollviewpanel4.Initialize(mostCurrent.activityBA,(int) (mostCurrent._panel4.getHeight()-mostCurrent._purchasepanel.getHeight()));
RDebugUtils.currentLine=1114183;
 //BA.debugLineNum = 1114183;BA.debugLine="Panel4.AddView(scrollViewPanel4,0,purchasePanel.H";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._scrollviewpanel4.getObject()),(int) (0),mostCurrent._purchasepanel.getHeight(),mostCurrent._panel4.getWidth(),(int) (mostCurrent._panel4.getHeight()-mostCurrent._purchasepanel.getHeight()));
RDebugUtils.currentLine=1114185;
 //BA.debugLineNum = 1114185;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=1114186;
 //BA.debugLineNum = 1114186;BA.debugLine="LoadCompanyDataBranch";
_loadcompanydatabranch();
RDebugUtils.currentLine=1114187;
 //BA.debugLineNum = 1114187;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="totalTarget.Initialize(\"\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Panel.Initialize(\"\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Panel.RemoveAllViews";
mostCurrent._panel.RemoveAllViews();
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="PHPURL = \"https://192.168.8.117/Company/controlle";
mostCurrent._phpurl = "https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="+mostCurrent._starter._company_selected /*String*/ ;
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",branch.getObject());
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydatabranch() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydatabranch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydatabranch", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub LoadCompanyDataBranch";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Try";
try {RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="Job1.Initialize(\"GetBranches\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetBranches",branch.getObject());
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="PHPURL1 = $\"https://192.168.8.117/Company/contro";
mostCurrent._phpurl1 = ("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"&sales="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_salesdata1))+"&sales_type="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+"");
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="Job1.Download(PHPURL1)";
_job1._download /*String*/ (null,mostCurrent._phpurl1);
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("01179656",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="branch";
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub backbtn_Click";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="currentPage = currentPage - 1";
_currentpage = (int) (_currentpage-1);
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="FetchNewPageData";
_fetchnewpagedata();
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="End Sub";
return "";
}
public static String  _fetchnewpagedata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fetchnewpagedata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fetchnewpagedata", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub FetchNewPageData";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="LoadCompanyDataBranch ' Fetch new data for the cu";
_loadcompanydatabranch();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return "";
}
public static String  _closebutton_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closebutton_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closebutton_click", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub closeButton_Click";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="End Sub";
return "";
}
public static String  _defbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "defbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "defbtn_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub defBtn_Click";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="sortDefaultValue = \"\"";
mostCurrent._sortdefaultvalue = "";
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("02228229",_index,0);
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="Log(\"(default)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("02228230","(default)",0);
RDebugUtils.currentLine=2228235;
 //BA.debugLineNum = 2228235;BA.debugLine="End Sub";
return "";
}
public static String  _edit_button_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edit_button_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edit_button_click", null));}
int _target_id = 0;
int _new_value = 0;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub edit_button_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim target_id As Int = target_id_display.Text";
_target_id = (int)(Double.parseDouble(mostCurrent._target_id_display.getText()));
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Dim new_value As Int = target_countLabel.Text";
_new_value = (int)(Double.parseDouble(mostCurrent._target_countlabel.getText()));
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_target_id)) && anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_new_value))) { 
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="UpdateData_Remote(target_id, new_value)";
_updatedata_remote(_target_id,_new_value);
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 }else {
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="Log(\"Invalid input values\")";
anywheresoftware.b4a.keywords.Common.LogImpl("01507336","Invalid input values",0);
 };
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="End Sub";
return "";
}
public static String  _updatedata_remote(int _target_id,int _new_value) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatedata_remote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updatedata_remote", new Object[] {_target_id,_new_value}));}
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.141/Co";
mostCurrent._phpurl = ("https://192.168.8.141/Company/controller/company.php?action=target_update&id="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_target_id))+"&value="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_new_value))+"");
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
_job._initialize /*String*/ (null,processBA,"UpdateData",branch.getObject());
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="job.Download(PHPURL)";
_job._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.collections.List _salesarray = null;
int _idcom = 0;
int _i = 0;
String _currentcomid = "";
anywheresoftware.b4a.objects.collections.List _branches1 = null;
int _totalbranches = 0;
String[] _branchnames = null;
int[] _branchsales1 = null;
int[] _branchsales2 = null;
int[] _branchsales3 = null;
int _j = 0;
anywheresoftware.b4a.objects.collections.Map _branchmap = null;
String[] _legend = null;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="Try";
try {RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","UpdateData","GetBranches")) {
case 0: {
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
_numcolumns = (int) (2);
RDebugUtils.currentLine=1376270;
 //BA.debugLineNum = 1376270;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
_pnlwidth = (int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="Dim pnlHeight As Int = 280dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280));
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1376273;
 //BA.debugLineNum = 1376273;BA.debugLine="Dim leftPosition As Int = 50dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=1376274;
 //BA.debugLineNum = 1376274;BA.debugLine="Dim topPosition As Int = 0";
_topposition = (int) (0);
RDebugUtils.currentLine=1376275;
 //BA.debugLineNum = 1376275;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=1376277;
 //BA.debugLineNum = 1376277;BA.debugLine="pnlWidth = 490dip";
_pnlwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (490));
RDebugUtils.currentLine=1376278;
 //BA.debugLineNum = 1376278;BA.debugLine="pnlHeight = 300dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300));
RDebugUtils.currentLine=1376279;
 //BA.debugLineNum = 1376279;BA.debugLine="padding = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1376280;
 //BA.debugLineNum = 1376280;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 };
RDebugUtils.currentLine=1376282;
 //BA.debugLineNum = 1376282;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group23 = mostCurrent._tabledetails;
final int groupLen23 = group23.getSize()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group23.Get(index23)));
RDebugUtils.currentLine=1376283;
 //BA.debugLineNum = 1376283;BA.debugLine="Dim companyName As String = record.Get(\"comp";
_companyname = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=1376284;
 //BA.debugLineNum = 1376284;BA.debugLine="Dim id As String = record.Get(\"id\")";
_id = BA.ObjectToString(_record.Get((Object)("id")));
RDebugUtils.currentLine=1376285;
 //BA.debugLineNum = 1376285;BA.debugLine="Dim name As String = record.Get(\"branch_name";
_name = BA.ObjectToString(_record.Get((Object)("branch_name")));
RDebugUtils.currentLine=1376286;
 //BA.debugLineNum = 1376286;BA.debugLine="Dim total_count As Int = record.Get(\"target_";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("target_no"))));
RDebugUtils.currentLine=1376287;
 //BA.debugLineNum = 1376287;BA.debugLine="Dim total_pos As Int = record.Get(\"total_dev";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("total_device"))));
RDebugUtils.currentLine=1376288;
 //BA.debugLineNum = 1376288;BA.debugLine="Dim totalPur1 As String = record.Get(\"purcha";
_totalpur1 = BA.ObjectToString(_record.Get((Object)("purchase_1")));
RDebugUtils.currentLine=1376289;
 //BA.debugLineNum = 1376289;BA.debugLine="Dim totalPur2 As String = record.Get(\"purcha";
_totalpur2 = BA.ObjectToString(_record.Get((Object)("purchase_2")));
RDebugUtils.currentLine=1376290;
 //BA.debugLineNum = 1376290;BA.debugLine="Dim totalPur3 As String = record.Get(\"purcha";
_totalpur3 = BA.ObjectToString(_record.Get((Object)("purchase_3")));
RDebugUtils.currentLine=1376291;
 //BA.debugLineNum = 1376291;BA.debugLine="Dim totalSales1 As String = record.Get(\"tota";
_totalsales1 = BA.ObjectToString(_record.Get((Object)("total_sales1")));
RDebugUtils.currentLine=1376292;
 //BA.debugLineNum = 1376292;BA.debugLine="Dim totalSales2 As String = record.Get(\"tota";
_totalsales2 = BA.ObjectToString(_record.Get((Object)("total_sales2")));
RDebugUtils.currentLine=1376293;
 //BA.debugLineNum = 1376293;BA.debugLine="Dim totalSales3 As String = record.Get(\"tota";
_totalsales3 = BA.ObjectToString(_record.Get((Object)("total_sales3")));
RDebugUtils.currentLine=1376294;
 //BA.debugLineNum = 1376294;BA.debugLine="Dim target_id As String = record.Get(\"branch";
_target_id = BA.ObjectToString(_record.Get((Object)("branch_target_id")));
RDebugUtils.currentLine=1376295;
 //BA.debugLineNum = 1376295;BA.debugLine="totalSales = totalSales1.Length";
_totalsales = _totalsales1.length();
RDebugUtils.currentLine=1376296;
 //BA.debugLineNum = 1376296;BA.debugLine="target_countLabel.Text = total_count";
mostCurrent._target_countlabel.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=1376297;
 //BA.debugLineNum = 1376297;BA.debugLine="branches.Text = \"Branches - \" & companyName";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_companyname));
RDebugUtils.currentLine=1376298;
 //BA.debugLineNum = 1376298;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=1376300;
 //BA.debugLineNum = 1376300;BA.debugLine="LabelTitle.Text = companyName";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_companyname));
RDebugUtils.currentLine=1376301;
 //BA.debugLineNum = 1376301;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCas";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=1376302;
 //BA.debugLineNum = 1376302;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
mostCurrent._labeltitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376304;
 //BA.debugLineNum = 1376304;BA.debugLine="Panel.Initialize(\"Panel\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=1376305;
 //BA.debugLineNum = 1376305;BA.debugLine="scrollViewPanel4.Panel.AddView(Panel, leftPo";
mostCurrent._scrollviewpanel4.getPanel().AddView((android.view.View)(mostCurrent._panel.getObject()),_leftposition,_topposition,_pnlwidth,_pnlheight);
RDebugUtils.currentLine=1376306;
 //BA.debugLineNum = 1376306;BA.debugLine="Panel.Color = Colors.Black";
mostCurrent._panel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376308;
 //BA.debugLineNum = 1376308;BA.debugLine="Dim Panel2 As Panel";
_panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1376309;
 //BA.debugLineNum = 1376309;BA.debugLine="Panel2.Initialize(\"Panel2\")";
_panel2.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=1376310;
 //BA.debugLineNum = 1376310;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=1376311;
 //BA.debugLineNum = 1376311;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As I";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=1376312;
 //BA.debugLineNum = 1376312;BA.debugLine="Panel2.Background = gradient";
_panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=1376313;
 //BA.debugLineNum = 1376313;BA.debugLine="Panel2.Tag = name";
_panel2.setTag((Object)(_name));
RDebugUtils.currentLine=1376314;
 //BA.debugLineNum = 1376314;BA.debugLine="Panel2.SendToBack";
_panel2.SendToBack();
RDebugUtils.currentLine=1376315;
 //BA.debugLineNum = 1376315;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y";
mostCurrent._panel.AddView((android.view.View)(_panel2.getObject()),(int) (0),(int) (0),mostCurrent._panel.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=1376317;
 //BA.debugLineNum = 1376317;BA.debugLine="Dim BranchNameLabel As Label";
_branchnamelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376318;
 //BA.debugLineNum = 1376318;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
_branchnamelabel.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=1376319;
 //BA.debugLineNum = 1376319;BA.debugLine="BranchNameLabel.Text = name";
_branchnamelabel.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=1376320;
 //BA.debugLineNum = 1376320;BA.debugLine="BranchNameLabel.Tag = id";
_branchnamelabel.setTag((Object)(_id));
RDebugUtils.currentLine=1376321;
 //BA.debugLineNum = 1376321;BA.debugLine="BranchNameLabel.TextSize = 18";
_branchnamelabel.setTextSize((float) (18));
RDebugUtils.currentLine=1376322;
 //BA.debugLineNum = 1376322;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
_branchnamelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1376323;
 //BA.debugLineNum = 1376323;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPAC";
_branchnamelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376324;
 //BA.debugLineNum = 1376324;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VER";
_branchnamelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1376325;
 //BA.debugLineNum = 1376325;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip,";
_panel2.AddView((android.view.View)(_branchnamelabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panel2.getWidth(),_panel2.getHeight());
RDebugUtils.currentLine=1376327;
 //BA.debugLineNum = 1376327;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1376328;
 //BA.debugLineNum = 1376328;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=1376329;
 //BA.debugLineNum = 1376329;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=1376330;
 //BA.debugLineNum = 1376330;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376331;
 //BA.debugLineNum = 1376331;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1376332;
 //BA.debugLineNum = 1376332;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376333;
 //BA.debugLineNum = 1376333;BA.debugLine="imgView.Bitmap = resizedImage";
_imgview.setBitmap((android.graphics.Bitmap)(_resizedimage.getObject()));
RDebugUtils.currentLine=1376334;
 //BA.debugLineNum = 1376334;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x,";
_panel2.AddView((android.view.View)(_imgview.getObject()),(int) (_panel2.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),_panel2.getHeight());
 }else {
RDebugUtils.currentLine=1376336;
 //BA.debugLineNum = 1376336;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("01376336","Error loading image",0);
 };
RDebugUtils.currentLine=1376339;
 //BA.debugLineNum = 1376339;BA.debugLine="Dim panelWidth As Int = Panel.Width / 3";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)3);
RDebugUtils.currentLine=1376340;
 //BA.debugLineNum = 1376340;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1376341;
 //BA.debugLineNum = 1376341;BA.debugLine="Dim labelheight As Int = 35dip";
_labelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35));
RDebugUtils.currentLine=1376343;
 //BA.debugLineNum = 1376343;BA.debugLine="Dim purchase1 As Label";
_purchase1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376344;
 //BA.debugLineNum = 1376344;BA.debugLine="purchase1.Initialize(\"\")";
_purchase1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376345;
 //BA.debugLineNum = 1376345;BA.debugLine="purchase1.Text = totalPur1";
_purchase1.setText(BA.ObjectToCharSequence(_totalpur1));
RDebugUtils.currentLine=1376346;
 //BA.debugLineNum = 1376346;BA.debugLine="purchase1.TextColor = Colors.Black";
_purchase1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376347;
 //BA.debugLineNum = 1376347;BA.debugLine="purchase1.TextSize = primaryFontSize";
_purchase1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=1376348;
 //BA.debugLineNum = 1376348;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
_purchase1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376349;
 //BA.debugLineNum = 1376349;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
_purchase1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1376350;
 //BA.debugLineNum = 1376350;BA.debugLine="Panel.AddView(purchase1, 0, Panel2.Height +";
mostCurrent._panel.AddView((android.view.View)(_purchase1.getObject()),(int) (0),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376352;
 //BA.debugLineNum = 1376352;BA.debugLine="Dim purchase1Title As Label";
_purchase1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376353;
 //BA.debugLineNum = 1376353;BA.debugLine="purchase1Title.Initialize(\"\")";
_purchase1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376354;
 //BA.debugLineNum = 1376354;BA.debugLine="purchase1Title.Text = \"First Purchase\"";
_purchase1title.setText(BA.ObjectToCharSequence("First Purchase"));
RDebugUtils.currentLine=1376355;
 //BA.debugLineNum = 1376355;BA.debugLine="purchase1Title.TextColor = Colors.Gray";
_purchase1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376356;
 //BA.debugLineNum = 1376356;BA.debugLine="purchase1Title.TextSize = secondaryFontSize";
_purchase1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=1376357;
 //BA.debugLineNum = 1376357;BA.debugLine="purchase1Title.Gravity = Gravity.CENTER";
_purchase1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376358;
 //BA.debugLineNum = 1376358;BA.debugLine="purchase1Title.Typeface = Typeface.MONOSPACE";
_purchase1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376359;
 //BA.debugLineNum = 1376359;BA.debugLine="purchase1Title.Text = purchase1Title.Text.To";
_purchase1title.setText(BA.ObjectToCharSequence(_purchase1title.getText().toUpperCase()));
RDebugUtils.currentLine=1376360;
 //BA.debugLineNum = 1376360;BA.debugLine="Panel.AddView(purchase1Title, 0, purchase1.t";
mostCurrent._panel.AddView((android.view.View)(_purchase1title.getObject()),(int) (0),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376362;
 //BA.debugLineNum = 1376362;BA.debugLine="Dim purchase2 As Label";
_purchase2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376363;
 //BA.debugLineNum = 1376363;BA.debugLine="purchase2.Initialize(\"\")";
_purchase2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376364;
 //BA.debugLineNum = 1376364;BA.debugLine="purchase2.Text = totalPur2";
_purchase2.setText(BA.ObjectToCharSequence(_totalpur2));
RDebugUtils.currentLine=1376365;
 //BA.debugLineNum = 1376365;BA.debugLine="purchase2.TextColor = Colors.Black";
_purchase2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376366;
 //BA.debugLineNum = 1376366;BA.debugLine="purchase2.TextSize = primaryFontSize";
_purchase2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=1376367;
 //BA.debugLineNum = 1376367;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
_purchase2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376368;
 //BA.debugLineNum = 1376368;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
_purchase2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1376369;
 //BA.debugLineNum = 1376369;BA.debugLine="Panel.AddView(purchase2, panelWidth, Panel2.";
mostCurrent._panel.AddView((android.view.View)(_purchase2.getObject()),_panelwidth,(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376371;
 //BA.debugLineNum = 1376371;BA.debugLine="Dim purchase2Title As Label";
_purchase2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376372;
 //BA.debugLineNum = 1376372;BA.debugLine="purchase2Title.Initialize(\"\")";
_purchase2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376373;
 //BA.debugLineNum = 1376373;BA.debugLine="purchase2Title.Text = \"Second Purchase\"";
_purchase2title.setText(BA.ObjectToCharSequence("Second Purchase"));
RDebugUtils.currentLine=1376374;
 //BA.debugLineNum = 1376374;BA.debugLine="purchase2Title.TextColor = Colors.Gray";
_purchase2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376375;
 //BA.debugLineNum = 1376375;BA.debugLine="purchase2Title.TextSize = secondaryFontSize";
_purchase2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=1376376;
 //BA.debugLineNum = 1376376;BA.debugLine="purchase2Title.Gravity = Gravity.CENTER";
_purchase2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376377;
 //BA.debugLineNum = 1376377;BA.debugLine="purchase2Title.Typeface = Typeface.MONOSPACE";
_purchase2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376378;
 //BA.debugLineNum = 1376378;BA.debugLine="purchase2Title.Text = purchase2Title.Text.To";
_purchase2title.setText(BA.ObjectToCharSequence(_purchase2title.getText().toUpperCase()));
RDebugUtils.currentLine=1376379;
 //BA.debugLineNum = 1376379;BA.debugLine="Panel.AddView(purchase2Title, panelWidth, pu";
mostCurrent._panel.AddView((android.view.View)(_purchase2title.getObject()),_panelwidth,(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376381;
 //BA.debugLineNum = 1376381;BA.debugLine="Dim purchase3 As Label";
_purchase3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376382;
 //BA.debugLineNum = 1376382;BA.debugLine="purchase3.Initialize(\"\")";
_purchase3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376383;
 //BA.debugLineNum = 1376383;BA.debugLine="purchase3.Text = totalPur3";
_purchase3.setText(BA.ObjectToCharSequence(_totalpur3));
RDebugUtils.currentLine=1376384;
 //BA.debugLineNum = 1376384;BA.debugLine="purchase3.TextColor = Colors.Black";
_purchase3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376385;
 //BA.debugLineNum = 1376385;BA.debugLine="purchase3.TextSize = primaryFontSize";
_purchase3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=1376386;
 //BA.debugLineNum = 1376386;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
_purchase3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376387;
 //BA.debugLineNum = 1376387;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
_purchase3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1376388;
 //BA.debugLineNum = 1376388;BA.debugLine="Panel.AddView(purchase3, panelWidth * 2, Pan";
mostCurrent._panel.AddView((android.view.View)(_purchase3.getObject()),(int) (_panelwidth*2),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376390;
 //BA.debugLineNum = 1376390;BA.debugLine="Dim purchase3Title As Label";
_purchase3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376391;
 //BA.debugLineNum = 1376391;BA.debugLine="purchase3Title.Initialize(\"\")";
_purchase3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376392;
 //BA.debugLineNum = 1376392;BA.debugLine="purchase3Title.Text = \"Third Purchase\"";
_purchase3title.setText(BA.ObjectToCharSequence("Third Purchase"));
RDebugUtils.currentLine=1376393;
 //BA.debugLineNum = 1376393;BA.debugLine="purchase3Title.TextColor = Colors.Gray";
_purchase3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376394;
 //BA.debugLineNum = 1376394;BA.debugLine="purchase3Title.TextSize = secondaryFontSize";
_purchase3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=1376395;
 //BA.debugLineNum = 1376395;BA.debugLine="purchase3Title.Gravity = Gravity.CENTER";
_purchase3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376396;
 //BA.debugLineNum = 1376396;BA.debugLine="purchase3Title.Typeface = Typeface.MONOSPACE";
_purchase3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376397;
 //BA.debugLineNum = 1376397;BA.debugLine="purchase3Title.Text = purchase3Title.Text.To";
_purchase3title.setText(BA.ObjectToCharSequence(_purchase3title.getText().toUpperCase()));
RDebugUtils.currentLine=1376398;
 //BA.debugLineNum = 1376398;BA.debugLine="Panel.AddView(purchase3Title, panelWidth * 2";
mostCurrent._panel.AddView((android.view.View)(_purchase3title.getObject()),(int) (_panelwidth*2),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376400;
 //BA.debugLineNum = 1376400;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376401;
 //BA.debugLineNum = 1376401;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376402;
 //BA.debugLineNum = 1376402;BA.debugLine="sale1.Text = totalSales1";
_sale1.setText(BA.ObjectToCharSequence(_totalsales1));
RDebugUtils.currentLine=1376403;
 //BA.debugLineNum = 1376403;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376404;
 //BA.debugLineNum = 1376404;BA.debugLine="sale1.TextSize = primaryFontSize";
_sale1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=1376405;
 //BA.debugLineNum = 1376405;BA.debugLine="sale1.Gravity = Gravity.CENTER";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376406;
 //BA.debugLineNum = 1376406;BA.debugLine="sale1.Typeface = Typeface.SERIF";
_sale1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1376407;
 //BA.debugLineNum = 1376407;BA.debugLine="Panel.AddView(sale1, 0, purchase3Title.Heigh";
mostCurrent._panel.AddView((android.view.View)(_sale1.getObject()),(int) (0),(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376409;
 //BA.debugLineNum = 1376409;BA.debugLine="Dim sale1Title As Label";
_sale1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376410;
 //BA.debugLineNum = 1376410;BA.debugLine="sale1Title.Initialize(\"\")";
_sale1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376411;
 //BA.debugLineNum = 1376411;BA.debugLine="sale1Title.Text = \"First Sale\"";
_sale1title.setText(BA.ObjectToCharSequence("First Sale"));
RDebugUtils.currentLine=1376412;
 //BA.debugLineNum = 1376412;BA.debugLine="sale1Title.TextColor = Colors.Gray";
_sale1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376413;
 //BA.debugLineNum = 1376413;BA.debugLine="sale1Title.TextSize = secondaryFontSize";
_sale1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=1376414;
 //BA.debugLineNum = 1376414;BA.debugLine="sale1Title.Gravity = Gravity.CENTER";
_sale1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376415;
 //BA.debugLineNum = 1376415;BA.debugLine="sale1Title.Typeface = Typeface.MONOSPACE";
_sale1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376416;
 //BA.debugLineNum = 1376416;BA.debugLine="sale1Title.Text = sale1Title.Text.ToUpperCas";
_sale1title.setText(BA.ObjectToCharSequence(_sale1title.getText().toUpperCase()));
RDebugUtils.currentLine=1376417;
 //BA.debugLineNum = 1376417;BA.debugLine="Panel.AddView(sale1Title, 0, sale1.top + pad";
mostCurrent._panel.AddView((android.view.View)(_sale1title.getObject()),(int) (0),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376419;
 //BA.debugLineNum = 1376419;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376420;
 //BA.debugLineNum = 1376420;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376421;
 //BA.debugLineNum = 1376421;BA.debugLine="sale2.Text = totalSales2";
_sale2.setText(BA.ObjectToCharSequence(_totalsales2));
RDebugUtils.currentLine=1376422;
 //BA.debugLineNum = 1376422;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376423;
 //BA.debugLineNum = 1376423;BA.debugLine="sale2.TextSize = primaryFontSize";
_sale2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=1376424;
 //BA.debugLineNum = 1376424;BA.debugLine="sale2.Gravity = Gravity.CENTER";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376425;
 //BA.debugLineNum = 1376425;BA.debugLine="sale2.Typeface = Typeface.SERIF";
_sale2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1376426;
 //BA.debugLineNum = 1376426;BA.debugLine="Panel.AddView(sale2, panelWidth, purchase3Ti";
mostCurrent._panel.AddView((android.view.View)(_sale2.getObject()),_panelwidth,(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376428;
 //BA.debugLineNum = 1376428;BA.debugLine="Dim sale2Title As Label";
_sale2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376429;
 //BA.debugLineNum = 1376429;BA.debugLine="sale2Title.Initialize(\"\")";
_sale2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376430;
 //BA.debugLineNum = 1376430;BA.debugLine="sale2Title.Text = \" Second Sale\"";
_sale2title.setText(BA.ObjectToCharSequence(" Second Sale"));
RDebugUtils.currentLine=1376431;
 //BA.debugLineNum = 1376431;BA.debugLine="sale2Title.TextColor = Colors.Gray";
_sale2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376432;
 //BA.debugLineNum = 1376432;BA.debugLine="sale2Title.TextSize = secondaryFontSize";
_sale2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=1376433;
 //BA.debugLineNum = 1376433;BA.debugLine="sale2Title.Gravity = Gravity.CENTER";
_sale2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376434;
 //BA.debugLineNum = 1376434;BA.debugLine="sale2Title.Typeface = Typeface.MONOSPACE";
_sale2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376435;
 //BA.debugLineNum = 1376435;BA.debugLine="sale2Title.Text = sale2Title.Text.ToUpperCas";
_sale2title.setText(BA.ObjectToCharSequence(_sale2title.getText().toUpperCase()));
RDebugUtils.currentLine=1376436;
 //BA.debugLineNum = 1376436;BA.debugLine="Panel.AddView(sale2Title, panelWidth, sale2.";
mostCurrent._panel.AddView((android.view.View)(_sale2title.getObject()),_panelwidth,(int) (_sale2.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376438;
 //BA.debugLineNum = 1376438;BA.debugLine="Dim sale3 As Label";
_sale3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376439;
 //BA.debugLineNum = 1376439;BA.debugLine="sale3.Initialize(\"\")";
_sale3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376440;
 //BA.debugLineNum = 1376440;BA.debugLine="sale3.Text = totalSales3";
_sale3.setText(BA.ObjectToCharSequence(_totalsales3));
RDebugUtils.currentLine=1376441;
 //BA.debugLineNum = 1376441;BA.debugLine="sale3.TextColor = Colors.Black";
_sale3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376442;
 //BA.debugLineNum = 1376442;BA.debugLine="sale3.TextSize = primaryFontSize";
_sale3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=1376443;
 //BA.debugLineNum = 1376443;BA.debugLine="sale3.Gravity = Gravity.CENTER";
_sale3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376444;
 //BA.debugLineNum = 1376444;BA.debugLine="sale3.Typeface = Typeface.SERIF";
_sale3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1376445;
 //BA.debugLineNum = 1376445;BA.debugLine="Panel.AddView(sale3, panelWidth * 2, sale2Ti";
mostCurrent._panel.AddView((android.view.View)(_sale3.getObject()),(int) (_panelwidth*2),(int) (_sale2title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376447;
 //BA.debugLineNum = 1376447;BA.debugLine="Dim sale3Title As Label";
_sale3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376448;
 //BA.debugLineNum = 1376448;BA.debugLine="sale3Title.Initialize(\"\")";
_sale3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376449;
 //BA.debugLineNum = 1376449;BA.debugLine="sale3Title.Text = \" Third Sale\"";
_sale3title.setText(BA.ObjectToCharSequence(" Third Sale"));
RDebugUtils.currentLine=1376450;
 //BA.debugLineNum = 1376450;BA.debugLine="sale3Title.TextColor = Colors.Gray";
_sale3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376451;
 //BA.debugLineNum = 1376451;BA.debugLine="sale3Title.TextSize = secondaryFontSize";
_sale3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=1376452;
 //BA.debugLineNum = 1376452;BA.debugLine="sale3Title.Gravity = Gravity.CENTER";
_sale3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376453;
 //BA.debugLineNum = 1376453;BA.debugLine="sale3Title.Typeface = Typeface.MONOSPACE";
_sale3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376454;
 //BA.debugLineNum = 1376454;BA.debugLine="sale3Title.Text = sale3Title.Text.ToUpperCas";
_sale3title.setText(BA.ObjectToCharSequence(_sale3title.getText().toUpperCase()));
RDebugUtils.currentLine=1376455;
 //BA.debugLineNum = 1376455;BA.debugLine="Panel.AddView(sale3Title, panelWidth * 2, sa";
mostCurrent._panel.AddView((android.view.View)(_sale3title.getObject()),(int) (_panelwidth*2),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376457;
 //BA.debugLineNum = 1376457;BA.debugLine="panelWidth = Panel.Width / 2";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)2);
RDebugUtils.currentLine=1376459;
 //BA.debugLineNum = 1376459;BA.debugLine="totalTarget.Initialize(\"totalTarget\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"totalTarget");
RDebugUtils.currentLine=1376460;
 //BA.debugLineNum = 1376460;BA.debugLine="totalTarget.Text = total_count";
mostCurrent._totaltarget.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=1376461;
 //BA.debugLineNum = 1376461;BA.debugLine="totalTarget.Tag = target_id";
mostCurrent._totaltarget.setTag((Object)(_target_id));
RDebugUtils.currentLine=1376462;
 //BA.debugLineNum = 1376462;BA.debugLine="totalTarget.TextColor = Colors.Black";
mostCurrent._totaltarget.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376463;
 //BA.debugLineNum = 1376463;BA.debugLine="totalTarget.Color = Colors.White";
mostCurrent._totaltarget.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1376464;
 //BA.debugLineNum = 1376464;BA.debugLine="totalTarget.TextSize = primaryFontSize";
mostCurrent._totaltarget.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=1376465;
 //BA.debugLineNum = 1376465;BA.debugLine="totalTarget.Gravity = Gravity.CENTER";
mostCurrent._totaltarget.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376466;
 //BA.debugLineNum = 1376466;BA.debugLine="totalTarget.Typeface = Typeface.SERIF";
mostCurrent._totaltarget.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1376467;
 //BA.debugLineNum = 1376467;BA.debugLine="Panel.AddView(totalTarget, 2dip, sale3Title.";
mostCurrent._panel.AddView((android.view.View)(mostCurrent._totaltarget.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_sale3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376469;
 //BA.debugLineNum = 1376469;BA.debugLine="Dim totalTargetTitle As Label";
_totaltargettitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376470;
 //BA.debugLineNum = 1376470;BA.debugLine="totalTargetTitle.Initialize(\"totalTargetTitl";
_totaltargettitle.Initialize(mostCurrent.activityBA,"totalTargetTitles");
RDebugUtils.currentLine=1376471;
 //BA.debugLineNum = 1376471;BA.debugLine="totalTargetTitle.Text = \" Total Target\"";
_totaltargettitle.setText(BA.ObjectToCharSequence(" Total Target"));
RDebugUtils.currentLine=1376472;
 //BA.debugLineNum = 1376472;BA.debugLine="totalTargetTitle.Tag = 20";
_totaltargettitle.setTag((Object)(20));
RDebugUtils.currentLine=1376473;
 //BA.debugLineNum = 1376473;BA.debugLine="totalTargetTitle.TextColor = Colors.Gray";
_totaltargettitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376474;
 //BA.debugLineNum = 1376474;BA.debugLine="totalTargetTitle.TextSize = secondaryFontSiz";
_totaltargettitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=1376475;
 //BA.debugLineNum = 1376475;BA.debugLine="totalTargetTitle.Gravity = Gravity.CENTER";
_totaltargettitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376476;
 //BA.debugLineNum = 1376476;BA.debugLine="totalTargetTitle.Typeface = Typeface.MONOSPA";
_totaltargettitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376477;
 //BA.debugLineNum = 1376477;BA.debugLine="totalTargetTitle.Text = totalTargetTitle.Tex";
_totaltargettitle.setText(BA.ObjectToCharSequence(_totaltargettitle.getText().toUpperCase()));
RDebugUtils.currentLine=1376478;
 //BA.debugLineNum = 1376478;BA.debugLine="Panel.AddView(totalTargetTitle, 0, totalTarg";
mostCurrent._panel.AddView((android.view.View)(_totaltargettitle.getObject()),(int) (0),(int) (mostCurrent._totaltarget.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376480;
 //BA.debugLineNum = 1376480;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376481;
 //BA.debugLineNum = 1376481;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376482;
 //BA.debugLineNum = 1376482;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=1376483;
 //BA.debugLineNum = 1376483;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376484;
 //BA.debugLineNum = 1376484;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=1376485;
 //BA.debugLineNum = 1376485;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376486;
 //BA.debugLineNum = 1376486;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1376487;
 //BA.debugLineNum = 1376487;BA.debugLine="Panel.AddView(totalPos, panelWidth, totalTar";
mostCurrent._panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,(int) (_totaltargettitle.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376489;
 //BA.debugLineNum = 1376489;BA.debugLine="Dim totalPosTitle As Label";
_totalpostitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376490;
 //BA.debugLineNum = 1376490;BA.debugLine="totalPosTitle.Initialize(\"\")";
_totalpostitle.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376491;
 //BA.debugLineNum = 1376491;BA.debugLine="totalPosTitle.Text = \" Total Pos\"";
_totalpostitle.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=1376492;
 //BA.debugLineNum = 1376492;BA.debugLine="totalPosTitle.TextColor = Colors.Gray";
_totalpostitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376493;
 //BA.debugLineNum = 1376493;BA.debugLine="totalPosTitle.TextSize = secondaryFontSize";
_totalpostitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=1376494;
 //BA.debugLineNum = 1376494;BA.debugLine="totalPosTitle.Gravity = Gravity.CENTER";
_totalpostitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376495;
 //BA.debugLineNum = 1376495;BA.debugLine="totalPosTitle.Typeface = Typeface.MONOSPACE";
_totalpostitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376496;
 //BA.debugLineNum = 1376496;BA.debugLine="totalPosTitle.Text = totalPosTitle.Text.ToUp";
_totalpostitle.setText(BA.ObjectToCharSequence(_totalpostitle.getText().toUpperCase()));
RDebugUtils.currentLine=1376497;
 //BA.debugLineNum = 1376497;BA.debugLine="Panel.AddView(totalPosTitle, panelWidth, tot";
mostCurrent._panel.AddView((android.view.View)(_totalpostitle.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=1376499;
 //BA.debugLineNum = 1376499;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1376500;
 //BA.debugLineNum = 1376500;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 2dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (156),(int) (0),(int) (0)));
RDebugUtils.currentLine=1376501;
 //BA.debugLineNum = 1376501;BA.debugLine="Panel.Background = cd";
mostCurrent._panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=1376503;
 //BA.debugLineNum = 1376503;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=1376504;
 //BA.debugLineNum = 1376504;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
RDebugUtils.currentLine=1376505;
 //BA.debugLineNum = 1376505;BA.debugLine="If count Mod numColumns = 0 Then";
if (_count%_numcolumns==0) { 
RDebugUtils.currentLine=1376506;
 //BA.debugLineNum = 1376506;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1376507;
 //BA.debugLineNum = 1376507;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
_topposition = (int) (_topposition+_pnlheight+_padding);
 }else {
RDebugUtils.currentLine=1376509;
 //BA.debugLineNum = 1376509;BA.debugLine="leftPosition = leftPosition + pnlWidth + p";
_leftposition = (int) (_leftposition+_pnlwidth+_padding);
 };
RDebugUtils.currentLine=1376511;
 //BA.debugLineNum = 1376511;BA.debugLine="scrollHeight = scrollHeight + 175dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (175)));
 }else {
RDebugUtils.currentLine=1376513;
 //BA.debugLineNum = 1376513;BA.debugLine="topPosition = topPosition + pnlHeight + pad";
_topposition = (int) (_topposition+_pnlheight+_padding);
RDebugUtils.currentLine=1376514;
 //BA.debugLineNum = 1376514;BA.debugLine="scrollHeight = scrollHeight + 290dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (290)));
 };
 }
};
RDebugUtils.currentLine=1376518;
 //BA.debugLineNum = 1376518;BA.debugLine="scrollViewPanel4.Panel.Height = scrollHeight";
mostCurrent._scrollviewpanel4.getPanel().setHeight(_scrollheight);
RDebugUtils.currentLine=1376519;
 //BA.debugLineNum = 1376519;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break; }
case 1: {
RDebugUtils.currentLine=1376521;
 //BA.debugLineNum = 1376521;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376522;
 //BA.debugLineNum = 1376522;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
case 2: {
RDebugUtils.currentLine=1376525;
 //BA.debugLineNum = 1376525;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=1376526;
 //BA.debugLineNum = 1376526;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=1376528;
 //BA.debugLineNum = 1376528;BA.debugLine="Dim idCom As Int = Starter.company_selected.A";
_idcom = ((int)(Double.parseDouble(mostCurrent._starter._company_selected /*String*/ )));
RDebugUtils.currentLine=1376529;
 //BA.debugLineNum = 1376529;BA.debugLine="For i = 0 To salesArray.Size - 1";
{
final int step242 = 1;
final int limit242 = (int) (_salesarray.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit242 ;_i = _i + step242 ) {
RDebugUtils.currentLine=1376530;
 //BA.debugLineNum = 1376530;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=1376531;
 //BA.debugLineNum = 1376531;BA.debugLine="Dim currentComId As String = record.Get(\"com";
_currentcomid = BA.ObjectToString(_record.Get((Object)("comId")));
RDebugUtils.currentLine=1376533;
 //BA.debugLineNum = 1376533;BA.debugLine="If currentComId = idCom Then";
if ((_currentcomid).equals(BA.NumberToString(_idcom))) { 
RDebugUtils.currentLine=1376534;
 //BA.debugLineNum = 1376534;BA.debugLine="If record.ContainsKey(\"branches\") Then";
if (_record.ContainsKey((Object)("branches"))) { 
RDebugUtils.currentLine=1376535;
 //BA.debugLineNum = 1376535;BA.debugLine="Dim branches1 As List = record.Get(\"branch";
_branches1 = new anywheresoftware.b4a.objects.collections.List();
_branches1 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_record.Get((Object)("branches"))));
RDebugUtils.currentLine=1376536;
 //BA.debugLineNum = 1376536;BA.debugLine="Dim totalBranches As Int = branches1.Size";
_totalbranches = _branches1.getSize();
RDebugUtils.currentLine=1376538;
 //BA.debugLineNum = 1376538;BA.debugLine="Dim branchNames(totalBranches) As String";
_branchnames = new String[_totalbranches];
java.util.Arrays.fill(_branchnames,"");
RDebugUtils.currentLine=1376539;
 //BA.debugLineNum = 1376539;BA.debugLine="Dim branchSales1(totalBranches) As Int";
_branchsales1 = new int[_totalbranches];
;
RDebugUtils.currentLine=1376540;
 //BA.debugLineNum = 1376540;BA.debugLine="Dim branchSales2(totalBranches) As Int";
_branchsales2 = new int[_totalbranches];
;
RDebugUtils.currentLine=1376541;
 //BA.debugLineNum = 1376541;BA.debugLine="Dim branchSales3(totalBranches) As Int";
_branchsales3 = new int[_totalbranches];
;
RDebugUtils.currentLine=1376543;
 //BA.debugLineNum = 1376543;BA.debugLine="For j = 0 To totalBranches - 1";
{
final int step253 = 1;
final int limit253 = (int) (_totalbranches-1);
_j = (int) (0) ;
for (;_j <= limit253 ;_j = _j + step253 ) {
RDebugUtils.currentLine=1376544;
 //BA.debugLineNum = 1376544;BA.debugLine="Dim branchMap As Map = branches1.Get(j)";
_branchmap = new anywheresoftware.b4a.objects.collections.Map();
_branchmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_branches1.Get(_j)));
RDebugUtils.currentLine=1376545;
 //BA.debugLineNum = 1376545;BA.debugLine="branchNames(j) = branchMap.GetDefault(\"br";
_branchnames[_j] = (BA.ObjectToString(_branchmap.GetDefault((Object)("branch_name"),(Object)(""))));
RDebugUtils.currentLine=1376546;
 //BA.debugLineNum = 1376546;BA.debugLine="branchSales1(j) = branchMap.GetDefault(\"s";
_branchsales1[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales1"),(Object)(0))));
RDebugUtils.currentLine=1376547;
 //BA.debugLineNum = 1376547;BA.debugLine="branchSales2(j) = branchMap.GetDefault(\"s";
_branchsales2[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales2"),(Object)(0))));
RDebugUtils.currentLine=1376548;
 //BA.debugLineNum = 1376548;BA.debugLine="branchSales3(j) = branchMap.GetDefault(\"s";
_branchsales3[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales3"),(Object)(0))));
 }
};
RDebugUtils.currentLine=1376551;
 //BA.debugLineNum = 1376551;BA.debugLine="purchasePanel.RemoveAllViews";
mostCurrent._purchasepanel.RemoveAllViews();
RDebugUtils.currentLine=1376552;
 //BA.debugLineNum = 1376552;BA.debugLine="Dim legend() As String = Array As String(\"";
_legend = new String[]{"Sales1","Sales2","Sales3"};
RDebugUtils.currentLine=1376555;
 //BA.debugLineNum = 1376555;BA.debugLine="If barGraphInitialized = False Then";
if (_bargraphinitialized==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1376556;
 //BA.debugLineNum = 1376556;BA.debugLine="nxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._nxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=1376557;
 //BA.debugLineNum = 1376557;BA.debugLine="backbtn.Initialize(\"backbtn\")";
mostCurrent._backbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=1376558;
 //BA.debugLineNum = 1376558;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
mostCurrent._sortbtn1.Initialize(mostCurrent.activityBA,"sortBtn1");
RDebugUtils.currentLine=1376559;
 //BA.debugLineNum = 1376559;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
mostCurrent._sortbtn2.Initialize(mostCurrent.activityBA,"sortBtn2");
RDebugUtils.currentLine=1376560;
 //BA.debugLineNum = 1376560;BA.debugLine="defBtn.Initialize(\"defBtn\")";
mostCurrent._defbtn.Initialize(mostCurrent.activityBA,"defBtn");
RDebugUtils.currentLine=1376561;
 //BA.debugLineNum = 1376561;BA.debugLine="salesBtn1.Initialize(\"salesBtn1\")";
mostCurrent._salesbtn1.Initialize(mostCurrent.activityBA,"salesBtn1");
RDebugUtils.currentLine=1376562;
 //BA.debugLineNum = 1376562;BA.debugLine="salesBtn2.Initialize(\"salesBtn2\")";
mostCurrent._salesbtn2.Initialize(mostCurrent.activityBA,"salesBtn2");
RDebugUtils.currentLine=1376563;
 //BA.debugLineNum = 1376563;BA.debugLine="salesBtn3.Initialize(\"salesBtn3\")";
mostCurrent._salesbtn3.Initialize(mostCurrent.activityBA,"salesBtn3");
RDebugUtils.currentLine=1376564;
 //BA.debugLineNum = 1376564;BA.debugLine="barGraph.Initialize(Activity, purchasePan";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_branchsales1,_branchsales2,_branchsales3,_branchnames,_legend,(int) (10000),"Sales Per Branch",_branchsales1,"Branch",mostCurrent._nxtbtn,mostCurrent._backbtn,mostCurrent._sortbtn1,mostCurrent._sortbtn2,mostCurrent._defbtn,mostCurrent._salesbtn1,mostCurrent._salesbtn2,mostCurrent._salesbtn3);
RDebugUtils.currentLine=1376565;
 //BA.debugLineNum = 1376565;BA.debugLine="barGraphInitialized = True";
_bargraphinitialized = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1376566;
 //BA.debugLineNum = 1376566;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 }else {
RDebugUtils.currentLine=1376570;
 //BA.debugLineNum = 1376570;BA.debugLine="barGraph.sale_1 = branchSales1";
mostCurrent._bargraph._sale_1 /*int[]*/  = _branchsales1;
RDebugUtils.currentLine=1376571;
 //BA.debugLineNum = 1376571;BA.debugLine="barGraph.sale_2 = branchSales2";
mostCurrent._bargraph._sale_2 /*int[]*/  = _branchsales2;
RDebugUtils.currentLine=1376572;
 //BA.debugLineNum = 1376572;BA.debugLine="barGraph.sale_3 = branchSales3";
mostCurrent._bargraph._sale_3 /*int[]*/  = _branchsales3;
RDebugUtils.currentLine=1376573;
 //BA.debugLineNum = 1376573;BA.debugLine="barGraph.product1 = branchNames";
mostCurrent._bargraph._product1 /*String[]*/  = _branchnames;
RDebugUtils.currentLine=1376574;
 //BA.debugLineNum = 1376574;BA.debugLine="barGraph.comId1 = branchSales1 ' Assuming";
mostCurrent._bargraph._comid1 /*int[]*/  = _branchsales1;
RDebugUtils.currentLine=1376575;
 //BA.debugLineNum = 1376575;BA.debugLine="barGraph.UpdateGraph";
mostCurrent._bargraph._updategraph /*String*/ (null);
 };
RDebugUtils.currentLine=1376578;
 //BA.debugLineNum = 1376578;BA.debugLine="backbtn.Enabled = currentPage > 1";
mostCurrent._backbtn.setEnabled(_currentpage>1);
 }else {
RDebugUtils.currentLine=1376581;
 //BA.debugLineNum = 1376581;BA.debugLine="Log($\"Company: ${name} has no branches inf";
anywheresoftware.b4a.keywords.Common.LogImpl("01376581",("Company: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_name))+" has no branches information."),0);
 };
 };
 }
};
 break; }
default: {
RDebugUtils.currentLine=1376587;
 //BA.debugLineNum = 1376587;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("01376587","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e292) {
			processBA.setLastException(e292);RDebugUtils.currentLine=1376591;
 //BA.debugLineNum = 1376591;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=1376594;
 //BA.debugLineNum = 1376594;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1376597;
 //BA.debugLineNum = 1376597;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=1376598;
 //BA.debugLineNum = 1376598;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="branch_selected = selectedCompany";
_branch_selected = _selectedcompany;
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="StartActivity(\"Device\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Device"));
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="End Sub";
return "";
}
public static String  _nxtbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtbtn_click", null));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub nxtBtn_Click";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="currentPage = currentPage + 1";
_currentpage = (int) (_currentpage+1);
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Log(currentPage)";
anywheresoftware.b4a.keywords.Common.LogImpl("02097154",BA.NumberToString(_currentpage),0);
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="FetchNewPageData";
_fetchnewpagedata();
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn1_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn1_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub salesBtn1_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="LoadCompanyDataBranch";
_loadcompanydatabranch();
 };
RDebugUtils.currentLine=2424839;
 //BA.debugLineNum = 2424839;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("02424839",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=2424840;
 //BA.debugLineNum = 2424840;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
anywheresoftware.b4a.keywords.Common.LogImpl("02424840"," sales 1 Button clicked: "+_index,0);
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn2_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn2_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub salesBtn2_Click";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="LoadCompanyDataBranch";
_loadcompanydatabranch();
 };
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("02490375",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("02490376",_index,0);
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="Log(\"(Sale2)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("02490377","(Sale2)",0);
RDebugUtils.currentLine=2490378;
 //BA.debugLineNum = 2490378;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn3_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn3_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub salesBtn3_Click";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="LoadCompanyDataBranch";
_loadcompanydatabranch();
 };
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("02555911",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("02555913",_index,0);
RDebugUtils.currentLine=2555914;
 //BA.debugLineNum = 2555914;BA.debugLine="Log(\"(Sale3)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("02555914","(Sale3)",0);
RDebugUtils.currentLine=2555915;
 //BA.debugLineNum = 2555915;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn1_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn1_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub sortBtn1_Click";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="sortDefaultValue = index.ToLowerCase";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("02359301",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="LoadCompanyDataBranch";
_loadcompanydatabranch();
RDebugUtils.currentLine=2359303;
 //BA.debugLineNum = 2359303;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn2_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn2_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub sortBtn2_Click";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="sortDefaultValue = index.ToLowerCase";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="LoadCompanyDataBranch";
_loadcompanydatabranch();
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("02293765",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="End Sub";
return "";
}
public static String  _totaltarget_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltarget_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltarget_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub totalTarget_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Dim target_id_btn As Label = Sender";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="target_id_display.Text = target_id";
mostCurrent._target_id_display.setText(BA.ObjectToCharSequence(_target_id));
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="End Sub";
return "";
}
public static String  _totaltargettitle_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltargettitle_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltargettitle_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub totalTargetTitle_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Dim target_id_btn As Label = Sender";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="End Sub";
return "";
}
}