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
public anywheresoftware.b4a.objects.ButtonWrapper _showhidebtn = null;
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
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Activity.LoadLayout(\"Branch\")";
mostCurrent._activity.LoadLayout("Branch",mostCurrent.activityBA);
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="home.TextSize = 16";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="Panel3.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="Panel3.Color = Colors.Transparent";
mostCurrent._panel3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="branches.Initialize(\"\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=2031632;
 //BA.debugLineNum = 2031632;BA.debugLine="Panel3.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="popupPanel.Initialize(\"\")";
mostCurrent._popuppanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="popupPanel.Color = Colors.ARGB(200, 0, 0, 0)";
mostCurrent._popuppanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (200),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=2031636;
 //BA.debugLineNum = 2031636;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031637;
 //BA.debugLineNum = 2031637;BA.debugLine="Activity.AddView(popupPanel, 0, 0, Activity.Width";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._popuppanel.getObject()),(int) (0),(int) (0),mostCurrent._activity.getWidth(),mostCurrent._activity.getHeight());
RDebugUtils.currentLine=2031639;
 //BA.debugLineNum = 2031639;BA.debugLine="Dim popupPanelBackground As Panel";
_popuppanelbackground = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2031640;
 //BA.debugLineNum = 2031640;BA.debugLine="popupPanelBackground.Initialize(\"\")";
_popuppanelbackground.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2031641;
 //BA.debugLineNum = 2031641;BA.debugLine="popupPanelBackground.Color = Colors.White";
_popuppanelbackground.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2031642;
 //BA.debugLineNum = 2031642;BA.debugLine="popupPanel.AddView(popupPanelBackground, 70dip, 5";
mostCurrent._popuppanel.AddView((android.view.View)(_popuppanelbackground.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (550)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500))));
RDebugUtils.currentLine=2031643;
 //BA.debugLineNum = 2031643;BA.debugLine="Dim leftPosition As Int = (popupPanel.Width - pop";
_leftposition = (int) ((mostCurrent._popuppanel.getWidth()-_popuppanelbackground.getWidth())/(double)2);
RDebugUtils.currentLine=2031644;
 //BA.debugLineNum = 2031644;BA.debugLine="popupPanelBackground.Left = leftPosition";
_popuppanelbackground.setLeft(_leftposition);
RDebugUtils.currentLine=2031646;
 //BA.debugLineNum = 2031646;BA.debugLine="Dim closeButton As Label";
_closebutton = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2031647;
 //BA.debugLineNum = 2031647;BA.debugLine="closeButton.Initialize(\"closeButton\")";
_closebutton.Initialize(mostCurrent.activityBA,"closeButton");
RDebugUtils.currentLine=2031648;
 //BA.debugLineNum = 2031648;BA.debugLine="closeButton.Text = \"X\"";
_closebutton.setText(BA.ObjectToCharSequence("X"));
RDebugUtils.currentLine=2031649;
 //BA.debugLineNum = 2031649;BA.debugLine="closeButton.TextSize = 20";
_closebutton.setTextSize((float) (20));
RDebugUtils.currentLine=2031650;
 //BA.debugLineNum = 2031650;BA.debugLine="closeButton.TextColor = Colors.Red";
_closebutton.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031651;
 //BA.debugLineNum = 2031651;BA.debugLine="closeButton.Typeface = Typeface.DEFAULT_BOLD";
_closebutton.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=2031652;
 //BA.debugLineNum = 2031652;BA.debugLine="popupPanelBackground.AddView(closeButton, popupPa";
