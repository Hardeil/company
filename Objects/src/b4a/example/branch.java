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
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Activity.LoadLayout(\"Branch\")";
mostCurrent._activity.LoadLayout("Branch",mostCurrent.activityBA);
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5701638;
 //BA.debugLineNum = 5701638;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5701639;
 //BA.debugLineNum = 5701639;BA.debugLine="home.TextSize = 16";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=5701640;
 //BA.debugLineNum = 5701640;BA.debugLine="Panel3.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=5701641;
 //BA.debugLineNum = 5701641;BA.debugLine="Panel3.Color = Colors.Transparent";
mostCurrent._panel3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=5701643;
 //BA.debugLineNum = 5701643;BA.debugLine="branches.Initialize(\"\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5701644;
 //BA.debugLineNum = 5701644;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=5701645;
 //BA.debugLineNum = 5701645;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5701646;
 //BA.debugLineNum = 5701646;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=5701647;
 //BA.debugLineNum = 5701647;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=5701648;
 //BA.debugLineNum = 5701648;BA.debugLine="Panel3.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=5701650;
 //BA.debugLineNum = 5701650;BA.debugLine="popupPanel.Initialize(\"\")";
mostCurrent._popuppanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5701651;
 //BA.debugLineNum = 5701651;BA.debugLine="popupPanel.Color = Colors.ARGB(200, 0, 0, 0)";
mostCurrent._popuppanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (200),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=5701652;
 //BA.debugLineNum = 5701652;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5701653;
 //BA.debugLineNum = 5701653;BA.debugLine="Activity.AddView(popupPanel, 0, 0, Activity.Width";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._popuppanel.getObject()),(int) (0),(int) (0),mostCurrent._activity.getWidth(),mostCurrent._activity.getHeight());
RDebugUtils.currentLine=5701655;
 //BA.debugLineNum = 5701655;BA.debugLine="Dim popupPanelBackground As Panel";
_popuppanelbackground = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5701656;
 //BA.debugLineNum = 5701656;BA.debugLine="popupPanelBackground.Initialize(\"\")";
_popuppanelbackground.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5701657;
 //BA.debugLineNum = 5701657;BA.debugLine="popupPanelBackground.Color = Colors.White";
_popuppanelbackground.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=5701658;
 //BA.debugLineNum = 5701658;BA.debugLine="popupPanel.AddView(popupPanelBackground, 70dip, 5";
mostCurrent._popuppanel.AddView((android.view.View)(_popuppanelbackground.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (550)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500))));
RDebugUtils.currentLine=5701659;
 //BA.debugLineNum = 5701659;BA.debugLine="Dim leftPosition As Int = (popupPanel.Width - pop";
_leftposition = (int) ((mostCurrent._popuppanel.getWidth()-_popuppanelbackground.getWidth())/(double)2);
RDebugUtils.currentLine=5701660;
 //BA.debugLineNum = 5701660;BA.debugLine="popupPanelBackground.Left = leftPosition";
_popuppanelbackground.setLeft(_leftposition);
RDebugUtils.currentLine=5701662;
 //BA.debugLineNum = 5701662;BA.debugLine="Dim closeButton As Label";
_closebutton = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5701663;
 //BA.debugLineNum = 5701663;BA.debugLine="closeButton.Initialize(\"closeButton\")";
_closebutton.Initialize(mostCurrent.activityBA,"closeButton");
RDebugUtils.currentLine=5701664;
 //BA.debugLineNum = 5701664;BA.debugLine="closeButton.Text = \"X\"";
_closebutton.setText(BA.ObjectToCharSequence("X"));
RDebugUtils.currentLine=5701665;
 //BA.debugLineNum = 5701665;BA.debugLine="closeButton.TextSize = 20";
_closebutton.setTextSize((float) (20));
RDebugUtils.currentLine=5701666;
 //BA.debugLineNum = 5701666;BA.debugLine="closeButton.TextColor = Colors.Red";
_closebutton.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=5701667;
 //BA.debugLineNum = 5701667;BA.debugLine="closeButton.Typeface = Typeface.DEFAULT_BOLD";
_closebutton.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=5701668;
 //BA.debugLineNum = 5701668;BA.debugLine="popupPanelBackground.AddView(closeButton, popupPa";