_popuppanelbackground.AddView((android.view.View)(_closebutton.getObject()),(int) (_popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=2031654;
 //BA.debugLineNum = 2031654;BA.debugLine="target_id_display.Initialize(\"target_id_display\")";
mostCurrent._target_id_display.Initialize(mostCurrent.activityBA,"target_id_display");
RDebugUtils.currentLine=2031655;
 //BA.debugLineNum = 2031655;BA.debugLine="target_id_display.TextSize = 20";
mostCurrent._target_id_display.setTextSize((float) (20));
RDebugUtils.currentLine=2031656;
 //BA.debugLineNum = 2031656;BA.debugLine="target_id_display.TextColor = Colors.Red";
mostCurrent._target_id_display.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031657;
 //BA.debugLineNum = 2031657;BA.debugLine="target_id_display.Typeface = Typeface.DEFAULT_BOL";
mostCurrent._target_id_display.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=2031658;
 //BA.debugLineNum = 2031658;BA.debugLine="popupPanelBackground.AddView(target_id_display, p";
_popuppanelbackground.AddView((android.view.View)(mostCurrent._target_id_display.getObject()),(int) (_popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=2031660;
 //BA.debugLineNum = 2031660;BA.debugLine="Dim popupText As Label";
_popuptext = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2031661;
 //BA.debugLineNum = 2031661;BA.debugLine="popupText.Initialize(\"\")";
_popuptext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2031662;
 //BA.debugLineNum = 2031662;BA.debugLine="popupText.Text = \"Edit Target\"";
_popuptext.setText(BA.ObjectToCharSequence("Edit Target"));
RDebugUtils.currentLine=2031663;
 //BA.debugLineNum = 2031663;BA.debugLine="popupText.TextColor = Colors.Black";
_popuptext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2031664;
 //BA.debugLineNum = 2031664;BA.debugLine="popupText.TextSize = 58";
_popuptext.setTextSize((float) (58));
RDebugUtils.currentLine=2031665;
 //BA.debugLineNum = 2031665;BA.debugLine="popupText.Gravity = Gravity.CENTER";
_popuptext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2031666;
 //BA.debugLineNum = 2031666;BA.debugLine="popupPanelBackground.AddView(popupText, 25dip, 10";
_popuppanelbackground.AddView((android.view.View)(_popuptext.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=2031668;
 //BA.debugLineNum = 2031668;BA.debugLine="target_countLabel.Initialize(\"\")";
mostCurrent._target_countlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2031669;
 //BA.debugLineNum = 2031669;BA.debugLine="target_countLabel.TextColor = Colors.Black";
mostCurrent._target_countlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2031670;
 //BA.debugLineNum = 2031670;BA.debugLine="target_countLabel.TextSize = 58";
mostCurrent._target_countlabel.setTextSize((float) (58));
RDebugUtils.currentLine=2031671;
 //BA.debugLineNum = 2031671;BA.debugLine="target_countLabel.Gravity = Gravity.CENTER";
mostCurrent._target_countlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2031672;
 //BA.debugLineNum = 2031672;BA.debugLine="popupPanelBackground.AddView(target_countLabel, 2";
_popuppanelbackground.AddView((android.view.View)(mostCurrent._target_countlabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=2031673;
 //BA.debugLineNum = 2031673;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
RDebugUtils.currentLine=2031675;
 //BA.debugLineNum = 2031675;BA.debugLine="Dim edit_button As Button";
_edit_button = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2031676;
 //BA.debugLineNum = 2031676;BA.debugLine="edit_button.Initialize(\"edit_button\")";
_edit_button.Initialize(mostCurrent.activityBA,"edit_button");
RDebugUtils.currentLine=2031677;
 //BA.debugLineNum = 2031677;BA.debugLine="edit_button.Text = \"Update\"";
_edit_button.setText(BA.ObjectToCharSequence("Update"));
RDebugUtils.currentLine=2031678;
 //BA.debugLineNum = 2031678;BA.debugLine="edit_button.TextColor = Colors.Black";
_edit_button.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2031679;
 //BA.debugLineNum = 2031679;BA.debugLine="edit_button.TextSize = 58";
_edit_button.setTextSize((float) (58));
RDebugUtils.currentLine=2031680;
 //BA.debugLineNum = 2031680;BA.debugLine="edit_button.Gravity = Gravity.CENTER";
_edit_button.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2031681;
 //BA.debugLineNum = 2031681;BA.debugLine="popupPanelBackground.AddView(edit_button, 25dip,";
_popuppanelbackground.AddView((android.view.View)(_edit_button.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=2031683;
 //BA.debugLineNum = 2031683;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2031684;
 //BA.debugLineNum = 2031684;BA.debugLine="Panel4.AddView(purchasePanel, 0, 0dip, Activity.W";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (530)));
RDebugUtils.currentLine=2031685;
 //BA.debugLineNum = 2031685;BA.debugLine="purchasePanel.Color = Colors.White ' Set a visibl";
mostCurrent._purchasepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2031687;
 //BA.debugLineNum = 2031687;BA.debugLine="scrollViewPanel4.Initialize(Panel4.Height - purch";
mostCurrent._scrollviewpanel4.Initialize(mostCurrent.activityBA,(int) (mostCurrent._panel4.getHeight()-mostCurrent._purchasepanel.getHeight()));
RDebugUtils.currentLine=2031688;
 //BA.debugLineNum = 2031688;BA.debugLine="Panel4.AddView(scrollViewPanel4, 0, purchasePanel";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._scrollviewpanel4.getObject()),(int) (0),mostCurrent._purchasepanel.getHeight(),mostCurrent._panel4.getWidth(),(int) (mostCurrent._panel4.getHeight()-mostCurrent._purchasepanel.getHeight()));
RDebugUtils.currentLine=2031690;
 //BA.debugLineNum = 2031690;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=2031691;
 //BA.debugLineNum = 2031691;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=2031692;
 //BA.debugLineNum = 2031692;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="totalTarget.Initialize(\"\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Panel.Initialize(\"\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="Panel.RemoveAllViews";
mostCurrent._panel.RemoveAllViews();
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="PHPURL = \"https://192.168.8.117/Company/controlle";
mostCurrent._phpurl = "https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="+mostCurrent._starter._company_selected /*String*/ ;
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="Log(Starter.company_selected & \"id\")";
anywheresoftware.b4a.keywords.Common.LogImpl("72162695",mostCurrent._starter._company_selected /*String*/ +"id",0);
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",branch.getObject());
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydatabranchgraph() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydatabranchgraph", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydatabranchgraph", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Sub LoadCompanyDataBranchGraph";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="Try";
try {RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="Job1.Initialize(\"GetBranches\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetBranches",branch.getObject());
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="PHPURL1 = $\"https://192.168.8.117/Company/contro";
mostCurrent._phpurl1 = ("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._company_selected /*String*/ ))+"&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"&branch_sales="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_salesdata1))+"&sort_type="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+"");
RDebugUtils.currentLine=7798791;
 //BA.debugLineNum = 7798791;BA.debugLine="Log(Starter.company_selected & \"isd\")";
anywheresoftware.b4a.keywords.Common.LogImpl("77798791",mostCurrent._starter._company_selected /*String*/ +"isd",0);
RDebugUtils.currentLine=7798792;
 //BA.debugLineNum = 7798792;BA.debugLine="Job1.Download(PHPURL1)";
_job1._download /*String*/ (null,mostCurrent._phpurl1);
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=7798795;
 //BA.debugLineNum = 7798795;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("77798795",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=7798797;
 //BA.debugLineNum = 7798797;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="branch";
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub backbtn_Click";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="currentPage = currentPage - 1";
_currentpage = (int) (_currentpage-1);
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="FetchNewPageData";
_fetchnewpagedata();
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="End Sub";
return "";
}
public static String  _fetchnewpagedata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fetchnewpagedata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fetchnewpagedata", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub FetchNewPageData";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="LoadCompanyDataBranchGraph ' Fetch new data for t";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _closebutton_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closebutton_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closebutton_click", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub closeButton_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="End Sub";
return "";
}
public static String  _defbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "defbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "defbtn_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub defBtn_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="sortDefaultValue = \"\"";
mostCurrent._sortdefaultvalue = "";
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("73145733",_index,0);
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="Log(\"(default)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("73145734","(default)",0);
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="End Sub";
return "";
}
public static String  _edit_button_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edit_button_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edit_button_click", null));}
int _target_id = 0;
int _new_value = 0;
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub edit_button_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Dim target_id As Int = target_id_display.Text";
_target_id = (int)(Double.parseDouble(mostCurrent._target_id_display.getText()));
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Dim new_value As Int = target_countLabel.Text";
_new_value = (int)(Double.parseDouble(mostCurrent._target_countlabel.getText()));
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_target_id)) && anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_new_value))) { 
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="UpdateData_Remote(target_id, new_value)";
_updatedata_remote(_target_id,_new_value);
RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 }else {
RDebugUtils.currentLine=2424840;
 //BA.debugLineNum = 2424840;BA.debugLine="Log(\"Invalid input values\")";
anywheresoftware.b4a.keywords.Common.LogImpl("72424840","Invalid input values",0);
 };
RDebugUtils.currentLine=2424842;
 //BA.debugLineNum = 2424842;BA.debugLine="End Sub";
return "";
}
public static String  _updatedata_remote(int _target_id,int _new_value) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatedata_remote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updatedata_remote", new Object[] {_target_id,_new_value}));}
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.141/Co";
mostCurrent._phpurl = ("https://192.168.8.141/Company/controller/branch.php?action=target_update&id="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_target_id))+"&value="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_new_value))+"");
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
_job._initialize /*String*/ (null,processBA,"UpdateData",branch.getObject());
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="job.Download(PHPURL)";
_job._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="End Sub";
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
int _totalbranches = 0;
String[] _branchnames = null;
int[] _branchsales1 = null;
int[] _branchsales2 = null;
int[] _branchsales3 = null;
int _branchcount = 0;
int _i = 0;
String[] _legend = null;
int _totalpage = 0;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Try";
try {RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","UpdateData","GetBranches","UpdateData")) {
case 0: {
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
_numcolumns = (int) (2);
RDebugUtils.currentLine=2293774;
 //BA.debugLineNum = 2293774;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
_pnlwidth = (int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=2293775;
 //BA.debugLineNum = 2293775;BA.debugLine="Dim pnlHeight As Int = 280dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280));
RDebugUtils.currentLine=2293776;
 //BA.debugLineNum = 2293776;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2293777;
 //BA.debugLineNum = 2293777;BA.debugLine="Dim leftPosition As Int = 50dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=2293778;
 //BA.debugLineNum = 2293778;BA.debugLine="Dim topPosition As Int = 0";
_topposition = (int) (0);
RDebugUtils.currentLine=2293779;
 //BA.debugLineNum = 2293779;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=2293780;
 //BA.debugLineNum = 2293780;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=2293781;
 //BA.debugLineNum = 2293781;BA.debugLine="pnlWidth = 490dip";
_pnlwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (490));
RDebugUtils.currentLine=2293782;
 //BA.debugLineNum = 2293782;BA.debugLine="pnlHeight = 300dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300));
RDebugUtils.currentLine=2293783;
 //BA.debugLineNum = 2293783;BA.debugLine="padding = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2293784;
 //BA.debugLineNum = 2293784;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 };
RDebugUtils.currentLine=2293786;
 //BA.debugLineNum = 2293786;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group23 = mostCurrent._tabledetails;
final int groupLen23 = group23.getSize()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group23.Get(index23)));
RDebugUtils.currentLine=2293787;
 //BA.debugLineNum = 2293787;BA.debugLine="Dim companyName As String = record.Get(\"comp";