_popuppanelbackground.AddView((android.view.View)(_closebutton.getObject()),(int) (_popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701670;
 //BA.debugLineNum = 5701670;BA.debugLine="target_id_display.Initialize(\"target_id_display\")";
mostCurrent._target_id_display.Initialize(mostCurrent.activityBA,"target_id_display");
RDebugUtils.currentLine=5701671;
 //BA.debugLineNum = 5701671;BA.debugLine="target_id_display.TextSize = 20";
mostCurrent._target_id_display.setTextSize((float) (20));
RDebugUtils.currentLine=5701672;
 //BA.debugLineNum = 5701672;BA.debugLine="target_id_display.TextColor = Colors.Red";
mostCurrent._target_id_display.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=5701673;
 //BA.debugLineNum = 5701673;BA.debugLine="target_id_display.Typeface = Typeface.DEFAULT_BOL";
mostCurrent._target_id_display.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=5701674;
 //BA.debugLineNum = 5701674;BA.debugLine="popupPanelBackground.AddView(target_id_display, p";
_popuppanelbackground.AddView((android.view.View)(mostCurrent._target_id_display.getObject()),(int) (_popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701676;
 //BA.debugLineNum = 5701676;BA.debugLine="Dim popupText As Label";
_popuptext = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5701677;
 //BA.debugLineNum = 5701677;BA.debugLine="popupText.Initialize(\"\")";
_popuptext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5701678;
 //BA.debugLineNum = 5701678;BA.debugLine="popupText.Text = \"Edit Target\"";
_popuptext.setText(BA.ObjectToCharSequence("Edit Target"));
RDebugUtils.currentLine=5701679;
 //BA.debugLineNum = 5701679;BA.debugLine="popupText.TextColor = Colors.Black";
_popuptext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5701680;
 //BA.debugLineNum = 5701680;BA.debugLine="popupText.TextSize = 58";
_popuptext.setTextSize((float) (58));
RDebugUtils.currentLine=5701681;
 //BA.debugLineNum = 5701681;BA.debugLine="popupText.Gravity = Gravity.CENTER";
_popuptext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5701682;
 //BA.debugLineNum = 5701682;BA.debugLine="popupPanelBackground.AddView(popupText, 25dip, 10";
_popuppanelbackground.AddView((android.view.View)(_popuptext.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5701684;
 //BA.debugLineNum = 5701684;BA.debugLine="target_countLabel.Initialize(\"\")";
mostCurrent._target_countlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5701685;
 //BA.debugLineNum = 5701685;BA.debugLine="target_countLabel.TextColor = Colors.Black";
mostCurrent._target_countlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5701686;
 //BA.debugLineNum = 5701686;BA.debugLine="target_countLabel.TextSize = 58";
mostCurrent._target_countlabel.setTextSize((float) (58));
RDebugUtils.currentLine=5701687;
 //BA.debugLineNum = 5701687;BA.debugLine="target_countLabel.Gravity = Gravity.CENTER";
mostCurrent._target_countlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5701688;
 //BA.debugLineNum = 5701688;BA.debugLine="popupPanelBackground.AddView(target_countLabel, 2";
_popuppanelbackground.AddView((android.view.View)(mostCurrent._target_countlabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5701689;
 //BA.debugLineNum = 5701689;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
RDebugUtils.currentLine=5701691;
 //BA.debugLineNum = 5701691;BA.debugLine="Dim edit_button As Button";
_edit_button = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=5701692;
 //BA.debugLineNum = 5701692;BA.debugLine="edit_button.Initialize(\"edit_button\")";
_edit_button.Initialize(mostCurrent.activityBA,"edit_button");
RDebugUtils.currentLine=5701693;
 //BA.debugLineNum = 5701693;BA.debugLine="edit_button.Text = \"Update\"";
_edit_button.setText(BA.ObjectToCharSequence("Update"));
RDebugUtils.currentLine=5701694;
 //BA.debugLineNum = 5701694;BA.debugLine="edit_button.TextColor = Colors.Black";
_edit_button.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5701695;
 //BA.debugLineNum = 5701695;BA.debugLine="edit_button.TextSize = 58";
_edit_button.setTextSize((float) (58));
RDebugUtils.currentLine=5701696;
 //BA.debugLineNum = 5701696;BA.debugLine="edit_button.Gravity = Gravity.CENTER";
_edit_button.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5701697;
 //BA.debugLineNum = 5701697;BA.debugLine="popupPanelBackground.AddView(edit_button, 25dip,";
_popuppanelbackground.AddView((android.view.View)(_edit_button.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5701699;
 //BA.debugLineNum = 5701699;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5701700;
 //BA.debugLineNum = 5701700;BA.debugLine="Panel4.AddView(purchasePanel, 0, 0dip, Activity.W";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (430)));
RDebugUtils.currentLine=5701702;
 //BA.debugLineNum = 5701702;BA.debugLine="scrollViewPanel4.Initialize(Panel4.Height - purch";
mostCurrent._scrollviewpanel4.Initialize(mostCurrent.activityBA,(int) (mostCurrent._panel4.getHeight()-mostCurrent._purchasepanel.getHeight()));
RDebugUtils.currentLine=5701703;
 //BA.debugLineNum = 5701703;BA.debugLine="Panel4.AddView(scrollViewPanel4,0,purchasePanel.H";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._scrollviewpanel4.getObject()),(int) (0),mostCurrent._purchasepanel.getHeight(),mostCurrent._panel4.getWidth(),(int) (mostCurrent._panel4.getHeight()-mostCurrent._purchasepanel.getHeight()));
RDebugUtils.currentLine=5701705;
 //BA.debugLineNum = 5701705;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=5701706;
 //BA.debugLineNum = 5701706;BA.debugLine="LoadCompanyData1";
_loadcompanydata1();
RDebugUtils.currentLine=5701707;
 //BA.debugLineNum = 5701707;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="totalTarget.Initialize(\"\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="Panel.Initialize(\"\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="Panel.RemoveAllViews";
mostCurrent._panel.RemoveAllViews();
RDebugUtils.currentLine=5832710;
 //BA.debugLineNum = 5832710;BA.debugLine="PHPURL = \"https://192.168.8.117/Company/branch.ph";
mostCurrent._phpurl = "https://192.168.8.117/Company/branch.php?action=get_branch&company_id="+mostCurrent._starter._company_selected /*String*/ ;
RDebugUtils.currentLine=5832711;
 //BA.debugLineNum = 5832711;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",branch.getObject());
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=5832714;
 //BA.debugLineNum = 5832714;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydata1() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata1", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub LoadCompanyData1";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="Job1.Initialize(\"GetBranches\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetBranches",branch.getObject());
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="PHPURL1 = $\"https://192.168.8.117/Company/compan";
mostCurrent._phpurl1 = ("https://192.168.8.117/Company/company.php?action=get_company_list&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"");
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="Log(PHPURL1)";
anywheresoftware.b4a.keywords.Common.LogImpl("35767172",mostCurrent._phpurl1,0);
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="Job1.Download(PHPURL1)";
_job1._download /*String*/ (null,mostCurrent._phpurl1);
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="If barGraphInitialized = False Then";
if (_bargraphinitialized==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
 };
RDebugUtils.currentLine=5767177;
 //BA.debugLineNum = 5767177;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="branch";
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub backbtn_Click";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="currentPage = currentPage - 1";
_currentpage = (int) (_currentpage-1);
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="FetchNewPageData";
_fetchnewpagedata();
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="End Sub";
return "";
}
public static String  _fetchnewpagedata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fetchnewpagedata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fetchnewpagedata", null));}
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub FetchNewPageData";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="LoadCompanyData1 ' Fetch new data for the current";
_loadcompanydata1();
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="End Sub";
return "";
}
public static String  _closebutton_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closebutton_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closebutton_click", null));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub closeButton_Click";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="End Sub";
return "";
}
public static String  _edit_button_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edit_button_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edit_button_click", null));}
int _target_id = 0;
int _new_value = 0;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub edit_button_Click";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Dim target_id As Int = target_id_display.Text";
_target_id = (int)(Double.parseDouble(mostCurrent._target_id_display.getText()));
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="Dim new_value As Int = target_countLabel.Text";
_new_value = (int)(Double.parseDouble(mostCurrent._target_countlabel.getText()));
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_target_id)) && anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_new_value))) { 
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="UpdateData_Remote(target_id, new_value)";
_updatedata_remote(_target_id,_new_value);
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 }else {
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="Log(\"Invalid input values\")";
anywheresoftware.b4a.keywords.Common.LogImpl("36094856","Invalid input values",0);
 };
RDebugUtils.currentLine=6094858;
 //BA.debugLineNum = 6094858;BA.debugLine="End Sub";
return "";
}
public static String  _updatedata_remote(int _target_id,int _new_value) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatedata_remote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updatedata_remote", new Object[] {_target_id,_new_value}));}
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.141/Co";
mostCurrent._phpurl = ("https://192.168.8.141/Company/fetch.php?action=target_update&id="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_target_id))+"&value="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_new_value))+"");
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
_job._initialize /*String*/ (null,processBA,"UpdateData",branch.getObject());
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="job.Download(PHPURL)";
_job._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="Try";
try {RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","UpdateData","GetBranches")) {
case 0: {
RDebugUtils.currentLine=5963787;
 //BA.debugLineNum = 5963787;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=5963788;
 //BA.debugLineNum = 5963788;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=5963789;
 //BA.debugLineNum = 5963789;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
_numcolumns = (int) (2);
RDebugUtils.currentLine=5963790;
 //BA.debugLineNum = 5963790;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
_pnlwidth = (int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5963791;
 //BA.debugLineNum = 5963791;BA.debugLine="Dim pnlHeight As Int = 280dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280));
RDebugUtils.currentLine=5963792;
 //BA.debugLineNum = 5963792;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=5963793;
 //BA.debugLineNum = 5963793;BA.debugLine="Dim leftPosition As Int = 50dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=5963794;
 //BA.debugLineNum = 5963794;BA.debugLine="Dim topPosition As Int = 0";
_topposition = (int) (0);
RDebugUtils.currentLine=5963795;
 //BA.debugLineNum = 5963795;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=5963796;
 //BA.debugLineNum = 5963796;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=5963797;
 //BA.debugLineNum = 5963797;BA.debugLine="pnlWidth = 490dip";
_pnlwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (490));
RDebugUtils.currentLine=5963798;
 //BA.debugLineNum = 5963798;BA.debugLine="pnlHeight = 300dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300));
RDebugUtils.currentLine=5963799;
 //BA.debugLineNum = 5963799;BA.debugLine="padding = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=5963800;
 //BA.debugLineNum = 5963800;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 };
RDebugUtils.currentLine=5963802;
 //BA.debugLineNum = 5963802;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group23 = mostCurrent._tabledetails;
final int groupLen23 = group23.getSize()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group23.Get(index23)));
RDebugUtils.currentLine=5963803;
 //BA.debugLineNum = 5963803;BA.debugLine="Dim companyName As String = record.Get(\"comp";