_companyname = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=2293788;
 //BA.debugLineNum = 2293788;BA.debugLine="Dim id As String = record.Get(\"branch_id\")";
_id = BA.ObjectToString(_record.Get((Object)("branch_id")));
RDebugUtils.currentLine=2293789;
 //BA.debugLineNum = 2293789;BA.debugLine="Dim name As String = record.Get(\"branch_name";
_name = BA.ObjectToString(_record.Get((Object)("branch_name")));
RDebugUtils.currentLine=2293790;
 //BA.debugLineNum = 2293790;BA.debugLine="Dim total_count As Int = record.Get(\"target_";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("target_no"))));
RDebugUtils.currentLine=2293791;
 //BA.debugLineNum = 2293791;BA.debugLine="Dim total_pos As Int = record.Get(\"count_dev";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("count_device"))));
RDebugUtils.currentLine=2293792;
 //BA.debugLineNum = 2293792;BA.debugLine="Dim totalPur1 As String = record.Get(\"purcha";
_totalpur1 = BA.ObjectToString(_record.Get((Object)("purchase_1")));
RDebugUtils.currentLine=2293793;
 //BA.debugLineNum = 2293793;BA.debugLine="Dim totalPur2 As String = record.Get(\"purcha";
_totalpur2 = BA.ObjectToString(_record.Get((Object)("purchase_2")));
RDebugUtils.currentLine=2293794;
 //BA.debugLineNum = 2293794;BA.debugLine="Dim totalPur3 As String = record.Get(\"purcha";
_totalpur3 = BA.ObjectToString(_record.Get((Object)("purchase_3")));
RDebugUtils.currentLine=2293795;
 //BA.debugLineNum = 2293795;BA.debugLine="Dim totalSales1 As String = record.Get(\"sale";
_totalsales1 = BA.ObjectToString(_record.Get((Object)("sales_1")));
RDebugUtils.currentLine=2293796;
 //BA.debugLineNum = 2293796;BA.debugLine="Dim totalSales2 As String = record.Get(\"sale";
_totalsales2 = BA.ObjectToString(_record.Get((Object)("sales_2")));
RDebugUtils.currentLine=2293797;
 //BA.debugLineNum = 2293797;BA.debugLine="Dim totalSales3 As String = record.Get(\"sale";
_totalsales3 = BA.ObjectToString(_record.Get((Object)("sales_3")));
RDebugUtils.currentLine=2293798;
 //BA.debugLineNum = 2293798;BA.debugLine="Dim target_id As String = record.Get(\"target";
_target_id = BA.ObjectToString(_record.Get((Object)("target_id")));
RDebugUtils.currentLine=2293799;
 //BA.debugLineNum = 2293799;BA.debugLine="totalSales = totalSales1.Length";
_totalsales = _totalsales1.length();
RDebugUtils.currentLine=2293800;
 //BA.debugLineNum = 2293800;BA.debugLine="target_countLabel.Text = total_count";
mostCurrent._target_countlabel.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=2293801;
 //BA.debugLineNum = 2293801;BA.debugLine="branches.Text = \"Branches - \" & companyName";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_companyname));
RDebugUtils.currentLine=2293802;
 //BA.debugLineNum = 2293802;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=2293804;
 //BA.debugLineNum = 2293804;BA.debugLine="LabelTitle.Text = companyName";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_companyname));
RDebugUtils.currentLine=2293805;
 //BA.debugLineNum = 2293805;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCas";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=2293806;
 //BA.debugLineNum = 2293806;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
mostCurrent._labeltitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293808;
 //BA.debugLineNum = 2293808;BA.debugLine="Panel.Initialize(\"Panel\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=2293809;
 //BA.debugLineNum = 2293809;BA.debugLine="scrollViewPanel4.Panel.AddView(Panel, leftPo";
mostCurrent._scrollviewpanel4.getPanel().AddView((android.view.View)(mostCurrent._panel.getObject()),_leftposition,_topposition,_pnlwidth,_pnlheight);
RDebugUtils.currentLine=2293810;
 //BA.debugLineNum = 2293810;BA.debugLine="Panel.Color = Colors.Black";
mostCurrent._panel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293812;
 //BA.debugLineNum = 2293812;BA.debugLine="Dim Panel2 As Panel";
_panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2293813;
 //BA.debugLineNum = 2293813;BA.debugLine="Panel2.Initialize(\"Panel2\")";
_panel2.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=2293814;
 //BA.debugLineNum = 2293814;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=2293815;
 //BA.debugLineNum = 2293815;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As I";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=2293816;
 //BA.debugLineNum = 2293816;BA.debugLine="Panel2.Background = gradient";
_panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=2293817;
 //BA.debugLineNum = 2293817;BA.debugLine="Panel2.Tag = name";
_panel2.setTag((Object)(_name));
RDebugUtils.currentLine=2293818;
 //BA.debugLineNum = 2293818;BA.debugLine="Panel2.SendToBack";
_panel2.SendToBack();
RDebugUtils.currentLine=2293819;
 //BA.debugLineNum = 2293819;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y";
mostCurrent._panel.AddView((android.view.View)(_panel2.getObject()),(int) (0),(int) (0),mostCurrent._panel.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=2293821;
 //BA.debugLineNum = 2293821;BA.debugLine="Dim BranchNameLabel As Label";
_branchnamelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293822;
 //BA.debugLineNum = 2293822;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
_branchnamelabel.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=2293823;
 //BA.debugLineNum = 2293823;BA.debugLine="BranchNameLabel.Text = name";
_branchnamelabel.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=2293824;
 //BA.debugLineNum = 2293824;BA.debugLine="BranchNameLabel.Tag = id";
_branchnamelabel.setTag((Object)(_id));
RDebugUtils.currentLine=2293825;
 //BA.debugLineNum = 2293825;BA.debugLine="BranchNameLabel.TextSize = 18";
_branchnamelabel.setTextSize((float) (18));
RDebugUtils.currentLine=2293826;
 //BA.debugLineNum = 2293826;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
_branchnamelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2293827;
 //BA.debugLineNum = 2293827;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPAC";
_branchnamelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293828;
 //BA.debugLineNum = 2293828;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VER";
_branchnamelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2293829;
 //BA.debugLineNum = 2293829;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip,";
_panel2.AddView((android.view.View)(_branchnamelabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panel2.getWidth(),_panel2.getHeight());
RDebugUtils.currentLine=2293831;
 //BA.debugLineNum = 2293831;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2293832;
 //BA.debugLineNum = 2293832;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=2293833;
 //BA.debugLineNum = 2293833;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=2293834;
 //BA.debugLineNum = 2293834;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2293835;
 //BA.debugLineNum = 2293835;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2293836;
 //BA.debugLineNum = 2293836;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293837;
 //BA.debugLineNum = 2293837;BA.debugLine="imgView.Bitmap = resizedImage";
_imgview.setBitmap((android.graphics.Bitmap)(_resizedimage.getObject()));
RDebugUtils.currentLine=2293838;
 //BA.debugLineNum = 2293838;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x,";
_panel2.AddView((android.view.View)(_imgview.getObject()),(int) (_panel2.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),_panel2.getHeight());
 }else {
RDebugUtils.currentLine=2293840;
 //BA.debugLineNum = 2293840;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("72293840","Error loading image",0);
 };
RDebugUtils.currentLine=2293843;
 //BA.debugLineNum = 2293843;BA.debugLine="Dim panelWidth As Int = Panel.Width / 3";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)3);
RDebugUtils.currentLine=2293844;
 //BA.debugLineNum = 2293844;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2293845;
 //BA.debugLineNum = 2293845;BA.debugLine="Dim labelheight As Int = 35dip";
_labelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35));
RDebugUtils.currentLine=2293847;
 //BA.debugLineNum = 2293847;BA.debugLine="Dim purchase1 As Label";