_companyname = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=5963804;
 //BA.debugLineNum = 5963804;BA.debugLine="Dim id As String = record.Get(\"id\")";
_id = BA.ObjectToString(_record.Get((Object)("id")));
RDebugUtils.currentLine=5963805;
 //BA.debugLineNum = 5963805;BA.debugLine="Dim name As String = record.Get(\"branch_name";
_name = BA.ObjectToString(_record.Get((Object)("branch_name")));
RDebugUtils.currentLine=5963806;
 //BA.debugLineNum = 5963806;BA.debugLine="Dim total_count As Int = record.Get(\"target_";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("target_no"))));
RDebugUtils.currentLine=5963807;
 //BA.debugLineNum = 5963807;BA.debugLine="Dim total_pos As Int = record.Get(\"total_dev";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("total_device"))));
RDebugUtils.currentLine=5963808;
 //BA.debugLineNum = 5963808;BA.debugLine="Dim totalPur1 As String = record.Get(\"purcha";
_totalpur1 = BA.ObjectToString(_record.Get((Object)("purchase_1")));
RDebugUtils.currentLine=5963809;
 //BA.debugLineNum = 5963809;BA.debugLine="Dim totalPur2 As String = record.Get(\"purcha";
_totalpur2 = BA.ObjectToString(_record.Get((Object)("purchase_2")));
RDebugUtils.currentLine=5963810;
 //BA.debugLineNum = 5963810;BA.debugLine="Dim totalPur3 As String = record.Get(\"purcha";
_totalpur3 = BA.ObjectToString(_record.Get((Object)("purchase_3")));
RDebugUtils.currentLine=5963811;
 //BA.debugLineNum = 5963811;BA.debugLine="Dim totalSales1 As String = record.Get(\"tota";
_totalsales1 = BA.ObjectToString(_record.Get((Object)("total_sales1")));
RDebugUtils.currentLine=5963812;
 //BA.debugLineNum = 5963812;BA.debugLine="Dim totalSales2 As String = record.Get(\"tota";
_totalsales2 = BA.ObjectToString(_record.Get((Object)("total_sales2")));
RDebugUtils.currentLine=5963813;
 //BA.debugLineNum = 5963813;BA.debugLine="Dim totalSales3 As String = record.Get(\"tota";
_totalsales3 = BA.ObjectToString(_record.Get((Object)("total_sales3")));
RDebugUtils.currentLine=5963814;
 //BA.debugLineNum = 5963814;BA.debugLine="Dim target_id As String = record.Get(\"branch";
_target_id = BA.ObjectToString(_record.Get((Object)("branch_target_id")));
RDebugUtils.currentLine=5963815;
 //BA.debugLineNum = 5963815;BA.debugLine="totalSales = totalSales1.Length";
_totalsales = _totalsales1.length();
RDebugUtils.currentLine=5963816;
 //BA.debugLineNum = 5963816;BA.debugLine="target_countLabel.Text = total_count";
mostCurrent._target_countlabel.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=5963817;
 //BA.debugLineNum = 5963817;BA.debugLine="branches.Text = \"Branches - \" & companyName";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_companyname));
RDebugUtils.currentLine=5963818;
 //BA.debugLineNum = 5963818;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=5963820;
 //BA.debugLineNum = 5963820;BA.debugLine="LabelTitle.Text = companyName";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_companyname));
RDebugUtils.currentLine=5963821;
 //BA.debugLineNum = 5963821;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCas";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=5963822;
 //BA.debugLineNum = 5963822;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
mostCurrent._labeltitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963824;
 //BA.debugLineNum = 5963824;BA.debugLine="Panel.Initialize(\"Panel\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=5963825;
 //BA.debugLineNum = 5963825;BA.debugLine="scrollViewPanel4.Panel.AddView(Panel, leftPo";
mostCurrent._scrollviewpanel4.getPanel().AddView((android.view.View)(mostCurrent._panel.getObject()),_leftposition,_topposition,_pnlwidth,_pnlheight);
RDebugUtils.currentLine=5963826;
 //BA.debugLineNum = 5963826;BA.debugLine="Panel.Color = Colors.Black";
mostCurrent._panel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5963828;
 //BA.debugLineNum = 5963828;BA.debugLine="Dim Panel2 As Panel";
_panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5963829;
 //BA.debugLineNum = 5963829;BA.debugLine="Panel2.Initialize(\"Panel2\")";
_panel2.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=5963830;
 //BA.debugLineNum = 5963830;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=5963831;
 //BA.debugLineNum = 5963831;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As I";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=5963832;
 //BA.debugLineNum = 5963832;BA.debugLine="Panel2.Background = gradient";
_panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=5963833;
 //BA.debugLineNum = 5963833;BA.debugLine="Panel2.Tag = name";
_panel2.setTag((Object)(_name));
RDebugUtils.currentLine=5963834;
 //BA.debugLineNum = 5963834;BA.debugLine="Panel2.SendToBack";
_panel2.SendToBack();
RDebugUtils.currentLine=5963835;
 //BA.debugLineNum = 5963835;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y";
mostCurrent._panel.AddView((android.view.View)(_panel2.getObject()),(int) (0),(int) (0),mostCurrent._panel.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=5963837;
 //BA.debugLineNum = 5963837;BA.debugLine="Dim BranchNameLabel As Label";
_branchnamelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963838;
 //BA.debugLineNum = 5963838;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
_branchnamelabel.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=5963839;
 //BA.debugLineNum = 5963839;BA.debugLine="BranchNameLabel.Text = name";
_branchnamelabel.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=5963840;
 //BA.debugLineNum = 5963840;BA.debugLine="BranchNameLabel.Tag = id";
_branchnamelabel.setTag((Object)(_id));
RDebugUtils.currentLine=5963841;
 //BA.debugLineNum = 5963841;BA.debugLine="BranchNameLabel.TextSize = 18";
_branchnamelabel.setTextSize((float) (18));
RDebugUtils.currentLine=5963842;
 //BA.debugLineNum = 5963842;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
_branchnamelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=5963843;
 //BA.debugLineNum = 5963843;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPAC";
_branchnamelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963844;
 //BA.debugLineNum = 5963844;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VER";
_branchnamelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=5963845;
 //BA.debugLineNum = 5963845;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip,";
_panel2.AddView((android.view.View)(_branchnamelabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panel2.getWidth(),_panel2.getHeight());
RDebugUtils.currentLine=5963847;
 //BA.debugLineNum = 5963847;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=5963848;
 //BA.debugLineNum = 5963848;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=5963849;
 //BA.debugLineNum = 5963849;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=5963850;
 //BA.debugLineNum = 5963850;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5963851;
 //BA.debugLineNum = 5963851;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=5963852;
 //BA.debugLineNum = 5963852;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963853;
 //BA.debugLineNum = 5963853;BA.debugLine="imgView.Bitmap = resizedImage";
_imgview.setBitmap((android.graphics.Bitmap)(_resizedimage.getObject()));
RDebugUtils.currentLine=5963854;
 //BA.debugLineNum = 5963854;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x,";
_panel2.AddView((android.view.View)(_imgview.getObject()),(int) (_panel2.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),_panel2.getHeight());
 }else {
RDebugUtils.currentLine=5963856;
 //BA.debugLineNum = 5963856;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("35963856","Error loading image",0);
 };
RDebugUtils.currentLine=5963859;
 //BA.debugLineNum = 5963859;BA.debugLine="Dim panelWidth As Int = Panel.Width / 3";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)3);
RDebugUtils.currentLine=5963860;
 //BA.debugLineNum = 5963860;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=5963861;
 //BA.debugLineNum = 5963861;BA.debugLine="Dim labelheight As Int = 35dip";
_labelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35));
RDebugUtils.currentLine=5963863;
 //BA.debugLineNum = 5963863;BA.debugLine="Dim purchase1 As Label";
_purchase1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963864;
 //BA.debugLineNum = 5963864;BA.debugLine="purchase1.Initialize(\"\")";
_purchase1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963865;
 //BA.debugLineNum = 5963865;BA.debugLine="purchase1.Text = totalPur1";
_purchase1.setText(BA.ObjectToCharSequence(_totalpur1));
RDebugUtils.currentLine=5963866;
 //BA.debugLineNum = 5963866;BA.debugLine="purchase1.TextColor = Colors.Black";
_purchase1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5963867;
 //BA.debugLineNum = 5963867;BA.debugLine="purchase1.TextSize = primaryFontSize";
_purchase1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=5963868;
 //BA.debugLineNum = 5963868;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
_purchase1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963869;
 //BA.debugLineNum = 5963869;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
_purchase1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=5963870;
 //BA.debugLineNum = 5963870;BA.debugLine="Panel.AddView(purchase1, 0, Panel2.Height +";