_purchase1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293848;
 //BA.debugLineNum = 2293848;BA.debugLine="purchase1.Initialize(\"\")";
_purchase1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293849;
 //BA.debugLineNum = 2293849;BA.debugLine="purchase1.Text = totalPur1";
_purchase1.setText(BA.ObjectToCharSequence(_totalpur1));
RDebugUtils.currentLine=2293850;
 //BA.debugLineNum = 2293850;BA.debugLine="purchase1.TextColor = Colors.Black";
_purchase1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293851;
 //BA.debugLineNum = 2293851;BA.debugLine="purchase1.TextSize = primaryFontSize";
_purchase1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2293852;
 //BA.debugLineNum = 2293852;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
_purchase1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293853;
 //BA.debugLineNum = 2293853;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
_purchase1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2293854;
 //BA.debugLineNum = 2293854;BA.debugLine="Panel.AddView(purchase1, 0, Panel2.Height +";
mostCurrent._panel.AddView((android.view.View)(_purchase1.getObject()),(int) (0),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293856;
 //BA.debugLineNum = 2293856;BA.debugLine="Dim purchase1Title As Label";
_purchase1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293857;
 //BA.debugLineNum = 2293857;BA.debugLine="purchase1Title.Initialize(\"\")";
_purchase1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293858;
 //BA.debugLineNum = 2293858;BA.debugLine="purchase1Title.Text = \"First Purchase\"";
_purchase1title.setText(BA.ObjectToCharSequence("First Purchase"));
RDebugUtils.currentLine=2293859;
 //BA.debugLineNum = 2293859;BA.debugLine="purchase1Title.TextColor = Colors.Gray";
_purchase1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2293860;
 //BA.debugLineNum = 2293860;BA.debugLine="purchase1Title.TextSize = secondaryFontSize";
_purchase1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2293861;
 //BA.debugLineNum = 2293861;BA.debugLine="purchase1Title.Gravity = Gravity.CENTER";
_purchase1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293862;
 //BA.debugLineNum = 2293862;BA.debugLine="purchase1Title.Typeface = Typeface.MONOSPACE";
_purchase1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293863;
 //BA.debugLineNum = 2293863;BA.debugLine="purchase1Title.Text = purchase1Title.Text.To";
_purchase1title.setText(BA.ObjectToCharSequence(_purchase1title.getText().toUpperCase()));
RDebugUtils.currentLine=2293864;
 //BA.debugLineNum = 2293864;BA.debugLine="Panel.AddView(purchase1Title, 0, purchase1.t";
mostCurrent._panel.AddView((android.view.View)(_purchase1title.getObject()),(int) (0),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293866;
 //BA.debugLineNum = 2293866;BA.debugLine="Dim purchase2 As Label";
_purchase2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293867;
 //BA.debugLineNum = 2293867;BA.debugLine="purchase2.Initialize(\"\")";
_purchase2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293868;
 //BA.debugLineNum = 2293868;BA.debugLine="purchase2.Text = totalPur2";
_purchase2.setText(BA.ObjectToCharSequence(_totalpur2));
RDebugUtils.currentLine=2293869;
 //BA.debugLineNum = 2293869;BA.debugLine="purchase2.TextColor = Colors.Black";
_purchase2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293870;
 //BA.debugLineNum = 2293870;BA.debugLine="purchase2.TextSize = primaryFontSize";
_purchase2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2293871;
 //BA.debugLineNum = 2293871;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
_purchase2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293872;
 //BA.debugLineNum = 2293872;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
_purchase2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2293873;
 //BA.debugLineNum = 2293873;BA.debugLine="Panel.AddView(purchase2, panelWidth, Panel2.";
mostCurrent._panel.AddView((android.view.View)(_purchase2.getObject()),_panelwidth,(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293875;
 //BA.debugLineNum = 2293875;BA.debugLine="Dim purchase2Title As Label";
_purchase2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293876;
 //BA.debugLineNum = 2293876;BA.debugLine="purchase2Title.Initialize(\"\")";
_purchase2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293877;
 //BA.debugLineNum = 2293877;BA.debugLine="purchase2Title.Text = \"Second Purchase\"";
_purchase2title.setText(BA.ObjectToCharSequence("Second Purchase"));
RDebugUtils.currentLine=2293878;
 //BA.debugLineNum = 2293878;BA.debugLine="purchase2Title.TextColor = Colors.Gray";
_purchase2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2293879;
 //BA.debugLineNum = 2293879;BA.debugLine="purchase2Title.TextSize = secondaryFontSize";
_purchase2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2293880;
 //BA.debugLineNum = 2293880;BA.debugLine="purchase2Title.Gravity = Gravity.CENTER";
_purchase2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293881;
 //BA.debugLineNum = 2293881;BA.debugLine="purchase2Title.Typeface = Typeface.MONOSPACE";
_purchase2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293882;
 //BA.debugLineNum = 2293882;BA.debugLine="purchase2Title.Text = purchase2Title.Text.To";
_purchase2title.setText(BA.ObjectToCharSequence(_purchase2title.getText().toUpperCase()));
RDebugUtils.currentLine=2293883;
 //BA.debugLineNum = 2293883;BA.debugLine="Panel.AddView(purchase2Title, panelWidth, pu";
mostCurrent._panel.AddView((android.view.View)(_purchase2title.getObject()),_panelwidth,(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293885;
 //BA.debugLineNum = 2293885;BA.debugLine="Dim purchase3 As Label";
_purchase3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293886;
 //BA.debugLineNum = 2293886;BA.debugLine="purchase3.Initialize(\"\")";
_purchase3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293887;
 //BA.debugLineNum = 2293887;BA.debugLine="purchase3.Text = totalPur3";
_purchase3.setText(BA.ObjectToCharSequence(_totalpur3));
RDebugUtils.currentLine=2293888;
 //BA.debugLineNum = 2293888;BA.debugLine="purchase3.TextColor = Colors.Black";
_purchase3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293889;
 //BA.debugLineNum = 2293889;BA.debugLine="purchase3.TextSize = primaryFontSize";
_purchase3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2293890;
 //BA.debugLineNum = 2293890;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
_purchase3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293891;
 //BA.debugLineNum = 2293891;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
_purchase3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2293892;
 //BA.debugLineNum = 2293892;BA.debugLine="Panel.AddView(purchase3, panelWidth * 2, Pan";
mostCurrent._panel.AddView((android.view.View)(_purchase3.getObject()),(int) (_panelwidth*2),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293894;
 //BA.debugLineNum = 2293894;BA.debugLine="Dim purchase3Title As Label";
_purchase3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293895;
 //BA.debugLineNum = 2293895;BA.debugLine="purchase3Title.Initialize(\"\")";
_purchase3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293896;
 //BA.debugLineNum = 2293896;BA.debugLine="purchase3Title.Text = \"Third Purchase\"";
_purchase3title.setText(BA.ObjectToCharSequence("Third Purchase"));
RDebugUtils.currentLine=2293897;
 //BA.debugLineNum = 2293897;BA.debugLine="purchase3Title.TextColor = Colors.Gray";
_purchase3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2293898;
 //BA.debugLineNum = 2293898;BA.debugLine="purchase3Title.TextSize = secondaryFontSize";
_purchase3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2293899;
 //BA.debugLineNum = 2293899;BA.debugLine="purchase3Title.Gravity = Gravity.CENTER";
_purchase3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293900;
 //BA.debugLineNum = 2293900;BA.debugLine="purchase3Title.Typeface = Typeface.MONOSPACE";
_purchase3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293901;
 //BA.debugLineNum = 2293901;BA.debugLine="purchase3Title.Text = purchase3Title.Text.To";
_purchase3title.setText(BA.ObjectToCharSequence(_purchase3title.getText().toUpperCase()));
RDebugUtils.currentLine=2293902;
 //BA.debugLineNum = 2293902;BA.debugLine="Panel.AddView(purchase3Title, panelWidth * 2";
mostCurrent._panel.AddView((android.view.View)(_purchase3title.getObject()),(int) (_panelwidth*2),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293904;
 //BA.debugLineNum = 2293904;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293905;
 //BA.debugLineNum = 2293905;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293906;
 //BA.debugLineNum = 2293906;BA.debugLine="sale1.Text = totalSales1";
_sale1.setText(BA.ObjectToCharSequence(_totalsales1));
RDebugUtils.currentLine=2293907;
 //BA.debugLineNum = 2293907;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293908;
 //BA.debugLineNum = 2293908;BA.debugLine="sale1.TextSize = primaryFontSize";
_sale1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2293909;
 //BA.debugLineNum = 2293909;BA.debugLine="sale1.Gravity = Gravity.CENTER";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293910;
 //BA.debugLineNum = 2293910;BA.debugLine="sale1.Typeface = Typeface.SERIF";
_sale1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2293911;
 //BA.debugLineNum = 2293911;BA.debugLine="Panel.AddView(sale1, 0, purchase3Title.Heigh";
mostCurrent._panel.AddView((android.view.View)(_sale1.getObject()),(int) (0),(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293913;
 //BA.debugLineNum = 2293913;BA.debugLine="Dim sale1Title As Label";
_sale1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293914;
 //BA.debugLineNum = 2293914;BA.debugLine="sale1Title.Initialize(\"\")";
_sale1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293915;
 //BA.debugLineNum = 2293915;BA.debugLine="sale1Title.Text = \"First Sale\"";
_sale1title.setText(BA.ObjectToCharSequence("First Sale"));
RDebugUtils.currentLine=2293916;
 //BA.debugLineNum = 2293916;BA.debugLine="sale1Title.TextColor = Colors.Gray";
_sale1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2293917;
 //BA.debugLineNum = 2293917;BA.debugLine="sale1Title.TextSize = secondaryFontSize";
_sale1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2293918;
 //BA.debugLineNum = 2293918;BA.debugLine="sale1Title.Gravity = Gravity.CENTER";
_sale1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293919;
 //BA.debugLineNum = 2293919;BA.debugLine="sale1Title.Typeface = Typeface.MONOSPACE";
_sale1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293920;
 //BA.debugLineNum = 2293920;BA.debugLine="sale1Title.Text = sale1Title.Text.ToUpperCas";
_sale1title.setText(BA.ObjectToCharSequence(_sale1title.getText().toUpperCase()));
RDebugUtils.currentLine=2293921;
 //BA.debugLineNum = 2293921;BA.debugLine="Panel.AddView(sale1Title, 0, sale1.top + pad";
mostCurrent._panel.AddView((android.view.View)(_sale1title.getObject()),(int) (0),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293923;
 //BA.debugLineNum = 2293923;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293924;
 //BA.debugLineNum = 2293924;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293925;
 //BA.debugLineNum = 2293925;BA.debugLine="sale2.Text = totalSales2";
_sale2.setText(BA.ObjectToCharSequence(_totalsales2));
RDebugUtils.currentLine=2293926;
 //BA.debugLineNum = 2293926;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293927;
 //BA.debugLineNum = 2293927;BA.debugLine="sale2.TextSize = primaryFontSize";
_sale2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2293928;
 //BA.debugLineNum = 2293928;BA.debugLine="sale2.Gravity = Gravity.CENTER";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293929;
 //BA.debugLineNum = 2293929;BA.debugLine="sale2.Typeface = Typeface.SERIF";
_sale2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2293930;
 //BA.debugLineNum = 2293930;BA.debugLine="Panel.AddView(sale2, panelWidth, purchase3Ti";
mostCurrent._panel.AddView((android.view.View)(_sale2.getObject()),_panelwidth,(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293932;
 //BA.debugLineNum = 2293932;BA.debugLine="Dim sale2Title As Label";
_sale2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293933;
 //BA.debugLineNum = 2293933;BA.debugLine="sale2Title.Initialize(\"\")";
_sale2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293934;
 //BA.debugLineNum = 2293934;BA.debugLine="sale2Title.Text = \" Second Sale\"";
_sale2title.setText(BA.ObjectToCharSequence(" Second Sale"));
RDebugUtils.currentLine=2293935;
 //BA.debugLineNum = 2293935;BA.debugLine="sale2Title.TextColor = Colors.Gray";
_sale2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2293936;
 //BA.debugLineNum = 2293936;BA.debugLine="sale2Title.TextSize = secondaryFontSize";
_sale2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2293937;
 //BA.debugLineNum = 2293937;BA.debugLine="sale2Title.Gravity = Gravity.CENTER";
_sale2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293938;
 //BA.debugLineNum = 2293938;BA.debugLine="sale2Title.Typeface = Typeface.MONOSPACE";
_sale2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293939;
 //BA.debugLineNum = 2293939;BA.debugLine="sale2Title.Text = sale2Title.Text.ToUpperCas";
_sale2title.setText(BA.ObjectToCharSequence(_sale2title.getText().toUpperCase()));
RDebugUtils.currentLine=2293940;
 //BA.debugLineNum = 2293940;BA.debugLine="Panel.AddView(sale2Title, panelWidth, sale2.";
mostCurrent._panel.AddView((android.view.View)(_sale2title.getObject()),_panelwidth,(int) (_sale2.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293942;
 //BA.debugLineNum = 2293942;BA.debugLine="Dim sale3 As Label";
_sale3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293943;
 //BA.debugLineNum = 2293943;BA.debugLine="sale3.Initialize(\"\")";
_sale3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293944;
 //BA.debugLineNum = 2293944;BA.debugLine="sale3.Text = totalSales3";
_sale3.setText(BA.ObjectToCharSequence(_totalsales3));
RDebugUtils.currentLine=2293945;
 //BA.debugLineNum = 2293945;BA.debugLine="sale3.TextColor = Colors.Black";
_sale3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293946;
 //BA.debugLineNum = 2293946;BA.debugLine="sale3.TextSize = primaryFontSize";
_sale3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2293947;
 //BA.debugLineNum = 2293947;BA.debugLine="sale3.Gravity = Gravity.CENTER";
_sale3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293948;
 //BA.debugLineNum = 2293948;BA.debugLine="sale3.Typeface = Typeface.SERIF";
_sale3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2293949;
 //BA.debugLineNum = 2293949;BA.debugLine="Panel.AddView(sale3, panelWidth * 2, sale2Ti";
mostCurrent._panel.AddView((android.view.View)(_sale3.getObject()),(int) (_panelwidth*2),(int) (_sale2title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293951;
 //BA.debugLineNum = 2293951;BA.debugLine="Dim sale3Title As Label";
_sale3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293952;
 //BA.debugLineNum = 2293952;BA.debugLine="sale3Title.Initialize(\"\")";
_sale3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293953;
 //BA.debugLineNum = 2293953;BA.debugLine="sale3Title.Text = \" Third Sale\"";
_sale3title.setText(BA.ObjectToCharSequence(" Third Sale"));
RDebugUtils.currentLine=2293954;
 //BA.debugLineNum = 2293954;BA.debugLine="sale3Title.TextColor = Colors.Gray";
_sale3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2293955;
 //BA.debugLineNum = 2293955;BA.debugLine="sale3Title.TextSize = secondaryFontSize";
_sale3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2293956;
 //BA.debugLineNum = 2293956;BA.debugLine="sale3Title.Gravity = Gravity.CENTER";
_sale3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293957;
 //BA.debugLineNum = 2293957;BA.debugLine="sale3Title.Typeface = Typeface.MONOSPACE";
_sale3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293958;
 //BA.debugLineNum = 2293958;BA.debugLine="sale3Title.Text = sale3Title.Text.ToUpperCas";
_sale3title.setText(BA.ObjectToCharSequence(_sale3title.getText().toUpperCase()));
RDebugUtils.currentLine=2293959;
 //BA.debugLineNum = 2293959;BA.debugLine="Panel.AddView(sale3Title, panelWidth * 2, sa";
mostCurrent._panel.AddView((android.view.View)(_sale3title.getObject()),(int) (_panelwidth*2),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293961;
 //BA.debugLineNum = 2293961;BA.debugLine="panelWidth = Panel.Width / 2";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)2);
RDebugUtils.currentLine=2293963;
 //BA.debugLineNum = 2293963;BA.debugLine="totalTarget.Initialize(\"totalTarget\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"totalTarget");
RDebugUtils.currentLine=2293964;
 //BA.debugLineNum = 2293964;BA.debugLine="totalTarget.Text = total_count";
mostCurrent._totaltarget.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=2293965;
 //BA.debugLineNum = 2293965;BA.debugLine="totalTarget.Tag = target_id";
mostCurrent._totaltarget.setTag((Object)(_target_id));
RDebugUtils.currentLine=2293966;
 //BA.debugLineNum = 2293966;BA.debugLine="totalTarget.TextColor = Colors.Black";
mostCurrent._totaltarget.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293967;
 //BA.debugLineNum = 2293967;BA.debugLine="totalTarget.Color = Colors.White";
mostCurrent._totaltarget.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2293968;
 //BA.debugLineNum = 2293968;BA.debugLine="totalTarget.TextSize = primaryFontSize";
mostCurrent._totaltarget.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2293969;
 //BA.debugLineNum = 2293969;BA.debugLine="totalTarget.Gravity = Gravity.CENTER";
mostCurrent._totaltarget.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293970;
 //BA.debugLineNum = 2293970;BA.debugLine="totalTarget.Typeface = Typeface.SERIF";
mostCurrent._totaltarget.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2293971;
 //BA.debugLineNum = 2293971;BA.debugLine="Panel.AddView(totalTarget, 2dip, sale3Title.";
mostCurrent._panel.AddView((android.view.View)(mostCurrent._totaltarget.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_sale3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293973;
 //BA.debugLineNum = 2293973;BA.debugLine="Dim totalTargetTitle As Label";
_totaltargettitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293974;
 //BA.debugLineNum = 2293974;BA.debugLine="totalTargetTitle.Initialize(\"totalTargetTitl";
_totaltargettitle.Initialize(mostCurrent.activityBA,"totalTargetTitles");
RDebugUtils.currentLine=2293975;
 //BA.debugLineNum = 2293975;BA.debugLine="totalTargetTitle.Text = \" Total Target\"";
_totaltargettitle.setText(BA.ObjectToCharSequence(" Total Target"));
RDebugUtils.currentLine=2293976;
 //BA.debugLineNum = 2293976;BA.debugLine="totalTargetTitle.Tag = 20";
_totaltargettitle.setTag((Object)(20));
RDebugUtils.currentLine=2293977;
 //BA.debugLineNum = 2293977;BA.debugLine="totalTargetTitle.TextColor = Colors.Gray";
_totaltargettitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2293978;
 //BA.debugLineNum = 2293978;BA.debugLine="totalTargetTitle.TextSize = secondaryFontSiz";
_totaltargettitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2293979;
 //BA.debugLineNum = 2293979;BA.debugLine="totalTargetTitle.Gravity = Gravity.CENTER";
_totaltargettitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293980;
 //BA.debugLineNum = 2293980;BA.debugLine="totalTargetTitle.Typeface = Typeface.MONOSPA";
_totaltargettitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2293981;
 //BA.debugLineNum = 2293981;BA.debugLine="totalTargetTitle.Text = totalTargetTitle.Tex";
_totaltargettitle.setText(BA.ObjectToCharSequence(_totaltargettitle.getText().toUpperCase()));
RDebugUtils.currentLine=2293982;
 //BA.debugLineNum = 2293982;BA.debugLine="Panel.AddView(totalTargetTitle, 0, totalTarg";
mostCurrent._panel.AddView((android.view.View)(_totaltargettitle.getObject()),(int) (0),(int) (mostCurrent._totaltarget.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293984;
 //BA.debugLineNum = 2293984;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293985;
 //BA.debugLineNum = 2293985;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293986;
 //BA.debugLineNum = 2293986;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=2293987;
 //BA.debugLineNum = 2293987;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2293988;
 //BA.debugLineNum = 2293988;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2293989;
 //BA.debugLineNum = 2293989;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293990;
 //BA.debugLineNum = 2293990;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2293991;
 //BA.debugLineNum = 2293991;BA.debugLine="Panel.AddView(totalPos, panelWidth, totalTar";
mostCurrent._panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,(int) (_totaltargettitle.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2293993;
 //BA.debugLineNum = 2293993;BA.debugLine="Dim totalPosTitle As Label";
_totalpostitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2293994;
 //BA.debugLineNum = 2293994;BA.debugLine="totalPosTitle.Initialize(\"\")";
_totalpostitle.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293995;
 //BA.debugLineNum = 2293995;BA.debugLine="totalPosTitle.Text = \" Total Pos\"";
_totalpostitle.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=2293996;
 //BA.debugLineNum = 2293996;BA.debugLine="totalPosTitle.TextColor = Colors.Gray";
_totalpostitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2293997;
 //BA.debugLineNum = 2293997;BA.debugLine="totalPosTitle.TextSize = secondaryFontSize";
_totalpostitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2293998;
 //BA.debugLineNum = 2293998;BA.debugLine="totalPosTitle.Gravity = Gravity.CENTER";
_totalpostitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2293999;
 //BA.debugLineNum = 2293999;BA.debugLine="totalPosTitle.Typeface = Typeface.MONOSPACE";
_totalpostitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2294000;
 //BA.debugLineNum = 2294000;BA.debugLine="totalPosTitle.Text = totalPosTitle.Text.ToUp";
_totalpostitle.setText(BA.ObjectToCharSequence(_totalpostitle.getText().toUpperCase()));
RDebugUtils.currentLine=2294001;
 //BA.debugLineNum = 2294001;BA.debugLine="Panel.AddView(totalPosTitle, panelWidth, tot";
mostCurrent._panel.AddView((android.view.View)(_totalpostitle.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2294003;
 //BA.debugLineNum = 2294003;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2294004;
 //BA.debugLineNum = 2294004;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 2dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (156),(int) (0),(int) (0)));
RDebugUtils.currentLine=2294005;
 //BA.debugLineNum = 2294005;BA.debugLine="Panel.Background = cd";
mostCurrent._panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2294007;
 //BA.debugLineNum = 2294007;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=2294008;
 //BA.debugLineNum = 2294008;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
RDebugUtils.currentLine=2294009;
 //BA.debugLineNum = 2294009;BA.debugLine="If count Mod numColumns = 0 Then";
if (_count%_numcolumns==0) { 
RDebugUtils.currentLine=2294010;
 //BA.debugLineNum = 2294010;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2294011;
 //BA.debugLineNum = 2294011;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
_topposition = (int) (_topposition+_pnlheight+_padding);
 }else {
RDebugUtils.currentLine=2294013;
 //BA.debugLineNum = 2294013;BA.debugLine="leftPosition = leftPosition + pnlWidth + p";
_leftposition = (int) (_leftposition+_pnlwidth+_padding);
 };
RDebugUtils.currentLine=2294015;
 //BA.debugLineNum = 2294015;BA.debugLine="scrollHeight = scrollHeight + 175dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (175)));
 }else {
RDebugUtils.currentLine=2294017;
 //BA.debugLineNum = 2294017;BA.debugLine="topPosition = topPosition + pnlHeight + pad";
_topposition = (int) (_topposition+_pnlheight+_padding);
RDebugUtils.currentLine=2294018;
 //BA.debugLineNum = 2294018;BA.debugLine="scrollHeight = scrollHeight + 290dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (290)));
 };
 }
};
RDebugUtils.currentLine=2294022;
 //BA.debugLineNum = 2294022;BA.debugLine="scrollViewPanel4.Panel.Height = scrollHeight";
mostCurrent._scrollviewpanel4.getPanel().setHeight(_scrollheight);
RDebugUtils.currentLine=2294023;
 //BA.debugLineNum = 2294023;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break; }
case 1: {
RDebugUtils.currentLine=2294025;
 //BA.debugLineNum = 2294025;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2294026;
 //BA.debugLineNum = 2294026;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
case 2: {
RDebugUtils.currentLine=2294029;
 //BA.debugLineNum = 2294029;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=2294030;
 //BA.debugLineNum = 2294030;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=2294031;
 //BA.debugLineNum = 2294031;BA.debugLine="Log(\"No branch data returned\")";
anywheresoftware.b4a.keywords.Common.LogImpl("72294031","No branch data returned",0);
RDebugUtils.currentLine=2294032;
 //BA.debugLineNum = 2294032;BA.debugLine="ToastMessageShow(\"No branch data available\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No branch data available"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2294033;
 //BA.debugLineNum = 2294033;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2294037;
 //BA.debugLineNum = 2294037;BA.debugLine="Dim totalBranches As Int = salesArray.Size";
_totalbranches = _salesarray.getSize();
RDebugUtils.currentLine=2294038;
 //BA.debugLineNum = 2294038;BA.debugLine="Dim branchNames(totalBranches) As String";
_branchnames = new String[_totalbranches];
java.util.Arrays.fill(_branchnames,"");
RDebugUtils.currentLine=2294039;
 //BA.debugLineNum = 2294039;BA.debugLine="Dim branchSales1(totalBranches) As Int";
_branchsales1 = new int[_totalbranches];
;
RDebugUtils.currentLine=2294040;
 //BA.debugLineNum = 2294040;BA.debugLine="Dim branchSales2(totalBranches) As Int";
_branchsales2 = new int[_totalbranches];
;
RDebugUtils.currentLine=2294041;
 //BA.debugLineNum = 2294041;BA.debugLine="Dim branchSales3(totalBranches) As Int";
_branchsales3 = new int[_totalbranches];
;
RDebugUtils.currentLine=2294042;
 //BA.debugLineNum = 2294042;BA.debugLine="Dim branchCount As Int = 0";
_branchcount = (int) (0);
RDebugUtils.currentLine=2294045;
 //BA.debugLineNum = 2294045;BA.debugLine="For i = 0 To totalBranches - 1";
{
final int step251 = 1;
final int limit251 = (int) (_totalbranches-1);
_i = (int) (0) ;
for (;_i <= limit251 ;_i = _i + step251 ) {
RDebugUtils.currentLine=2294046;
 //BA.debugLineNum = 2294046;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=2294047;
 //BA.debugLineNum = 2294047;BA.debugLine="branchNames(i) = record.GetDefault(\"branch_n";
_branchnames[_i] = BA.ObjectToString(_record.GetDefault((Object)("branch_name"),(Object)("Unknown")));
RDebugUtils.currentLine=2294048;
 //BA.debugLineNum = 2294048;BA.debugLine="branchSales1(i) = record.GetDefault(\"sales_1";
_branchsales1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_1"),(Object)(0))));
RDebugUtils.currentLine=2294049;
 //BA.debugLineNum = 2294049;BA.debugLine="branchSales2(i) = record.GetDefault(\"sales_2";
_branchsales2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_2"),(Object)(0))));
RDebugUtils.currentLine=2294050;
 //BA.debugLineNum = 2294050;BA.debugLine="branchSales3(i) = record.GetDefault(\"sales_3";
_branchsales3[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_3"),(Object)(0))));
RDebugUtils.currentLine=2294051;
 //BA.debugLineNum = 2294051;BA.debugLine="branchCount = record.GetDefault(\"total_branc";
_branchcount = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("total_branch_count"),(Object)(0))));
 }
};
RDebugUtils.currentLine=2294053;
 //BA.debugLineNum = 2294053;BA.debugLine="Log($\"branchCount:${branchCount}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("72294053",("branchCount:"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_branchcount))+""),0);
RDebugUtils.currentLine=2294055;
 //BA.debugLineNum = 2294055;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
_legend = new String[]{"Sales 1","Sales 2","Sales 3"};
RDebugUtils.currentLine=2294058;
 //BA.debugLineNum = 2294058;BA.debugLine="purchasePanel.RemoveAllViews";
mostCurrent._purchasepanel.RemoveAllViews();
RDebugUtils.currentLine=2294061;
 //BA.debugLineNum = 2294061;BA.debugLine="If barGraphInitialized = False Then";
if (_bargraphinitialized==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2294062;
 //BA.debugLineNum = 2294062;BA.debugLine="nxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._nxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=2294063;
 //BA.debugLineNum = 2294063;BA.debugLine="backbtn.Initialize(\"backbtn\")";
mostCurrent._backbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=2294064;
 //BA.debugLineNum = 2294064;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
mostCurrent._sortbtn1.Initialize(mostCurrent.activityBA,"sortBtn1");
RDebugUtils.currentLine=2294065;
 //BA.debugLineNum = 2294065;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
mostCurrent._sortbtn2.Initialize(mostCurrent.activityBA,"sortBtn2");
RDebugUtils.currentLine=2294066;
 //BA.debugLineNum = 2294066;BA.debugLine="defBtn.Initialize(\"defBtn\")";
mostCurrent._defbtn.Initialize(mostCurrent.activityBA,"defBtn");
RDebugUtils.currentLine=2294067;
 //BA.debugLineNum = 2294067;BA.debugLine="salesBtn1.Initialize(\"salesBtn1\")";
mostCurrent._salesbtn1.Initialize(mostCurrent.activityBA,"salesBtn1");
RDebugUtils.currentLine=2294068;
 //BA.debugLineNum = 2294068;BA.debugLine="salesBtn2.Initialize(\"salesBtn2\")";
mostCurrent._salesbtn2.Initialize(mostCurrent.activityBA,"salesBtn2");
RDebugUtils.currentLine=2294069;
 //BA.debugLineNum = 2294069;BA.debugLine="salesBtn3.Initialize(\"salesBtn3\")";
mostCurrent._salesbtn3.Initialize(mostCurrent.activityBA,"salesBtn3");
RDebugUtils.currentLine=2294071;
 //BA.debugLineNum = 2294071;BA.debugLine="barGraph.Initialize(Activity, purchasePanel,";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_branchsales1,_branchsales2,_branchsales3,_branchnames,_legend,(int) (10000),"Sales Per Branch",_branchsales1,"Branch",mostCurrent._nxtbtn,mostCurrent._backbtn,mostCurrent._sortbtn1,mostCurrent._sortbtn2,mostCurrent._defbtn,mostCurrent._salesbtn1,mostCurrent._salesbtn2,mostCurrent._salesbtn3);
RDebugUtils.currentLine=2294072;
 //BA.debugLineNum = 2294072;BA.debugLine="barGraph.totalPages = branchCount / 5";
mostCurrent._bargraph._totalpages /*int*/  = (int) (_branchcount/(double)5);
RDebugUtils.currentLine=2294073;
 //BA.debugLineNum = 2294073;BA.debugLine="barGraph.UpdateGraph";
mostCurrent._bargraph._updategraph /*String*/ (null);
RDebugUtils.currentLine=2294074;
 //BA.debugLineNum = 2294074;BA.debugLine="barGraphInitialized = True";
_bargraphinitialized = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2294075;
 //BA.debugLineNum = 2294075;BA.debugLine="Log(\"Bar graph initialized\")";
anywheresoftware.b4a.keywords.Common.LogImpl("72294075","Bar graph initialized",0);
 }else {
RDebugUtils.currentLine=2294078;
 //BA.debugLineNum = 2294078;BA.debugLine="Dim totalPage As Int = 5 / branchCount";
_totalpage = (int) (5/(double)_branchcount);
RDebugUtils.currentLine=2294080;
 //BA.debugLineNum = 2294080;BA.debugLine="barGraph.pageNo = currentPage";
mostCurrent._bargraph._pageno /*int*/  = _currentpage;
RDebugUtils.currentLine=2294081;
 //BA.debugLineNum = 2294081;BA.debugLine="barGraph.sale_1 = branchSales1";
mostCurrent._bargraph._sale_1 /*int[]*/  = _branchsales1;
RDebugUtils.currentLine=2294082;
 //BA.debugLineNum = 2294082;BA.debugLine="barGraph.sale_2 = branchSales2";
mostCurrent._bargraph._sale_2 /*int[]*/  = _branchsales2;
RDebugUtils.currentLine=2294083;
 //BA.debugLineNum = 2294083;BA.debugLine="barGraph.sale_3 = branchSales3";
mostCurrent._bargraph._sale_3 /*int[]*/  = _branchsales3;
RDebugUtils.currentLine=2294084;
 //BA.debugLineNum = 2294084;BA.debugLine="barGraph.product1 = branchNames";
mostCurrent._bargraph._product1 /*String[]*/  = _branchnames;
RDebugUtils.currentLine=2294085;
 //BA.debugLineNum = 2294085;BA.debugLine="barGraph.comId1 = branchSales1 ' Assuming th";
mostCurrent._bargraph._comid1 /*int[]*/  = _branchsales1;
RDebugUtils.currentLine=2294087;
 //BA.debugLineNum = 2294087;BA.debugLine="barGraph.UpdateGraph";
mostCurrent._bargraph._updategraph /*String*/ (null);
RDebugUtils.currentLine=2294088;
 //BA.debugLineNum = 2294088;BA.debugLine="Log(\"Bar graph updated\")";
anywheresoftware.b4a.keywords.Common.LogImpl("72294088","Bar graph updated",0);
 };
RDebugUtils.currentLine=2294092;
 //BA.debugLineNum = 2294092;BA.debugLine="backbtn.Enabled = currentPage > 1";
mostCurrent._backbtn.setEnabled(_currentpage>1);
RDebugUtils.currentLine=2294093;
 //BA.debugLineNum = 2294093;BA.debugLine="nxtBtn.Enabled = salesArray.Size > 0 ' Adjust";
mostCurrent._nxtbtn.setEnabled(_salesarray.getSize()>0);
 break; }
case 3: {
RDebugUtils.currentLine=2294096;
 //BA.debugLineNum = 2294096;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2294097;
 //BA.debugLineNum = 2294097;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=2294100;
 //BA.debugLineNum = 2294100;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("72294100","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e296) {
			processBA.setLastException(e296);RDebugUtils.currentLine=2294104;
 //BA.debugLineNum = 2294104;BA.debugLine="Log(\"Error parsing data: \" & LastException.Mess";
anywheresoftware.b4a.keywords.Common.LogImpl("72294104","Error parsing data: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
RDebugUtils.currentLine=2294105;
 //BA.debugLineNum = 2294105;BA.debugLine="ToastMessageShow(\"Error parsing graph data\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing graph data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=2294108;
 //BA.debugLineNum = 2294108;BA.debugLine="Log(\"Job failed: \" & job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("72294108","Job failed: "+_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=2294109;
 //BA.debugLineNum = 2294109;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2294112;
 //BA.debugLineNum = 2294112;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=2294113;
 //BA.debugLineNum = 2294113;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="branch_selected = selectedCompany";
_branch_selected = _selectedcompany;
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="StartActivity(\"Device\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Device"));
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="End Sub";
return "";
}
public static String  _nxtbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtbtn_click", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub nxtBtn_Click";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="currentPage = currentPage + 1";
_currentpage = (int) (_currentpage+1);
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Log(currentPage)";
anywheresoftware.b4a.keywords.Common.LogImpl("73014658",BA.NumberToString(_currentpage),0);
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="FetchNewPageData";
_fetchnewpagedata();
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn1_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn1_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub salesBtn1_Click";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
 };
RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("73342343",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
anywheresoftware.b4a.keywords.Common.LogImpl("73342344"," sales 1 Button clicked: "+_index,0);
RDebugUtils.currentLine=3342345;
 //BA.debugLineNum = 3342345;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn2_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn2_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub salesBtn2_Click";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
 };
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("73407879",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("73407880",_index,0);
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="Log(\"(Sale2)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("73407881","(Sale2)",0);
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn3_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn3_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub salesBtn3_Click";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
 };
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("73473415",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("73473417",_index,0);
RDebugUtils.currentLine=3473418;
 //BA.debugLineNum = 3473418;BA.debugLine="Log(\"(Sale3)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("73473418","(Sale3)",0);
RDebugUtils.currentLine=3473419;
 //BA.debugLineNum = 3473419;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn1_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn1_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub sortBtn1_Click";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="sortDefaultValue = index.ToLowerCase";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("73276805",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=3276806;
 //BA.debugLineNum = 3276806;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=3276807;
 //BA.debugLineNum = 3276807;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn2_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn2_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub sortBtn2_Click";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="sortDefaultValue = index.ToLowerCase";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("73211269",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="End Sub";
return "";
}
public static String  _totaltarget_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltarget_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltarget_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub totalTarget_Click";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Dim target_id_btn As Label = Sender";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="target_id_display.Text = target_id";
mostCurrent._target_id_display.setText(BA.ObjectToCharSequence(_target_id));
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="End Sub";
return "";
}
public static String  _totaltargettitle_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltargettitle_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltargettitle_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub totalTargetTitle_Click";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Dim target_id_btn As Label = Sender";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="End Sub";
return "";
}
}