mostCurrent._panel.AddView((android.view.View)(_purchase1.getObject()),(int) (0),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963872;
 //BA.debugLineNum = 5963872;BA.debugLine="Dim purchase1Title As Label";
_purchase1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963873;
 //BA.debugLineNum = 5963873;BA.debugLine="purchase1Title.Initialize(\"\")";
_purchase1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963874;
 //BA.debugLineNum = 5963874;BA.debugLine="purchase1Title.Text = \"First Purchase\"";
_purchase1title.setText(BA.ObjectToCharSequence("First Purchase"));
RDebugUtils.currentLine=5963875;
 //BA.debugLineNum = 5963875;BA.debugLine="purchase1Title.TextColor = Colors.Gray";
_purchase1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=5963876;
 //BA.debugLineNum = 5963876;BA.debugLine="purchase1Title.TextSize = secondaryFontSize";
_purchase1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=5963877;
 //BA.debugLineNum = 5963877;BA.debugLine="purchase1Title.Gravity = Gravity.CENTER";
_purchase1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963878;
 //BA.debugLineNum = 5963878;BA.debugLine="purchase1Title.Typeface = Typeface.MONOSPACE";
_purchase1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963879;
 //BA.debugLineNum = 5963879;BA.debugLine="purchase1Title.Text = purchase1Title.Text.To";
_purchase1title.setText(BA.ObjectToCharSequence(_purchase1title.getText().toUpperCase()));
RDebugUtils.currentLine=5963880;
 //BA.debugLineNum = 5963880;BA.debugLine="Panel.AddView(purchase1Title, 0, purchase1.t";
mostCurrent._panel.AddView((android.view.View)(_purchase1title.getObject()),(int) (0),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963882;
 //BA.debugLineNum = 5963882;BA.debugLine="Dim purchase2 As Label";
_purchase2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963883;
 //BA.debugLineNum = 5963883;BA.debugLine="purchase2.Initialize(\"\")";
_purchase2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963884;
 //BA.debugLineNum = 5963884;BA.debugLine="purchase2.Text = totalPur2";
_purchase2.setText(BA.ObjectToCharSequence(_totalpur2));
RDebugUtils.currentLine=5963885;
 //BA.debugLineNum = 5963885;BA.debugLine="purchase2.TextColor = Colors.Black";
_purchase2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5963886;
 //BA.debugLineNum = 5963886;BA.debugLine="purchase2.TextSize = primaryFontSize";
_purchase2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=5963887;
 //BA.debugLineNum = 5963887;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
_purchase2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963888;
 //BA.debugLineNum = 5963888;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
_purchase2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=5963889;
 //BA.debugLineNum = 5963889;BA.debugLine="Panel.AddView(purchase2, panelWidth, Panel2.";
mostCurrent._panel.AddView((android.view.View)(_purchase2.getObject()),_panelwidth,(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963891;
 //BA.debugLineNum = 5963891;BA.debugLine="Dim purchase2Title As Label";
_purchase2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963892;
 //BA.debugLineNum = 5963892;BA.debugLine="purchase2Title.Initialize(\"\")";
_purchase2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963893;
 //BA.debugLineNum = 5963893;BA.debugLine="purchase2Title.Text = \"Second Purchase\"";
_purchase2title.setText(BA.ObjectToCharSequence("Second Purchase"));
RDebugUtils.currentLine=5963894;
 //BA.debugLineNum = 5963894;BA.debugLine="purchase2Title.TextColor = Colors.Gray";
_purchase2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=5963895;
 //BA.debugLineNum = 5963895;BA.debugLine="purchase2Title.TextSize = secondaryFontSize";
_purchase2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=5963896;
 //BA.debugLineNum = 5963896;BA.debugLine="purchase2Title.Gravity = Gravity.CENTER";
_purchase2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963897;
 //BA.debugLineNum = 5963897;BA.debugLine="purchase2Title.Typeface = Typeface.MONOSPACE";
_purchase2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963898;
 //BA.debugLineNum = 5963898;BA.debugLine="purchase2Title.Text = purchase2Title.Text.To";
_purchase2title.setText(BA.ObjectToCharSequence(_purchase2title.getText().toUpperCase()));
RDebugUtils.currentLine=5963899;
 //BA.debugLineNum = 5963899;BA.debugLine="Panel.AddView(purchase2Title, panelWidth, pu";
mostCurrent._panel.AddView((android.view.View)(_purchase2title.getObject()),_panelwidth,(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963901;
 //BA.debugLineNum = 5963901;BA.debugLine="Dim purchase3 As Label";
_purchase3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963902;
 //BA.debugLineNum = 5963902;BA.debugLine="purchase3.Initialize(\"\")";
_purchase3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963903;
 //BA.debugLineNum = 5963903;BA.debugLine="purchase3.Text = totalPur3";
_purchase3.setText(BA.ObjectToCharSequence(_totalpur3));
RDebugUtils.currentLine=5963904;
 //BA.debugLineNum = 5963904;BA.debugLine="purchase3.TextColor = Colors.Black";
_purchase3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5963905;
 //BA.debugLineNum = 5963905;BA.debugLine="purchase3.TextSize = primaryFontSize";
_purchase3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=5963906;
 //BA.debugLineNum = 5963906;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
_purchase3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963907;
 //BA.debugLineNum = 5963907;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
_purchase3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=5963908;
 //BA.debugLineNum = 5963908;BA.debugLine="Panel.AddView(purchase3, panelWidth * 2, Pan";
mostCurrent._panel.AddView((android.view.View)(_purchase3.getObject()),(int) (_panelwidth*2),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963910;
 //BA.debugLineNum = 5963910;BA.debugLine="Dim purchase3Title As Label";
_purchase3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963911;
 //BA.debugLineNum = 5963911;BA.debugLine="purchase3Title.Initialize(\"\")";
_purchase3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963912;
 //BA.debugLineNum = 5963912;BA.debugLine="purchase3Title.Text = \"Third Purchase\"";
_purchase3title.setText(BA.ObjectToCharSequence("Third Purchase"));
RDebugUtils.currentLine=5963913;
 //BA.debugLineNum = 5963913;BA.debugLine="purchase3Title.TextColor = Colors.Gray";
_purchase3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=5963914;
 //BA.debugLineNum = 5963914;BA.debugLine="purchase3Title.TextSize = secondaryFontSize";
_purchase3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=5963915;
 //BA.debugLineNum = 5963915;BA.debugLine="purchase3Title.Gravity = Gravity.CENTER";
_purchase3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963916;
 //BA.debugLineNum = 5963916;BA.debugLine="purchase3Title.Typeface = Typeface.MONOSPACE";
_purchase3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963917;
 //BA.debugLineNum = 5963917;BA.debugLine="purchase3Title.Text = purchase3Title.Text.To";
_purchase3title.setText(BA.ObjectToCharSequence(_purchase3title.getText().toUpperCase()));
RDebugUtils.currentLine=5963918;
 //BA.debugLineNum = 5963918;BA.debugLine="Panel.AddView(purchase3Title, panelWidth * 2";
mostCurrent._panel.AddView((android.view.View)(_purchase3title.getObject()),(int) (_panelwidth*2),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963920;
 //BA.debugLineNum = 5963920;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963921;
 //BA.debugLineNum = 5963921;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963922;
 //BA.debugLineNum = 5963922;BA.debugLine="sale1.Text = totalSales1";
_sale1.setText(BA.ObjectToCharSequence(_totalsales1));
RDebugUtils.currentLine=5963923;
 //BA.debugLineNum = 5963923;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5963924;
 //BA.debugLineNum = 5963924;BA.debugLine="sale1.TextSize = primaryFontSize";
_sale1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=5963925;
 //BA.debugLineNum = 5963925;BA.debugLine="sale1.Gravity = Gravity.CENTER";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963926;
 //BA.debugLineNum = 5963926;BA.debugLine="sale1.Typeface = Typeface.SERIF";
_sale1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=5963927;
 //BA.debugLineNum = 5963927;BA.debugLine="Panel.AddView(sale1, 0, purchase3Title.Heigh";
mostCurrent._panel.AddView((android.view.View)(_sale1.getObject()),(int) (0),(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963929;
 //BA.debugLineNum = 5963929;BA.debugLine="Dim sale1Title As Label";
_sale1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963930;
 //BA.debugLineNum = 5963930;BA.debugLine="sale1Title.Initialize(\"\")";
_sale1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963931;
 //BA.debugLineNum = 5963931;BA.debugLine="sale1Title.Text = \"First Sale\"";
_sale1title.setText(BA.ObjectToCharSequence("First Sale"));
RDebugUtils.currentLine=5963932;
 //BA.debugLineNum = 5963932;BA.debugLine="sale1Title.TextColor = Colors.Gray";
_sale1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=5963933;
 //BA.debugLineNum = 5963933;BA.debugLine="sale1Title.TextSize = secondaryFontSize";
_sale1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=5963934;
 //BA.debugLineNum = 5963934;BA.debugLine="sale1Title.Gravity = Gravity.CENTER";
_sale1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963935;
 //BA.debugLineNum = 5963935;BA.debugLine="sale1Title.Typeface = Typeface.MONOSPACE";
_sale1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963936;
 //BA.debugLineNum = 5963936;BA.debugLine="sale1Title.Text = sale1Title.Text.ToUpperCas";
_sale1title.setText(BA.ObjectToCharSequence(_sale1title.getText().toUpperCase()));
RDebugUtils.currentLine=5963937;
 //BA.debugLineNum = 5963937;BA.debugLine="Panel.AddView(sale1Title, 0, sale1.top + pad";
mostCurrent._panel.AddView((android.view.View)(_sale1title.getObject()),(int) (0),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963939;
 //BA.debugLineNum = 5963939;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963940;
 //BA.debugLineNum = 5963940;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963941;
 //BA.debugLineNum = 5963941;BA.debugLine="sale2.Text = totalSales2";
_sale2.setText(BA.ObjectToCharSequence(_totalsales2));
RDebugUtils.currentLine=5963942;
 //BA.debugLineNum = 5963942;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5963943;
 //BA.debugLineNum = 5963943;BA.debugLine="sale2.TextSize = primaryFontSize";
_sale2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=5963944;
 //BA.debugLineNum = 5963944;BA.debugLine="sale2.Gravity = Gravity.CENTER";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963945;
 //BA.debugLineNum = 5963945;BA.debugLine="sale2.Typeface = Typeface.SERIF";
_sale2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=5963946;
 //BA.debugLineNum = 5963946;BA.debugLine="Panel.AddView(sale2, panelWidth, purchase3Ti";
mostCurrent._panel.AddView((android.view.View)(_sale2.getObject()),_panelwidth,(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963948;
 //BA.debugLineNum = 5963948;BA.debugLine="Dim sale2Title As Label";
_sale2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963949;
 //BA.debugLineNum = 5963949;BA.debugLine="sale2Title.Initialize(\"\")";
_sale2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963950;
 //BA.debugLineNum = 5963950;BA.debugLine="sale2Title.Text = \" Second Sale\"";
_sale2title.setText(BA.ObjectToCharSequence(" Second Sale"));
RDebugUtils.currentLine=5963951;
 //BA.debugLineNum = 5963951;BA.debugLine="sale2Title.TextColor = Colors.Gray";
_sale2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=5963952;
 //BA.debugLineNum = 5963952;BA.debugLine="sale2Title.TextSize = secondaryFontSize";
_sale2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=5963953;
 //BA.debugLineNum = 5963953;BA.debugLine="sale2Title.Gravity = Gravity.CENTER";
_sale2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963954;
 //BA.debugLineNum = 5963954;BA.debugLine="sale2Title.Typeface = Typeface.MONOSPACE";
_sale2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963955;
 //BA.debugLineNum = 5963955;BA.debugLine="sale2Title.Text = sale2Title.Text.ToUpperCas";
_sale2title.setText(BA.ObjectToCharSequence(_sale2title.getText().toUpperCase()));
RDebugUtils.currentLine=5963956;
 //BA.debugLineNum = 5963956;BA.debugLine="Panel.AddView(sale2Title, panelWidth, sale2.";
mostCurrent._panel.AddView((android.view.View)(_sale2title.getObject()),_panelwidth,(int) (_sale2.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963958;
 //BA.debugLineNum = 5963958;BA.debugLine="Dim sale3 As Label";
_sale3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963959;
 //BA.debugLineNum = 5963959;BA.debugLine="sale3.Initialize(\"\")";
_sale3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963960;
 //BA.debugLineNum = 5963960;BA.debugLine="sale3.Text = totalSales3";
_sale3.setText(BA.ObjectToCharSequence(_totalsales3));
RDebugUtils.currentLine=5963961;
 //BA.debugLineNum = 5963961;BA.debugLine="sale3.TextColor = Colors.Black";
_sale3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5963962;
 //BA.debugLineNum = 5963962;BA.debugLine="sale3.TextSize = primaryFontSize";
_sale3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=5963963;
 //BA.debugLineNum = 5963963;BA.debugLine="sale3.Gravity = Gravity.CENTER";
_sale3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963964;
 //BA.debugLineNum = 5963964;BA.debugLine="sale3.Typeface = Typeface.SERIF";
_sale3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=5963965;
 //BA.debugLineNum = 5963965;BA.debugLine="Panel.AddView(sale3, panelWidth * 2, sale2Ti";
mostCurrent._panel.AddView((android.view.View)(_sale3.getObject()),(int) (_panelwidth*2),(int) (_sale2title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963967;
 //BA.debugLineNum = 5963967;BA.debugLine="Dim sale3Title As Label";
_sale3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963968;
 //BA.debugLineNum = 5963968;BA.debugLine="sale3Title.Initialize(\"\")";
_sale3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5963969;
 //BA.debugLineNum = 5963969;BA.debugLine="sale3Title.Text = \" Third Sale\"";
_sale3title.setText(BA.ObjectToCharSequence(" Third Sale"));
RDebugUtils.currentLine=5963970;
 //BA.debugLineNum = 5963970;BA.debugLine="sale3Title.TextColor = Colors.Gray";
_sale3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=5963971;
 //BA.debugLineNum = 5963971;BA.debugLine="sale3Title.TextSize = secondaryFontSize";
_sale3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=5963972;
 //BA.debugLineNum = 5963972;BA.debugLine="sale3Title.Gravity = Gravity.CENTER";
_sale3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963973;
 //BA.debugLineNum = 5963973;BA.debugLine="sale3Title.Typeface = Typeface.MONOSPACE";
_sale3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963974;
 //BA.debugLineNum = 5963974;BA.debugLine="sale3Title.Text = sale3Title.Text.ToUpperCas";
_sale3title.setText(BA.ObjectToCharSequence(_sale3title.getText().toUpperCase()));
RDebugUtils.currentLine=5963975;
 //BA.debugLineNum = 5963975;BA.debugLine="Panel.AddView(sale3Title, panelWidth * 2, sa";
mostCurrent._panel.AddView((android.view.View)(_sale3title.getObject()),(int) (_panelwidth*2),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963977;
 //BA.debugLineNum = 5963977;BA.debugLine="panelWidth = Panel.Width / 2";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)2);
RDebugUtils.currentLine=5963979;
 //BA.debugLineNum = 5963979;BA.debugLine="totalTarget.Initialize(\"totalTarget\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"totalTarget");
RDebugUtils.currentLine=5963980;
 //BA.debugLineNum = 5963980;BA.debugLine="totalTarget.Text = total_count";
mostCurrent._totaltarget.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=5963981;
 //BA.debugLineNum = 5963981;BA.debugLine="totalTarget.Tag = target_id";
mostCurrent._totaltarget.setTag((Object)(_target_id));
RDebugUtils.currentLine=5963982;
 //BA.debugLineNum = 5963982;BA.debugLine="totalTarget.TextColor = Colors.Black";
mostCurrent._totaltarget.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5963983;
 //BA.debugLineNum = 5963983;BA.debugLine="totalTarget.Color = Colors.White";
mostCurrent._totaltarget.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=5963984;
 //BA.debugLineNum = 5963984;BA.debugLine="totalTarget.TextSize = primaryFontSize";
mostCurrent._totaltarget.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=5963985;
 //BA.debugLineNum = 5963985;BA.debugLine="totalTarget.Gravity = Gravity.CENTER";
mostCurrent._totaltarget.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963986;
 //BA.debugLineNum = 5963986;BA.debugLine="totalTarget.Typeface = Typeface.SERIF";
mostCurrent._totaltarget.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=5963987;
 //BA.debugLineNum = 5963987;BA.debugLine="Panel.AddView(totalTarget, 2dip, sale3Title.";
mostCurrent._panel.AddView((android.view.View)(mostCurrent._totaltarget.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_sale3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5963989;
 //BA.debugLineNum = 5963989;BA.debugLine="Dim totalTargetTitle As Label";
_totaltargettitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963990;
 //BA.debugLineNum = 5963990;BA.debugLine="totalTargetTitle.Initialize(\"totalTargetTitl";
_totaltargettitle.Initialize(mostCurrent.activityBA,"totalTargetTitles");
RDebugUtils.currentLine=5963991;
 //BA.debugLineNum = 5963991;BA.debugLine="totalTargetTitle.Text = \" Total Target\"";
_totaltargettitle.setText(BA.ObjectToCharSequence(" Total Target"));
RDebugUtils.currentLine=5963992;
 //BA.debugLineNum = 5963992;BA.debugLine="totalTargetTitle.Tag = 20";
_totaltargettitle.setTag((Object)(20));
RDebugUtils.currentLine=5963993;
 //BA.debugLineNum = 5963993;BA.debugLine="totalTargetTitle.TextColor = Colors.Gray";
_totaltargettitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=5963994;
 //BA.debugLineNum = 5963994;BA.debugLine="totalTargetTitle.TextSize = secondaryFontSiz";
_totaltargettitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=5963995;
 //BA.debugLineNum = 5963995;BA.debugLine="totalTargetTitle.Gravity = Gravity.CENTER";
_totaltargettitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5963996;
 //BA.debugLineNum = 5963996;BA.debugLine="totalTargetTitle.Typeface = Typeface.MONOSPA";
_totaltargettitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5963997;
 //BA.debugLineNum = 5963997;BA.debugLine="totalTargetTitle.Text = totalTargetTitle.Tex";
_totaltargettitle.setText(BA.ObjectToCharSequence(_totaltargettitle.getText().toUpperCase()));
RDebugUtils.currentLine=5963998;
 //BA.debugLineNum = 5963998;BA.debugLine="Panel.AddView(totalTargetTitle, 0, totalTarg";
mostCurrent._panel.AddView((android.view.View)(_totaltargettitle.getObject()),(int) (0),(int) (mostCurrent._totaltarget.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5964000;
 //BA.debugLineNum = 5964000;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5964001;
 //BA.debugLineNum = 5964001;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5964002;
 //BA.debugLineNum = 5964002;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=5964003;
 //BA.debugLineNum = 5964003;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5964004;
 //BA.debugLineNum = 5964004;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=5964005;
 //BA.debugLineNum = 5964005;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5964006;
 //BA.debugLineNum = 5964006;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=5964007;
 //BA.debugLineNum = 5964007;BA.debugLine="Panel.AddView(totalPos, panelWidth, totalTar";
mostCurrent._panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,(int) (_totaltargettitle.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5964009;
 //BA.debugLineNum = 5964009;BA.debugLine="Dim totalPosTitle As Label";
_totalpostitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5964010;
 //BA.debugLineNum = 5964010;BA.debugLine="totalPosTitle.Initialize(\"\")";
_totalpostitle.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5964011;
 //BA.debugLineNum = 5964011;BA.debugLine="totalPosTitle.Text = \" Total Pos\"";
_totalpostitle.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=5964012;
 //BA.debugLineNum = 5964012;BA.debugLine="totalPosTitle.TextColor = Colors.Gray";
_totalpostitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=5964013;
 //BA.debugLineNum = 5964013;BA.debugLine="totalPosTitle.TextSize = secondaryFontSize";
_totalpostitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=5964014;
 //BA.debugLineNum = 5964014;BA.debugLine="totalPosTitle.Gravity = Gravity.CENTER";
_totalpostitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=5964015;
 //BA.debugLineNum = 5964015;BA.debugLine="totalPosTitle.Typeface = Typeface.MONOSPACE";
_totalpostitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=5964016;
 //BA.debugLineNum = 5964016;BA.debugLine="totalPosTitle.Text = totalPosTitle.Text.ToUp";
_totalpostitle.setText(BA.ObjectToCharSequence(_totalpostitle.getText().toUpperCase()));
RDebugUtils.currentLine=5964017;
 //BA.debugLineNum = 5964017;BA.debugLine="Panel.AddView(totalPosTitle, panelWidth, tot";
mostCurrent._panel.AddView((android.view.View)(_totalpostitle.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=5964019;
 //BA.debugLineNum = 5964019;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=5964020;
 //BA.debugLineNum = 5964020;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 2dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (156),(int) (0),(int) (0)));
RDebugUtils.currentLine=5964021;
 //BA.debugLineNum = 5964021;BA.debugLine="Panel.Background = cd";
mostCurrent._panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=5964023;
 //BA.debugLineNum = 5964023;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=5964024;
 //BA.debugLineNum = 5964024;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
RDebugUtils.currentLine=5964025;
 //BA.debugLineNum = 5964025;BA.debugLine="If count Mod numColumns = 0 Then";
if (_count%_numcolumns==0) { 
RDebugUtils.currentLine=5964026;
 //BA.debugLineNum = 5964026;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=5964027;
 //BA.debugLineNum = 5964027;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
_topposition = (int) (_topposition+_pnlheight+_padding);
 }else {
RDebugUtils.currentLine=5964029;
 //BA.debugLineNum = 5964029;BA.debugLine="leftPosition = leftPosition + pnlWidth + p";
_leftposition = (int) (_leftposition+_pnlwidth+_padding);
 };
RDebugUtils.currentLine=5964031;
 //BA.debugLineNum = 5964031;BA.debugLine="scrollHeight = scrollHeight + 175dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (175)));
 }else {
RDebugUtils.currentLine=5964033;
 //BA.debugLineNum = 5964033;BA.debugLine="topPosition = topPosition + pnlHeight + pad";
_topposition = (int) (_topposition+_pnlheight+_padding);
RDebugUtils.currentLine=5964034;
 //BA.debugLineNum = 5964034;BA.debugLine="scrollHeight = scrollHeight + 290dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (290)));
 };
 }
};
RDebugUtils.currentLine=5964038;
 //BA.debugLineNum = 5964038;BA.debugLine="scrollViewPanel4.Panel.Height = scrollHeight";
mostCurrent._scrollviewpanel4.getPanel().setHeight(_scrollheight);
RDebugUtils.currentLine=5964039;
 //BA.debugLineNum = 5964039;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break; }
case 1: {
RDebugUtils.currentLine=5964041;
 //BA.debugLineNum = 5964041;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5964042;
 //BA.debugLineNum = 5964042;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
case 2: {
RDebugUtils.currentLine=5964045;
 //BA.debugLineNum = 5964045;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=5964046;
 //BA.debugLineNum = 5964046;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=5964048;
 //BA.debugLineNum = 5964048;BA.debugLine="Dim idCom As Int = Starter.company_selected.A";
_idcom = ((int)(Double.parseDouble(mostCurrent._starter._company_selected /*String*/ )));
RDebugUtils.currentLine=5964049;
 //BA.debugLineNum = 5964049;BA.debugLine="For i = 0 To salesArray.Size - 1";
{
final int step242 = 1;
final int limit242 = (int) (_salesarray.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit242 ;_i = _i + step242 ) {
RDebugUtils.currentLine=5964050;
 //BA.debugLineNum = 5964050;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=5964051;
 //BA.debugLineNum = 5964051;BA.debugLine="Dim currentComId As String = record.Get(\"com";
_currentcomid = BA.ObjectToString(_record.Get((Object)("comId")));
RDebugUtils.currentLine=5964053;
 //BA.debugLineNum = 5964053;BA.debugLine="If currentComId = idCom Then";
if ((_currentcomid).equals(BA.NumberToString(_idcom))) { 
RDebugUtils.currentLine=5964054;
 //BA.debugLineNum = 5964054;BA.debugLine="If record.ContainsKey(\"branches\") Then";
if (_record.ContainsKey((Object)("branches"))) { 
RDebugUtils.currentLine=5964055;
 //BA.debugLineNum = 5964055;BA.debugLine="Dim branches1 As List = record.Get(\"branch";
_branches1 = new anywheresoftware.b4a.objects.collections.List();
_branches1 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_record.Get((Object)("branches"))));
RDebugUtils.currentLine=5964056;
 //BA.debugLineNum = 5964056;BA.debugLine="Dim totalBranches As Int = branches1.Size";
_totalbranches = _branches1.getSize();
RDebugUtils.currentLine=5964058;
 //BA.debugLineNum = 5964058;BA.debugLine="Dim branchNames(totalBranches) As String";
_branchnames = new String[_totalbranches];
java.util.Arrays.fill(_branchnames,"");
RDebugUtils.currentLine=5964059;
 //BA.debugLineNum = 5964059;BA.debugLine="Dim branchSales1(totalBranches) As Int";
_branchsales1 = new int[_totalbranches];
;
RDebugUtils.currentLine=5964060;
 //BA.debugLineNum = 5964060;BA.debugLine="Dim branchSales2(totalBranches) As Int";
_branchsales2 = new int[_totalbranches];
;
RDebugUtils.currentLine=5964061;
 //BA.debugLineNum = 5964061;BA.debugLine="Dim branchSales3(totalBranches) As Int";
_branchsales3 = new int[_totalbranches];
;
RDebugUtils.currentLine=5964063;
 //BA.debugLineNum = 5964063;BA.debugLine="For j = 0 To totalBranches - 1";
{
final int step253 = 1;
final int limit253 = (int) (_totalbranches-1);
_j = (int) (0) ;
for (;_j <= limit253 ;_j = _j + step253 ) {
RDebugUtils.currentLine=5964064;
 //BA.debugLineNum = 5964064;BA.debugLine="Dim branchMap As Map = branches1.Get(j)";
_branchmap = new anywheresoftware.b4a.objects.collections.Map();
_branchmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_branches1.Get(_j)));
RDebugUtils.currentLine=5964065;
 //BA.debugLineNum = 5964065;BA.debugLine="branchNames(j) = branchMap.GetDefault(\"br";
_branchnames[_j] = (BA.ObjectToString(_branchmap.GetDefault((Object)("branch_name"),(Object)(""))));
RDebugUtils.currentLine=5964066;
 //BA.debugLineNum = 5964066;BA.debugLine="branchSales1(j) = branchMap.GetDefault(\"s";
_branchsales1[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales1"),(Object)(0))));
RDebugUtils.currentLine=5964067;
 //BA.debugLineNum = 5964067;BA.debugLine="branchSales2(j) = branchMap.GetDefault(\"s";
_branchsales2[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales2"),(Object)(0))));
RDebugUtils.currentLine=5964068;
 //BA.debugLineNum = 5964068;BA.debugLine="branchSales3(j) = branchMap.GetDefault(\"s";
_branchsales3[_j] = (int)(BA.ObjectToNumber(_branchmap.GetDefault((Object)("sales3"),(Object)(0))));
 }
};
RDebugUtils.currentLine=5964071;
 //BA.debugLineNum = 5964071;BA.debugLine="purchasePanel.RemoveAllViews";
mostCurrent._purchasepanel.RemoveAllViews();
RDebugUtils.currentLine=5964072;
 //BA.debugLineNum = 5964072;BA.debugLine="Dim legend() As String = Array As String(\"";
_legend = new String[]{"Sales1","Sales2","Sales3"};
RDebugUtils.currentLine=5964074;
 //BA.debugLineNum = 5964074;BA.debugLine="If barGraphInitialized = False Then";
if (_bargraphinitialized==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5964075;
 //BA.debugLineNum = 5964075;BA.debugLine="nxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._nxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=5964076;
 //BA.debugLineNum = 5964076;BA.debugLine="backbtn.Initialize(\"backbtn\")";
mostCurrent._backbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=5964077;
 //BA.debugLineNum = 5964077;BA.debugLine="barGraph.Initialize(Activity, purchasePan";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_branchsales1,_branchsales2,_branchsales3,_branchnames,_legend,(int) (19000),"Sla",_branchsales1,"Branch",mostCurrent._nxtbtn,mostCurrent._backbtn);
RDebugUtils.currentLine=5964078;
 //BA.debugLineNum = 5964078;BA.debugLine="barGraphInitialized = True";
_bargraphinitialized = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=5964079;
 //BA.debugLineNum = 5964079;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 }else {
RDebugUtils.currentLine=5964083;
 //BA.debugLineNum = 5964083;BA.debugLine="barGraph.sale_1 = branchSales1";
mostCurrent._bargraph._sale_1 /*int[]*/  = _branchsales1;
RDebugUtils.currentLine=5964084;
 //BA.debugLineNum = 5964084;BA.debugLine="barGraph.sale_2 = branchSales2";
mostCurrent._bargraph._sale_2 /*int[]*/  = _branchsales2;
RDebugUtils.currentLine=5964085;
 //BA.debugLineNum = 5964085;BA.debugLine="barGraph.sale_3 = branchSales3";
mostCurrent._bargraph._sale_3 /*int[]*/  = _branchsales3;
RDebugUtils.currentLine=5964086;
 //BA.debugLineNum = 5964086;BA.debugLine="barGraph.product1 = branchNames";
mostCurrent._bargraph._product1 /*String[]*/  = _branchnames;
RDebugUtils.currentLine=5964087;
 //BA.debugLineNum = 5964087;BA.debugLine="barGraph.comId1 = branchSales1 ' Assuming";
mostCurrent._bargraph._comid1 /*int[]*/  = _branchsales1;
RDebugUtils.currentLine=5964088;
 //BA.debugLineNum = 5964088;BA.debugLine="barGraph.UpdateGraph";
mostCurrent._bargraph._updategraph /*String*/ (null);
 };
RDebugUtils.currentLine=5964091;
 //BA.debugLineNum = 5964091;BA.debugLine="backbtn.Enabled = currentPage > 1";
mostCurrent._backbtn.setEnabled(_currentpage>1);
 }else {
RDebugUtils.currentLine=5964094;
 //BA.debugLineNum = 5964094;BA.debugLine="Log($\"Company: ${name} has no branches inf";
anywheresoftware.b4a.keywords.Common.LogImpl("35964094",("Company: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_name))+" has no branches information."),0);
 };
 };
 }
};
 break; }
default: {
RDebugUtils.currentLine=5964100;
 //BA.debugLineNum = 5964100;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("35964100","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e286) {
			processBA.setLastException(e286);RDebugUtils.currentLine=5964104;
 //BA.debugLineNum = 5964104;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=5964107;
 //BA.debugLineNum = 5964107;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5964110;
 //BA.debugLineNum = 5964110;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=5964111;
 //BA.debugLineNum = 5964111;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="branch_selected = selectedCompany";
_branch_selected = _selectedcompany;
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="StartActivity(\"Device\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Device"));
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="End Sub";
return "";
}
public static String  _nxtbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtbtn_click", null));}
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub nxtBtn_Click";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="currentPage = currentPage + 1";
_currentpage = (int) (_currentpage+1);
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="Log(currentPage)";
anywheresoftware.b4a.keywords.Common.LogImpl("36684674",BA.NumberToString(_currentpage),0);
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="FetchNewPageData";
_fetchnewpagedata();
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="End Sub";
return "";
}
public static String  _totaltarget_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltarget_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltarget_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub totalTarget_Click";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="Dim target_id_btn As Label = Sender";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="target_id_display.Text = target_id";
mostCurrent._target_id_display.setText(BA.ObjectToCharSequence(_target_id));
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="End Sub";
return "";
}
public static String  _totaltargettitle_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltargettitle_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltargettitle_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub totalTargetTitle_Click";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="Dim target_id_btn As Label = Sender";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="End Sub";
return "";
}
}