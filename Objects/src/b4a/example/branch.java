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
public static boolean _showhide = false;
public anywheresoftware.b4a.objects.PanelWrapper _popuppanelbackground = null;
public b4a.example.main _main = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _leftposition = 0;
anywheresoftware.b4a.objects.LabelWrapper _closebutton = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _myimage = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
anywheresoftware.b4a.objects.LabelWrapper _popuptext = null;
anywheresoftware.b4a.objects.LabelWrapper _popupdirectiontext = null;
anywheresoftware.b4a.objects.ButtonWrapper _edit_button = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdback = null;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Activity.LoadLayout(\"Branch\")";
mostCurrent._activity.LoadLayout("Branch",mostCurrent.activityBA);
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="home.TextSize = 16";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="Panel3.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="Panel3.Color = Colors.Transparent";
mostCurrent._panel3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=1769483;
 //BA.debugLineNum = 1769483;BA.debugLine="branches.Initialize(\"\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769484;
 //BA.debugLineNum = 1769484;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=1769485;
 //BA.debugLineNum = 1769485;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769486;
 //BA.debugLineNum = 1769486;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769487;
 //BA.debugLineNum = 1769487;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=1769488;
 //BA.debugLineNum = 1769488;BA.debugLine="Panel3.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel3.getHeight());
RDebugUtils.currentLine=1769490;
 //BA.debugLineNum = 1769490;BA.debugLine="popupPanel.Initialize(\"\")";
mostCurrent._popuppanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769491;
 //BA.debugLineNum = 1769491;BA.debugLine="popupPanel.Color = Colors.ARGB(200, 0, 0, 0)";
mostCurrent._popuppanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (200),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=1769492;
 //BA.debugLineNum = 1769492;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769493;
 //BA.debugLineNum = 1769493;BA.debugLine="Activity.AddView(popupPanel, 0, 0, Activity.Width";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._popuppanel.getObject()),(int) (0),(int) (0),mostCurrent._activity.getWidth(),mostCurrent._activity.getHeight());
RDebugUtils.currentLine=1769495;
 //BA.debugLineNum = 1769495;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1769496;
 //BA.debugLineNum = 1769496;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 1dip, Colors.B";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1769499;
 //BA.debugLineNum = 1769499;BA.debugLine="popupPanelBackground.Initialize(\"\")";
mostCurrent._popuppanelbackground.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769500;
 //BA.debugLineNum = 1769500;BA.debugLine="popupPanelBackground.Color = Colors.White";
mostCurrent._popuppanelbackground.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769501;
 //BA.debugLineNum = 1769501;BA.debugLine="popupPanel.AddView(popupPanelBackground, 70dip, 5";
mostCurrent._popuppanel.AddView((android.view.View)(mostCurrent._popuppanelbackground.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (550)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500))));
RDebugUtils.currentLine=1769504;
 //BA.debugLineNum = 1769504;BA.debugLine="Dim leftPosition As Int = (popupPanel.Width - pop";
_leftposition = (int) ((mostCurrent._popuppanel.getWidth()-mostCurrent._popuppanelbackground.getWidth())/(double)2);
RDebugUtils.currentLine=1769505;
 //BA.debugLineNum = 1769505;BA.debugLine="popupPanelBackground.Left = leftPosition";
mostCurrent._popuppanelbackground.setLeft(_leftposition);
RDebugUtils.currentLine=1769509;
 //BA.debugLineNum = 1769509;BA.debugLine="Dim closeButton As Label";
_closebutton = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769510;
 //BA.debugLineNum = 1769510;BA.debugLine="closeButton.Initialize(\"closeButton\")";
_closebutton.Initialize(mostCurrent.activityBA,"closeButton");
RDebugUtils.currentLine=1769511;
 //BA.debugLineNum = 1769511;BA.debugLine="closeButton.Text = \"X\"";
_closebutton.setText(BA.ObjectToCharSequence("X"));
RDebugUtils.currentLine=1769512;
 //BA.debugLineNum = 1769512;BA.debugLine="closeButton.TextSize = 15";
_closebutton.setTextSize((float) (15));
RDebugUtils.currentLine=1769513;
 //BA.debugLineNum = 1769513;BA.debugLine="closeButton.TextColor = Colors.Red";
_closebutton.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769514;
 //BA.debugLineNum = 1769514;BA.debugLine="closeButton.Typeface = Typeface.DEFAULT_BOLD";
_closebutton.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1769515;
 //BA.debugLineNum = 1769515;BA.debugLine="closeButton.Gravity = Gravity.CENTER";
_closebutton.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1769516;
 //BA.debugLineNum = 1769516;BA.debugLine="popupPanelBackground.AddView(closeButton, popupPa";
mostCurrent._popuppanelbackground.AddView((android.view.View)(_closebutton.getObject()),(int) (mostCurrent._popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=1769517;
 //BA.debugLineNum = 1769517;BA.debugLine="closeButton.Background = cd";
_closebutton.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=1769519;
 //BA.debugLineNum = 1769519;BA.debugLine="target_id_display.Initialize(\"target_id_display\")";
mostCurrent._target_id_display.Initialize(mostCurrent.activityBA,"target_id_display");
RDebugUtils.currentLine=1769520;
 //BA.debugLineNum = 1769520;BA.debugLine="target_id_display.TextSize = 20";
mostCurrent._target_id_display.setTextSize((float) (20));
RDebugUtils.currentLine=1769521;
 //BA.debugLineNum = 1769521;BA.debugLine="target_id_display.TextColor = Colors.Red";
mostCurrent._target_id_display.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769522;
 //BA.debugLineNum = 1769522;BA.debugLine="target_id_display.Typeface = Typeface.DEFAULT_BOL";
mostCurrent._target_id_display.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1769525;
 //BA.debugLineNum = 1769525;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirAssets";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"store.PNG");
RDebugUtils.currentLine=1769526;
 //BA.debugLineNum = 1769526;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1769527;
 //BA.debugLineNum = 1769527;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769528;
 //BA.debugLineNum = 1769528;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1769529;
 //BA.debugLineNum = 1769529;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=1769530;
 //BA.debugLineNum = 1769530;BA.debugLine="popupPanelBackground.AddView(imgView, 25%x, 12.5d";
mostCurrent._popuppanelbackground.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),(int) (mostCurrent._popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=1769533;
 //BA.debugLineNum = 1769533;BA.debugLine="Dim popupText As Label";
_popuptext = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769534;
 //BA.debugLineNum = 1769534;BA.debugLine="popupText.Initialize(\"\")";
_popuptext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769535;
 //BA.debugLineNum = 1769535;BA.debugLine="popupText.Text = \"Modify Target Sales\"";
_popuptext.setText(BA.ObjectToCharSequence("Modify Target Sales"));
RDebugUtils.currentLine=1769536;
 //BA.debugLineNum = 1769536;BA.debugLine="popupText.TextColor = Colors.Black";
_popuptext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1769537;
 //BA.debugLineNum = 1769537;BA.debugLine="popupText.TextSize = 50";
_popuptext.setTextSize((float) (50));
RDebugUtils.currentLine=1769538;
 //BA.debugLineNum = 1769538;BA.debugLine="popupText.Typeface = Typeface.DEFAULT_BOLD";
_popuptext.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1769539;
 //BA.debugLineNum = 1769539;BA.debugLine="popupText.Gravity = Gravity.CENTER";
_popuptext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1769540;
 //BA.debugLineNum = 1769540;BA.debugLine="popupPanelBackground.AddView(popupText, 25dip, im";
mostCurrent._popuppanelbackground.AddView((android.view.View)(_popuptext.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (_imgview.getTop()+_imgview.getHeight()),(int) (mostCurrent._popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65)));
RDebugUtils.currentLine=1769542;
 //BA.debugLineNum = 1769542;BA.debugLine="Dim popupDirectionText As Label";
_popupdirectiontext = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769543;
 //BA.debugLineNum = 1769543;BA.debugLine="popupDirectionText.Initialize(\"\")";
_popupdirectiontext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769544;
 //BA.debugLineNum = 1769544;BA.debugLine="popupDirectionText.Text = \"Modify the sales targe";
_popupdirectiontext.setText(BA.ObjectToCharSequence("Modify the sales target and set a new goal for total company sales."));
RDebugUtils.currentLine=1769545;
 //BA.debugLineNum = 1769545;BA.debugLine="popupDirectionText.TextColor = Colors.ARGB(150,0,";
_popupdirectiontext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (150),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=1769546;
 //BA.debugLineNum = 1769546;BA.debugLine="popupDirectionText.TextSize = 15";
_popupdirectiontext.setTextSize((float) (15));
RDebugUtils.currentLine=1769547;
 //BA.debugLineNum = 1769547;BA.debugLine="popupDirectionText.Typeface = Typeface.MONOSPACE";
_popupdirectiontext.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769548;
 //BA.debugLineNum = 1769548;BA.debugLine="popupDirectionText.Gravity = Gravity.CENTER";
_popupdirectiontext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1769549;
 //BA.debugLineNum = 1769549;BA.debugLine="popupPanelBackground.AddView(popupDirectionText,";
mostCurrent._popuppanelbackground.AddView((android.view.View)(_popupdirectiontext.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (_popuptext.getTop()+_popuptext.getHeight()),(int) (mostCurrent._popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=1769551;
 //BA.debugLineNum = 1769551;BA.debugLine="target_countLabel.Initialize(\"\")";
mostCurrent._target_countlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769553;
 //BA.debugLineNum = 1769553;BA.debugLine="target_countLabel.TextColor = Colors.Black";
mostCurrent._target_countlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1769554;
 //BA.debugLineNum = 1769554;BA.debugLine="target_countLabel.TextSize = 25";
mostCurrent._target_countlabel.setTextSize((float) (25));
RDebugUtils.currentLine=1769555;
 //BA.debugLineNum = 1769555;BA.debugLine="target_countLabel.Gravity = Gravity.CENTER";
mostCurrent._target_countlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1769557;
 //BA.debugLineNum = 1769557;BA.debugLine="popupPanelBackground.AddView(target_countLabel, 5";
mostCurrent._popuppanelbackground.AddView((android.view.View)(mostCurrent._target_countlabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (_popupdirectiontext.getTop()+_popupdirectiontext.getHeight()),(int) (mostCurrent._popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1769558;
 //BA.debugLineNum = 1769558;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
RDebugUtils.currentLine=1769560;
 //BA.debugLineNum = 1769560;BA.debugLine="AddBottomBorderToLabel(target_countLabel)";
_addbottombordertolabel(mostCurrent._target_countlabel);
RDebugUtils.currentLine=1769562;
 //BA.debugLineNum = 1769562;BA.debugLine="Dim edit_button As Button";
_edit_button = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1769563;
 //BA.debugLineNum = 1769563;BA.debugLine="edit_button.Initialize(\"edit_button\")";
_edit_button.Initialize(mostCurrent.activityBA,"edit_button");
RDebugUtils.currentLine=1769564;
 //BA.debugLineNum = 1769564;BA.debugLine="edit_button.Text = \"Update\"";
_edit_button.setText(BA.ObjectToCharSequence("Update"));
RDebugUtils.currentLine=1769565;
 //BA.debugLineNum = 1769565;BA.debugLine="edit_button.TextColor = Colors.White";
_edit_button.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769566;
 //BA.debugLineNum = 1769566;BA.debugLine="edit_button.TextSize = 25";
_edit_button.setTextSize((float) (25));
RDebugUtils.currentLine=1769567;
 //BA.debugLineNum = 1769567;BA.debugLine="edit_button.Gravity = Gravity.CENTER";
_edit_button.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1769568;
 //BA.debugLineNum = 1769568;BA.debugLine="popupPanelBackground.AddView(edit_button, 30%x, t";
mostCurrent._popuppanelbackground.AddView((android.view.View)(_edit_button.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),(int) (mostCurrent._target_countlabel.getTop()+mostCurrent._target_countlabel.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))),(int) (mostCurrent._popuppanelbackground.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1769570;
 //BA.debugLineNum = 1769570;BA.debugLine="Dim cdBack As ColorDrawable";
_cdback = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1769571;
 //BA.debugLineNum = 1769571;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
_cdback.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (61),(int) (12),(int) (2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1769572;
 //BA.debugLineNum = 1769572;BA.debugLine="edit_button.Background = cdBack";
_edit_button.setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
RDebugUtils.currentLine=1769578;
 //BA.debugLineNum = 1769578;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769579;
 //BA.debugLineNum = 1769579;BA.debugLine="Panel4.AddView(purchasePanel, 0, 0dip, Activity.W";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (530)));
RDebugUtils.currentLine=1769580;
 //BA.debugLineNum = 1769580;BA.debugLine="purchasePanel.Color = Colors.White ' Set a visibl";
mostCurrent._purchasepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769582;
 //BA.debugLineNum = 1769582;BA.debugLine="scrollViewPanel4.Initialize(Panel4.Height - purch";
mostCurrent._scrollviewpanel4.Initialize(mostCurrent.activityBA,(int) (mostCurrent._panel4.getHeight()-mostCurrent._purchasepanel.getHeight()));
RDebugUtils.currentLine=1769583;
 //BA.debugLineNum = 1769583;BA.debugLine="Panel4.AddView(scrollViewPanel4, 0, purchasePanel";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._scrollviewpanel4.getObject()),(int) (0),mostCurrent._purchasepanel.getHeight(),mostCurrent._panel4.getWidth(),(int) (mostCurrent._panel4.getHeight()-mostCurrent._purchasepanel.getHeight()));
RDebugUtils.currentLine=1769587;
 //BA.debugLineNum = 1769587;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=1769588;
 //BA.debugLineNum = 1769588;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=1769589;
 //BA.debugLineNum = 1769589;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="End Sub";
return 0;
}
public static String  _addbottombordertolabel(anywheresoftware.b4a.objects.EditTextWrapper _lbl) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addbottombordertolabel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addbottombordertolabel", new Object[] {_lbl}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub AddBottomBorderToLabel(lbl As EditText)";
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="bmp.InitializeMutable(lbl.Width, lbl.Height)";
_bmp.InitializeMutable(_lbl.getWidth(),_lbl.getHeight());
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="cvs.DrawLine(0, lbl.Height - 2dip, lbl.Width, lbl";
_cvs.DrawLine((float) (0),(float) (_lbl.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(float) (_lbl.getWidth()),(float) (_lbl.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),anywheresoftware.b4a.keywords.Common.Colors.Black,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=3342347;
 //BA.debugLineNum = 3342347;BA.debugLine="Dim bd As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=3342348;
 //BA.debugLineNum = 3342348;BA.debugLine="bd.Initialize(bmp)";
_bd.Initialize((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=3342349;
 //BA.debugLineNum = 3342349;BA.debugLine="lbl.Background = bd";
_lbl.setBackground((android.graphics.drawable.Drawable)(_bd.getObject()));
RDebugUtils.currentLine=3342350;
 //BA.debugLineNum = 3342350;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="totalTarget.Initialize(\"\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="PHPURL = $\"https://192.168.8.117/Company/controll";
mostCurrent._phpurl = ("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._company_selected /*String*/ ))+"&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"");
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="Log($\"Fetching panel data for company ID: ${Start";
anywheresoftware.b4a.keywords.Common.LogImpl("22031621",("Fetching panel data for company ID: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._company_selected /*String*/ ))+", page: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+""),0);
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",branch.getObject());
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Graph Data..."));
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydatabranchgraph() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydatabranchgraph", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydatabranchgraph", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub LoadCompanyDataBranchGraph";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Try";
try {RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="Job1.Initialize(\"GetBranches\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetBranches",branch.getObject());
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="PHPURL1 = $\"https://192.168.8.117/Company/contro";
mostCurrent._phpurl1 = ("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._starter._company_selected /*String*/ ))+"&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"&branch_sales="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_salesdata1))+"&sort_type="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+"");
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="Log(Starter.company_selected & \"isd\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21966085",mostCurrent._starter._company_selected /*String*/ +"isd",0);
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="Job1.Download(PHPURL1)";
_job1._download /*String*/ (null,mostCurrent._phpurl1);
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Graph Data..."));
 } 
       catch (Exception e9) {
			processBA.setLastException(e9);RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("21966090",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub backbtn_Click";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="If currentPage > 1 Then";
if (_currentpage>1) { 
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="currentPage = currentPage - 1";
_currentpage = (int) (_currentpage-1);
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="Log($\"Previous page: ${currentPage}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("22818051",("Previous page: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+""),0);
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="LoadCompanyDataBranchGraph ' Updates graph";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="LoadCompanyData ' Updates panels";
_loadcompanydata();
 };
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="End Sub";
return "";
}
public static String  _closebutton_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closebutton_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closebutton_click", null));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub closeButton_Click";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="End Sub";
return "";
}
public static String  _defbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "defbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "defbtn_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub defBtn_Click";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="sortDefaultValue = \"\"";
mostCurrent._sortdefaultvalue = "";
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("22883589",_index,0);
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="Log(\"(default)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22883590","(default)",0);
RDebugUtils.currentLine=2883595;
 //BA.debugLineNum = 2883595;BA.debugLine="End Sub";
return "";
}
public static String  _edit_button_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edit_button_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edit_button_click", null));}
int _target_id = 0;
int _new_value = 0;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub edit_button_Click";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Dim target_id As Int = target_id_display.Text";
_target_id = (int)(Double.parseDouble(mostCurrent._target_id_display.getText()));
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim new_value As Int = target_countLabel.Text";
_new_value = (int)(Double.parseDouble(mostCurrent._target_countlabel.getText()));
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_target_id)) && anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_new_value))) { 
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="UpdateData_Remote(target_id, new_value)";
_updatedata_remote(_target_id,_new_value);
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="popupPanel.Visible = False";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="Log(\"Invalid input values\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22293769","Invalid input values",0);
 };
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="End Sub";
return "";
}
public static String  _updatedata_remote(int _target_id,int _new_value) throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatedata_remote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updatedata_remote", new Object[] {_target_id,_new_value}));}
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.117/Co";
mostCurrent._phpurl = ("https://192.168.8.117/Company/controller/branch.php?action=target_update&id="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_target_id))+"&value="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_new_value))+"");
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
_job._initialize /*String*/ (null,processBA,"UpdateData",branch.getObject());
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="job.Download(PHPURL)";
_job._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="End Sub";
return "";
}
public static String  _fetchnewpagedata() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fetchnewpagedata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fetchnewpagedata", null));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub FetchNewPageData";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="LoadCompanyDataBranchGraph ' Fetch new data for t";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="Try";
try {RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","UpdateData","GetBranches","UpdateData")) {
case 0: {
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="totalTarget.RemoveView";
mostCurrent._totaltarget.RemoveView();
RDebugUtils.currentLine=2162701;
 //BA.debugLineNum = 2162701;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
_numcolumns = (int) (2);
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
_pnlwidth = (int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=2162703;
 //BA.debugLineNum = 2162703;BA.debugLine="Dim pnlHeight As Int = 280dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280));
RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="Dim leftPosition As Int = 50dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=2162706;
 //BA.debugLineNum = 2162706;BA.debugLine="Dim topPosition As Int = 0";
_topposition = (int) (0);
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=2162708;
 //BA.debugLineNum = 2162708;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=2162709;
 //BA.debugLineNum = 2162709;BA.debugLine="pnlWidth = 490dip";
_pnlwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (490));
RDebugUtils.currentLine=2162710;
 //BA.debugLineNum = 2162710;BA.debugLine="pnlHeight = 300dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300));
RDebugUtils.currentLine=2162711;
 //BA.debugLineNum = 2162711;BA.debugLine="padding = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2162712;
 //BA.debugLineNum = 2162712;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 };
RDebugUtils.currentLine=2162714;
 //BA.debugLineNum = 2162714;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group23 = mostCurrent._tabledetails;
final int groupLen23 = group23.getSize()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group23.Get(index23)));
RDebugUtils.currentLine=2162716;
 //BA.debugLineNum = 2162716;BA.debugLine="Panel.Initialize(\"Panel\")";
mostCurrent._panel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=2162717;
 //BA.debugLineNum = 2162717;BA.debugLine="Panel.Visible = showHide";
mostCurrent._panel.setVisible(_showhide);
RDebugUtils.currentLine=2162718;
 //BA.debugLineNum = 2162718;BA.debugLine="scrollViewPanel4.Panel.AddView(Panel, leftPo";
mostCurrent._scrollviewpanel4.getPanel().AddView((android.view.View)(mostCurrent._panel.getObject()),_leftposition,_topposition,_pnlwidth,_pnlheight);
RDebugUtils.currentLine=2162719;
 //BA.debugLineNum = 2162719;BA.debugLine="Panel.Color = Colors.Black";
mostCurrent._panel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162720;
 //BA.debugLineNum = 2162720;BA.debugLine="If Panel.Visible = True Then";
if (mostCurrent._panel.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2162721;
 //BA.debugLineNum = 2162721;BA.debugLine="Dim companyName As String = record.Get(\"com";
_companyname = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=2162722;
 //BA.debugLineNum = 2162722;BA.debugLine="Dim id As String = record.Get(\"branch_id\")";
_id = BA.ObjectToString(_record.Get((Object)("branch_id")));
RDebugUtils.currentLine=2162723;
 //BA.debugLineNum = 2162723;BA.debugLine="Dim name As String = record.Get(\"branch_nam";
_name = BA.ObjectToString(_record.Get((Object)("branch_name")));
RDebugUtils.currentLine=2162724;
 //BA.debugLineNum = 2162724;BA.debugLine="Dim total_count As Int = record.Get(\"target";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("target_no"))));
RDebugUtils.currentLine=2162725;
 //BA.debugLineNum = 2162725;BA.debugLine="Dim total_pos As Int = record.Get(\"count_de";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("count_device"))));
RDebugUtils.currentLine=2162726;
 //BA.debugLineNum = 2162726;BA.debugLine="Dim totalPur1 As String = record.Get(\"purch";
_totalpur1 = BA.ObjectToString(_record.Get((Object)("purchase_1")));
RDebugUtils.currentLine=2162727;
 //BA.debugLineNum = 2162727;BA.debugLine="Dim totalPur2 As String = record.Get(\"purch";
_totalpur2 = BA.ObjectToString(_record.Get((Object)("purchase_2")));
RDebugUtils.currentLine=2162728;
 //BA.debugLineNum = 2162728;BA.debugLine="Dim totalPur3 As String = record.Get(\"purch";
_totalpur3 = BA.ObjectToString(_record.Get((Object)("purchase_3")));
RDebugUtils.currentLine=2162729;
 //BA.debugLineNum = 2162729;BA.debugLine="Dim totalSales1 As String = record.Get(\"sal";
_totalsales1 = BA.ObjectToString(_record.Get((Object)("sales_1")));
RDebugUtils.currentLine=2162730;
 //BA.debugLineNum = 2162730;BA.debugLine="Dim totalSales2 As String = record.Get(\"sal";
_totalsales2 = BA.ObjectToString(_record.Get((Object)("sales_2")));
RDebugUtils.currentLine=2162731;
 //BA.debugLineNum = 2162731;BA.debugLine="Dim totalSales3 As String = record.Get(\"sal";
_totalsales3 = BA.ObjectToString(_record.Get((Object)("sales_3")));
RDebugUtils.currentLine=2162732;
 //BA.debugLineNum = 2162732;BA.debugLine="Dim target_id As String = record.Get(\"targe";
_target_id = BA.ObjectToString(_record.Get((Object)("target_id")));
RDebugUtils.currentLine=2162733;
 //BA.debugLineNum = 2162733;BA.debugLine="totalSales = totalSales1.Length";
_totalsales = _totalsales1.length();
RDebugUtils.currentLine=2162734;
 //BA.debugLineNum = 2162734;BA.debugLine="branches.Text = \"Branches - \" & companyName";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_companyname));
RDebugUtils.currentLine=2162735;
 //BA.debugLineNum = 2162735;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=2162737;
 //BA.debugLineNum = 2162737;BA.debugLine="LabelTitle.Text = companyName";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_companyname));
RDebugUtils.currentLine=2162738;
 //BA.debugLineNum = 2162738;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCa";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=2162739;
 //BA.debugLineNum = 2162739;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
mostCurrent._labeltitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162742;
 //BA.debugLineNum = 2162742;BA.debugLine="Dim Panel2 As Panel";
_panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2162743;
 //BA.debugLineNum = 2162743;BA.debugLine="Panel2.Initialize(\"Panel2\")";
_panel2.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=2162744;
 //BA.debugLineNum = 2162744;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=2162745;
 //BA.debugLineNum = 2162745;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=2162746;
 //BA.debugLineNum = 2162746;BA.debugLine="Panel2.Background = gradient";
_panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=2162747;
 //BA.debugLineNum = 2162747;BA.debugLine="Panel2.Tag = name";
_panel2.setTag((Object)(_name));
RDebugUtils.currentLine=2162748;
 //BA.debugLineNum = 2162748;BA.debugLine="Panel2.SendToBack";
_panel2.SendToBack();
RDebugUtils.currentLine=2162749;
 //BA.debugLineNum = 2162749;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%";
mostCurrent._panel.AddView((android.view.View)(_panel2.getObject()),(int) (0),(int) (0),mostCurrent._panel.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=2162751;
 //BA.debugLineNum = 2162751;BA.debugLine="Dim BranchNameLabel As Label";
_branchnamelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162752;
 //BA.debugLineNum = 2162752;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
_branchnamelabel.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=2162753;
 //BA.debugLineNum = 2162753;BA.debugLine="BranchNameLabel.Text = name";
_branchnamelabel.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=2162754;
 //BA.debugLineNum = 2162754;BA.debugLine="BranchNameLabel.Tag = id";
_branchnamelabel.setTag((Object)(_id));
RDebugUtils.currentLine=2162755;
 //BA.debugLineNum = 2162755;BA.debugLine="BranchNameLabel.TextSize = 18";
_branchnamelabel.setTextSize((float) (18));
RDebugUtils.currentLine=2162756;
 //BA.debugLineNum = 2162756;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
_branchnamelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2162757;
 //BA.debugLineNum = 2162757;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPA";
_branchnamelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162758;
 //BA.debugLineNum = 2162758;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VE";
_branchnamelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2162759;
 //BA.debugLineNum = 2162759;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip";
_panel2.AddView((android.view.View)(_branchnamelabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panel2.getWidth(),_panel2.getHeight());
RDebugUtils.currentLine=2162761;
 //BA.debugLineNum = 2162761;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2162762;
 //BA.debugLineNum = 2162762;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrow";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=2162763;
 //BA.debugLineNum = 2162763;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=2162764;
 //BA.debugLineNum = 2162764;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resiz";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2162765;
 //BA.debugLineNum = 2162765;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2162766;
 //BA.debugLineNum = 2162766;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162767;
 //BA.debugLineNum = 2162767;BA.debugLine="imgView.Bitmap = resizedImage";
_imgview.setBitmap((android.graphics.Bitmap)(_resizedimage.getObject()));
RDebugUtils.currentLine=2162768;
 //BA.debugLineNum = 2162768;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x";
_panel2.AddView((android.view.View)(_imgview.getObject()),(int) (_panel2.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),_panel2.getHeight());
 }else {
RDebugUtils.currentLine=2162770;
 //BA.debugLineNum = 2162770;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22162770","Error loading image",0);
 };
RDebugUtils.currentLine=2162773;
 //BA.debugLineNum = 2162773;BA.debugLine="Dim panelWidth As Int = Panel.Width / 3";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)3);
RDebugUtils.currentLine=2162774;
 //BA.debugLineNum = 2162774;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2162775;
 //BA.debugLineNum = 2162775;BA.debugLine="Dim labelheight As Int = 35dip";
_labelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35));
RDebugUtils.currentLine=2162777;
 //BA.debugLineNum = 2162777;BA.debugLine="Dim purchase1 As Label";
_purchase1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162778;
 //BA.debugLineNum = 2162778;BA.debugLine="purchase1.Initialize(\"\")";
_purchase1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162779;
 //BA.debugLineNum = 2162779;BA.debugLine="purchase1.Text = totalPur1";
_purchase1.setText(BA.ObjectToCharSequence(_totalpur1));
RDebugUtils.currentLine=2162780;
 //BA.debugLineNum = 2162780;BA.debugLine="purchase1.TextColor = Colors.Black";
_purchase1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162781;
 //BA.debugLineNum = 2162781;BA.debugLine="purchase1.TextSize = primaryFontSize";
_purchase1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2162782;
 //BA.debugLineNum = 2162782;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
_purchase1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162783;
 //BA.debugLineNum = 2162783;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
_purchase1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2162784;
 //BA.debugLineNum = 2162784;BA.debugLine="Panel.AddView(purchase1, 0, Panel2.Height +";
mostCurrent._panel.AddView((android.view.View)(_purchase1.getObject()),(int) (0),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162786;
 //BA.debugLineNum = 2162786;BA.debugLine="Dim purchase1Title As Label";
_purchase1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162787;
 //BA.debugLineNum = 2162787;BA.debugLine="purchase1Title.Initialize(\"\")";
_purchase1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162788;
 //BA.debugLineNum = 2162788;BA.debugLine="purchase1Title.Text = \"First Purchase\"";
_purchase1title.setText(BA.ObjectToCharSequence("First Purchase"));
RDebugUtils.currentLine=2162789;
 //BA.debugLineNum = 2162789;BA.debugLine="purchase1Title.TextColor = Colors.Gray";
_purchase1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2162790;
 //BA.debugLineNum = 2162790;BA.debugLine="purchase1Title.TextSize = secondaryFontSize";
_purchase1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2162791;
 //BA.debugLineNum = 2162791;BA.debugLine="purchase1Title.Gravity = Gravity.CENTER";
_purchase1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162792;
 //BA.debugLineNum = 2162792;BA.debugLine="purchase1Title.Typeface = Typeface.MONOSPAC";
_purchase1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162793;
 //BA.debugLineNum = 2162793;BA.debugLine="purchase1Title.Text = purchase1Title.Text.T";
_purchase1title.setText(BA.ObjectToCharSequence(_purchase1title.getText().toUpperCase()));
RDebugUtils.currentLine=2162794;
 //BA.debugLineNum = 2162794;BA.debugLine="Panel.AddView(purchase1Title, 0, purchase1.";
mostCurrent._panel.AddView((android.view.View)(_purchase1title.getObject()),(int) (0),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162796;
 //BA.debugLineNum = 2162796;BA.debugLine="Dim purchase2 As Label";
_purchase2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162797;
 //BA.debugLineNum = 2162797;BA.debugLine="purchase2.Initialize(\"\")";
_purchase2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162798;
 //BA.debugLineNum = 2162798;BA.debugLine="purchase2.Text = totalPur2";
_purchase2.setText(BA.ObjectToCharSequence(_totalpur2));
RDebugUtils.currentLine=2162799;
 //BA.debugLineNum = 2162799;BA.debugLine="purchase2.TextColor = Colors.Black";
_purchase2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162800;
 //BA.debugLineNum = 2162800;BA.debugLine="purchase2.TextSize = primaryFontSize";
_purchase2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2162801;
 //BA.debugLineNum = 2162801;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
_purchase2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162802;
 //BA.debugLineNum = 2162802;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
_purchase2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2162803;
 //BA.debugLineNum = 2162803;BA.debugLine="Panel.AddView(purchase2, panelWidth, Panel2";
mostCurrent._panel.AddView((android.view.View)(_purchase2.getObject()),_panelwidth,(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162805;
 //BA.debugLineNum = 2162805;BA.debugLine="Dim purchase2Title As Label";
_purchase2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162806;
 //BA.debugLineNum = 2162806;BA.debugLine="purchase2Title.Initialize(\"\")";
_purchase2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162807;
 //BA.debugLineNum = 2162807;BA.debugLine="purchase2Title.Text = \"Second Purchase\"";
_purchase2title.setText(BA.ObjectToCharSequence("Second Purchase"));
RDebugUtils.currentLine=2162808;
 //BA.debugLineNum = 2162808;BA.debugLine="purchase2Title.TextColor = Colors.Gray";
_purchase2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2162809;
 //BA.debugLineNum = 2162809;BA.debugLine="purchase2Title.TextSize = secondaryFontSize";
_purchase2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2162810;
 //BA.debugLineNum = 2162810;BA.debugLine="purchase2Title.Gravity = Gravity.CENTER";
_purchase2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162811;
 //BA.debugLineNum = 2162811;BA.debugLine="purchase2Title.Typeface = Typeface.MONOSPAC";
_purchase2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162812;
 //BA.debugLineNum = 2162812;BA.debugLine="purchase2Title.Text = purchase2Title.Text.T";
_purchase2title.setText(BA.ObjectToCharSequence(_purchase2title.getText().toUpperCase()));
RDebugUtils.currentLine=2162813;
 //BA.debugLineNum = 2162813;BA.debugLine="Panel.AddView(purchase2Title, panelWidth, p";
mostCurrent._panel.AddView((android.view.View)(_purchase2title.getObject()),_panelwidth,(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162815;
 //BA.debugLineNum = 2162815;BA.debugLine="Dim purchase3 As Label";
_purchase3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162816;
 //BA.debugLineNum = 2162816;BA.debugLine="purchase3.Initialize(\"\")";
_purchase3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162817;
 //BA.debugLineNum = 2162817;BA.debugLine="purchase3.Text = totalPur3";
_purchase3.setText(BA.ObjectToCharSequence(_totalpur3));
RDebugUtils.currentLine=2162818;
 //BA.debugLineNum = 2162818;BA.debugLine="purchase3.TextColor = Colors.Black";
_purchase3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162819;
 //BA.debugLineNum = 2162819;BA.debugLine="purchase3.TextSize = primaryFontSize";
_purchase3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2162820;
 //BA.debugLineNum = 2162820;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
_purchase3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162821;
 //BA.debugLineNum = 2162821;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
_purchase3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2162822;
 //BA.debugLineNum = 2162822;BA.debugLine="Panel.AddView(purchase3, panelWidth * 2, Pa";
mostCurrent._panel.AddView((android.view.View)(_purchase3.getObject()),(int) (_panelwidth*2),(int) (_panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162824;
 //BA.debugLineNum = 2162824;BA.debugLine="Dim purchase3Title As Label";
_purchase3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162825;
 //BA.debugLineNum = 2162825;BA.debugLine="purchase3Title.Initialize(\"\")";
_purchase3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162826;
 //BA.debugLineNum = 2162826;BA.debugLine="purchase3Title.Text = \"Third Purchase\"";
_purchase3title.setText(BA.ObjectToCharSequence("Third Purchase"));
RDebugUtils.currentLine=2162827;
 //BA.debugLineNum = 2162827;BA.debugLine="purchase3Title.TextColor = Colors.Gray";
_purchase3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2162828;
 //BA.debugLineNum = 2162828;BA.debugLine="purchase3Title.TextSize = secondaryFontSize";
_purchase3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2162829;
 //BA.debugLineNum = 2162829;BA.debugLine="purchase3Title.Gravity = Gravity.CENTER";
_purchase3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162830;
 //BA.debugLineNum = 2162830;BA.debugLine="purchase3Title.Typeface = Typeface.MONOSPAC";
_purchase3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162831;
 //BA.debugLineNum = 2162831;BA.debugLine="purchase3Title.Text = purchase3Title.Text.T";
_purchase3title.setText(BA.ObjectToCharSequence(_purchase3title.getText().toUpperCase()));
RDebugUtils.currentLine=2162832;
 //BA.debugLineNum = 2162832;BA.debugLine="Panel.AddView(purchase3Title, panelWidth *";
mostCurrent._panel.AddView((android.view.View)(_purchase3title.getObject()),(int) (_panelwidth*2),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162834;
 //BA.debugLineNum = 2162834;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162835;
 //BA.debugLineNum = 2162835;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162836;
 //BA.debugLineNum = 2162836;BA.debugLine="sale1.Text = totalSales1";
_sale1.setText(BA.ObjectToCharSequence(_totalsales1));
RDebugUtils.currentLine=2162837;
 //BA.debugLineNum = 2162837;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162838;
 //BA.debugLineNum = 2162838;BA.debugLine="sale1.TextSize = primaryFontSize";
_sale1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2162839;
 //BA.debugLineNum = 2162839;BA.debugLine="sale1.Gravity = Gravity.CENTER";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162840;
 //BA.debugLineNum = 2162840;BA.debugLine="sale1.Typeface = Typeface.SERIF";
_sale1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2162841;
 //BA.debugLineNum = 2162841;BA.debugLine="Panel.AddView(sale1, 0, purchase3Title.Heig";
mostCurrent._panel.AddView((android.view.View)(_sale1.getObject()),(int) (0),(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162843;
 //BA.debugLineNum = 2162843;BA.debugLine="Dim sale1Title As Label";
_sale1title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162844;
 //BA.debugLineNum = 2162844;BA.debugLine="sale1Title.Initialize(\"\")";
_sale1title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162845;
 //BA.debugLineNum = 2162845;BA.debugLine="sale1Title.Text = \"First Sale\"";
_sale1title.setText(BA.ObjectToCharSequence("First Sale"));
RDebugUtils.currentLine=2162846;
 //BA.debugLineNum = 2162846;BA.debugLine="sale1Title.TextColor = Colors.Gray";
_sale1title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2162847;
 //BA.debugLineNum = 2162847;BA.debugLine="sale1Title.TextSize = secondaryFontSize";
_sale1title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2162848;
 //BA.debugLineNum = 2162848;BA.debugLine="sale1Title.Gravity = Gravity.CENTER";
_sale1title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162849;
 //BA.debugLineNum = 2162849;BA.debugLine="sale1Title.Typeface = Typeface.MONOSPACE";
_sale1title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162850;
 //BA.debugLineNum = 2162850;BA.debugLine="sale1Title.Text = sale1Title.Text.ToUpperCa";
_sale1title.setText(BA.ObjectToCharSequence(_sale1title.getText().toUpperCase()));
RDebugUtils.currentLine=2162851;
 //BA.debugLineNum = 2162851;BA.debugLine="Panel.AddView(sale1Title, 0, sale1.top + pa";
mostCurrent._panel.AddView((android.view.View)(_sale1title.getObject()),(int) (0),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162853;
 //BA.debugLineNum = 2162853;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162854;
 //BA.debugLineNum = 2162854;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162855;
 //BA.debugLineNum = 2162855;BA.debugLine="sale2.Text = totalSales2";
_sale2.setText(BA.ObjectToCharSequence(_totalsales2));
RDebugUtils.currentLine=2162856;
 //BA.debugLineNum = 2162856;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162857;
 //BA.debugLineNum = 2162857;BA.debugLine="sale2.TextSize = primaryFontSize";
_sale2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2162858;
 //BA.debugLineNum = 2162858;BA.debugLine="sale2.Gravity = Gravity.CENTER";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162859;
 //BA.debugLineNum = 2162859;BA.debugLine="sale2.Typeface = Typeface.SERIF";
_sale2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2162860;
 //BA.debugLineNum = 2162860;BA.debugLine="Panel.AddView(sale2, panelWidth, purchase3T";
mostCurrent._panel.AddView((android.view.View)(_sale2.getObject()),_panelwidth,(int) (_purchase3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162862;
 //BA.debugLineNum = 2162862;BA.debugLine="Dim sale2Title As Label";
_sale2title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162863;
 //BA.debugLineNum = 2162863;BA.debugLine="sale2Title.Initialize(\"\")";
_sale2title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162864;
 //BA.debugLineNum = 2162864;BA.debugLine="sale2Title.Text = \" Second Sale\"";
_sale2title.setText(BA.ObjectToCharSequence(" Second Sale"));
RDebugUtils.currentLine=2162865;
 //BA.debugLineNum = 2162865;BA.debugLine="sale2Title.TextColor = Colors.Gray";
_sale2title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2162866;
 //BA.debugLineNum = 2162866;BA.debugLine="sale2Title.TextSize = secondaryFontSize";
_sale2title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2162867;
 //BA.debugLineNum = 2162867;BA.debugLine="sale2Title.Gravity = Gravity.CENTER";
_sale2title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162868;
 //BA.debugLineNum = 2162868;BA.debugLine="sale2Title.Typeface = Typeface.MONOSPACE";
_sale2title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162869;
 //BA.debugLineNum = 2162869;BA.debugLine="sale2Title.Text = sale2Title.Text.ToUpperCa";
_sale2title.setText(BA.ObjectToCharSequence(_sale2title.getText().toUpperCase()));
RDebugUtils.currentLine=2162870;
 //BA.debugLineNum = 2162870;BA.debugLine="Panel.AddView(sale2Title, panelWidth, sale2";
mostCurrent._panel.AddView((android.view.View)(_sale2title.getObject()),_panelwidth,(int) (_sale2.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162872;
 //BA.debugLineNum = 2162872;BA.debugLine="Dim sale3 As Label";
_sale3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162873;
 //BA.debugLineNum = 2162873;BA.debugLine="sale3.Initialize(\"\")";
_sale3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162874;
 //BA.debugLineNum = 2162874;BA.debugLine="sale3.Text = totalSales3";
_sale3.setText(BA.ObjectToCharSequence(_totalsales3));
RDebugUtils.currentLine=2162875;
 //BA.debugLineNum = 2162875;BA.debugLine="sale3.TextColor = Colors.Black";
_sale3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162876;
 //BA.debugLineNum = 2162876;BA.debugLine="sale3.TextSize = primaryFontSize";
_sale3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2162877;
 //BA.debugLineNum = 2162877;BA.debugLine="sale3.Gravity = Gravity.CENTER";
_sale3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162878;
 //BA.debugLineNum = 2162878;BA.debugLine="sale3.Typeface = Typeface.SERIF";
_sale3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2162879;
 //BA.debugLineNum = 2162879;BA.debugLine="Panel.AddView(sale3, panelWidth * 2, sale2T";
mostCurrent._panel.AddView((android.view.View)(_sale3.getObject()),(int) (_panelwidth*2),(int) (_sale2title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162881;
 //BA.debugLineNum = 2162881;BA.debugLine="Dim sale3Title As Label";
_sale3title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162882;
 //BA.debugLineNum = 2162882;BA.debugLine="sale3Title.Initialize(\"\")";
_sale3title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162883;
 //BA.debugLineNum = 2162883;BA.debugLine="sale3Title.Text = \" Third Sale\"";
_sale3title.setText(BA.ObjectToCharSequence(" Third Sale"));
RDebugUtils.currentLine=2162884;
 //BA.debugLineNum = 2162884;BA.debugLine="sale3Title.TextColor = Colors.Gray";
_sale3title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2162885;
 //BA.debugLineNum = 2162885;BA.debugLine="sale3Title.TextSize = secondaryFontSize";
_sale3title.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2162886;
 //BA.debugLineNum = 2162886;BA.debugLine="sale3Title.Gravity = Gravity.CENTER";
_sale3title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162887;
 //BA.debugLineNum = 2162887;BA.debugLine="sale3Title.Typeface = Typeface.MONOSPACE";
_sale3title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162888;
 //BA.debugLineNum = 2162888;BA.debugLine="sale3Title.Text = sale3Title.Text.ToUpperCa";
_sale3title.setText(BA.ObjectToCharSequence(_sale3title.getText().toUpperCase()));
RDebugUtils.currentLine=2162889;
 //BA.debugLineNum = 2162889;BA.debugLine="Panel.AddView(sale3Title, panelWidth * 2, s";
mostCurrent._panel.AddView((android.view.View)(_sale3title.getObject()),(int) (_panelwidth*2),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162891;
 //BA.debugLineNum = 2162891;BA.debugLine="panelWidth = Panel.Width / 2";
_panelwidth = (int) (mostCurrent._panel.getWidth()/(double)2);
RDebugUtils.currentLine=2162894;
 //BA.debugLineNum = 2162894;BA.debugLine="totalTarget.Initialize(\"totalTarget\")";
mostCurrent._totaltarget.Initialize(mostCurrent.activityBA,"totalTarget");
RDebugUtils.currentLine=2162895;
 //BA.debugLineNum = 2162895;BA.debugLine="totalTarget.Text = total_count";
mostCurrent._totaltarget.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=2162896;
 //BA.debugLineNum = 2162896;BA.debugLine="totalTarget.Tag = target_id";
mostCurrent._totaltarget.setTag((Object)(_target_id));
RDebugUtils.currentLine=2162897;
 //BA.debugLineNum = 2162897;BA.debugLine="totalTarget.TextColor = Colors.Black";
mostCurrent._totaltarget.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162898;
 //BA.debugLineNum = 2162898;BA.debugLine="totalTarget.Color = Colors.White";
mostCurrent._totaltarget.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2162899;
 //BA.debugLineNum = 2162899;BA.debugLine="totalTarget.TextSize = primaryFontSize";
mostCurrent._totaltarget.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2162900;
 //BA.debugLineNum = 2162900;BA.debugLine="totalTarget.Gravity = Gravity.CENTER";
mostCurrent._totaltarget.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162901;
 //BA.debugLineNum = 2162901;BA.debugLine="totalTarget.Typeface = Typeface.SERIF";
mostCurrent._totaltarget.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2162902;
 //BA.debugLineNum = 2162902;BA.debugLine="Panel.AddView(totalTarget, 2dip, sale3Title";
mostCurrent._panel.AddView((android.view.View)(mostCurrent._totaltarget.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_sale3title.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162904;
 //BA.debugLineNum = 2162904;BA.debugLine="Dim totalTargetTitle As Label";
_totaltargettitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162905;
 //BA.debugLineNum = 2162905;BA.debugLine="totalTargetTitle.Initialize(\"totalTargetTit";
_totaltargettitle.Initialize(mostCurrent.activityBA,"totalTargetTitles");
RDebugUtils.currentLine=2162906;
 //BA.debugLineNum = 2162906;BA.debugLine="totalTargetTitle.Text = \" Total Target\"";
_totaltargettitle.setText(BA.ObjectToCharSequence(" Total Target"));
RDebugUtils.currentLine=2162907;
 //BA.debugLineNum = 2162907;BA.debugLine="totalTargetTitle.Tag = 20";
_totaltargettitle.setTag((Object)(20));
RDebugUtils.currentLine=2162908;
 //BA.debugLineNum = 2162908;BA.debugLine="totalTargetTitle.TextColor = Colors.Gray";
_totaltargettitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2162909;
 //BA.debugLineNum = 2162909;BA.debugLine="totalTargetTitle.TextSize = secondaryFontSi";
_totaltargettitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2162910;
 //BA.debugLineNum = 2162910;BA.debugLine="totalTargetTitle.Gravity = Gravity.CENTER";
_totaltargettitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162911;
 //BA.debugLineNum = 2162911;BA.debugLine="totalTargetTitle.Typeface = Typeface.MONOSP";
_totaltargettitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162912;
 //BA.debugLineNum = 2162912;BA.debugLine="totalTargetTitle.Text = totalTargetTitle.Te";
_totaltargettitle.setText(BA.ObjectToCharSequence(_totaltargettitle.getText().toUpperCase()));
RDebugUtils.currentLine=2162913;
 //BA.debugLineNum = 2162913;BA.debugLine="Panel.AddView(totalTargetTitle, 0, totalTar";
mostCurrent._panel.AddView((android.view.View)(_totaltargettitle.getObject()),(int) (0),(int) (mostCurrent._totaltarget.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162915;
 //BA.debugLineNum = 2162915;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162916;
 //BA.debugLineNum = 2162916;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162917;
 //BA.debugLineNum = 2162917;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=2162918;
 //BA.debugLineNum = 2162918;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2162919;
 //BA.debugLineNum = 2162919;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=2162920;
 //BA.debugLineNum = 2162920;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162921;
 //BA.debugLineNum = 2162921;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2162922;
 //BA.debugLineNum = 2162922;BA.debugLine="Panel.AddView(totalPos, panelWidth, totalTa";
mostCurrent._panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,(int) (_totaltargettitle.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162926;
 //BA.debugLineNum = 2162926;BA.debugLine="Dim totalPosTitle As Label";
_totalpostitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162927;
 //BA.debugLineNum = 2162927;BA.debugLine="totalPosTitle.Initialize(\"\")";
_totalpostitle.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162928;
 //BA.debugLineNum = 2162928;BA.debugLine="totalPosTitle.Text = \" Total Pos\"";
_totalpostitle.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=2162929;
 //BA.debugLineNum = 2162929;BA.debugLine="totalPosTitle.TextColor = Colors.Gray";
_totalpostitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=2162930;
 //BA.debugLineNum = 2162930;BA.debugLine="totalPosTitle.TextSize = secondaryFontSize";
_totalpostitle.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=2162931;
 //BA.debugLineNum = 2162931;BA.debugLine="totalPosTitle.Gravity = Gravity.CENTER";
_totalpostitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2162932;
 //BA.debugLineNum = 2162932;BA.debugLine="totalPosTitle.Typeface = Typeface.MONOSPACE";
_totalpostitle.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2162933;
 //BA.debugLineNum = 2162933;BA.debugLine="totalPosTitle.Text = totalPosTitle.Text.ToU";
_totalpostitle.setText(BA.ObjectToCharSequence(_totalpostitle.getText().toUpperCase()));
RDebugUtils.currentLine=2162934;
 //BA.debugLineNum = 2162934;BA.debugLine="Panel.AddView(totalPosTitle, panelWidth, to";
mostCurrent._panel.AddView((android.view.View)(_totalpostitle.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=2162936;
 //BA.debugLineNum = 2162936;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2162937;
 //BA.debugLineNum = 2162937;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 2dip, Co";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (156),(int) (0),(int) (0)));
RDebugUtils.currentLine=2162938;
 //BA.debugLineNum = 2162938;BA.debugLine="Panel.Background = cd";
mostCurrent._panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2162942;
 //BA.debugLineNum = 2162942;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=2162943;
 //BA.debugLineNum = 2162943;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
RDebugUtils.currentLine=2162944;
 //BA.debugLineNum = 2162944;BA.debugLine="If count Mod numColumns = 0 Then";
if (_count%_numcolumns==0) { 
RDebugUtils.currentLine=2162945;
 //BA.debugLineNum = 2162945;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2162946;
 //BA.debugLineNum = 2162946;BA.debugLine="topPosition = topPosition + pnlHeight + p";
_topposition = (int) (_topposition+_pnlheight+_padding);
 }else {
RDebugUtils.currentLine=2162948;
 //BA.debugLineNum = 2162948;BA.debugLine="leftPosition = leftPosition + pnlWidth +";
_leftposition = (int) (_leftposition+_pnlwidth+_padding);
 };
RDebugUtils.currentLine=2162950;
 //BA.debugLineNum = 2162950;BA.debugLine="scrollHeight = scrollHeight + 175dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (175)));
 }else {
RDebugUtils.currentLine=2162952;
 //BA.debugLineNum = 2162952;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
_topposition = (int) (_topposition+_pnlheight+_padding);
RDebugUtils.currentLine=2162953;
 //BA.debugLineNum = 2162953;BA.debugLine="scrollHeight = scrollHeight + 290dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (290)));
 };
 };
 }
};
RDebugUtils.currentLine=2162958;
 //BA.debugLineNum = 2162958;BA.debugLine="scrollViewPanel4.Panel.Height = scrollHeight";
mostCurrent._scrollviewpanel4.getPanel().setHeight(_scrollheight);
RDebugUtils.currentLine=2162959;
 //BA.debugLineNum = 2162959;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break; }
case 1: {
RDebugUtils.currentLine=2162961;
 //BA.debugLineNum = 2162961;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2162962;
 //BA.debugLineNum = 2162962;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
case 2: {
RDebugUtils.currentLine=2162965;
 //BA.debugLineNum = 2162965;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=2162966;
 //BA.debugLineNum = 2162966;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=2162967;
 //BA.debugLineNum = 2162967;BA.debugLine="Log(\"No branch data returned\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22162967","No branch data returned",0);
RDebugUtils.currentLine=2162968;
 //BA.debugLineNum = 2162968;BA.debugLine="ToastMessageShow(\"No branch data available\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No branch data available"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2162969;
 //BA.debugLineNum = 2162969;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2162973;
 //BA.debugLineNum = 2162973;BA.debugLine="Dim totalBranches As Int = salesArray.Size";
_totalbranches = _salesarray.getSize();
RDebugUtils.currentLine=2162974;
 //BA.debugLineNum = 2162974;BA.debugLine="Dim branchNames(totalBranches) As String";
_branchnames = new String[_totalbranches];
java.util.Arrays.fill(_branchnames,"");
RDebugUtils.currentLine=2162975;
 //BA.debugLineNum = 2162975;BA.debugLine="Dim branchSales1(totalBranches) As Int";
_branchsales1 = new int[_totalbranches];
;
RDebugUtils.currentLine=2162976;
 //BA.debugLineNum = 2162976;BA.debugLine="Dim branchSales2(totalBranches) As Int";
_branchsales2 = new int[_totalbranches];
;
RDebugUtils.currentLine=2162977;
 //BA.debugLineNum = 2162977;BA.debugLine="Dim branchSales3(totalBranches) As Int";
_branchsales3 = new int[_totalbranches];
;
RDebugUtils.currentLine=2162978;
 //BA.debugLineNum = 2162978;BA.debugLine="Dim branchCount As Int = 0";
_branchcount = (int) (0);
RDebugUtils.currentLine=2162981;
 //BA.debugLineNum = 2162981;BA.debugLine="For i = 0 To totalBranches - 1";
{
final int step253 = 1;
final int limit253 = (int) (_totalbranches-1);
_i = (int) (0) ;
for (;_i <= limit253 ;_i = _i + step253 ) {
RDebugUtils.currentLine=2162982;
 //BA.debugLineNum = 2162982;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=2162983;
 //BA.debugLineNum = 2162983;BA.debugLine="branchNames(i) = record.GetDefault(\"branch_n";
_branchnames[_i] = BA.ObjectToString(_record.GetDefault((Object)("branch_name"),(Object)("Unknown")));
RDebugUtils.currentLine=2162984;
 //BA.debugLineNum = 2162984;BA.debugLine="branchSales1(i) = record.GetDefault(\"sales_1";
_branchsales1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_1"),(Object)(0))));
RDebugUtils.currentLine=2162985;
 //BA.debugLineNum = 2162985;BA.debugLine="branchSales2(i) = record.GetDefault(\"sales_2";
_branchsales2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_2"),(Object)(0))));
RDebugUtils.currentLine=2162986;
 //BA.debugLineNum = 2162986;BA.debugLine="branchSales3(i) = record.GetDefault(\"sales_3";
_branchsales3[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_3"),(Object)(0))));
RDebugUtils.currentLine=2162987;
 //BA.debugLineNum = 2162987;BA.debugLine="branchCount = record.GetDefault(\"total_branc";
_branchcount = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("total_branch_count"),(Object)(0))));
 }
};
RDebugUtils.currentLine=2162989;
 //BA.debugLineNum = 2162989;BA.debugLine="Log($\"branchCount:${branchCount}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("22162989",("branchCount:"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_branchcount))+""),0);
RDebugUtils.currentLine=2162991;
 //BA.debugLineNum = 2162991;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
_legend = new String[]{"Sales 1","Sales 2","Sales 3"};
RDebugUtils.currentLine=2162994;
 //BA.debugLineNum = 2162994;BA.debugLine="purchasePanel.RemoveAllViews";
mostCurrent._purchasepanel.RemoveAllViews();
RDebugUtils.currentLine=2162997;
 //BA.debugLineNum = 2162997;BA.debugLine="If barGraphInitialized = False Then";
if (_bargraphinitialized==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2162998;
 //BA.debugLineNum = 2162998;BA.debugLine="nxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._nxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=2162999;
 //BA.debugLineNum = 2162999;BA.debugLine="backbtn.Initialize(\"backbtn\")";
mostCurrent._backbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=2163000;
 //BA.debugLineNum = 2163000;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
mostCurrent._sortbtn1.Initialize(mostCurrent.activityBA,"sortBtn1");
RDebugUtils.currentLine=2163001;
 //BA.debugLineNum = 2163001;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
mostCurrent._sortbtn2.Initialize(mostCurrent.activityBA,"sortBtn2");
RDebugUtils.currentLine=2163002;
 //BA.debugLineNum = 2163002;BA.debugLine="defBtn.Initialize(\"defBtn\")";
mostCurrent._defbtn.Initialize(mostCurrent.activityBA,"defBtn");
RDebugUtils.currentLine=2163003;
 //BA.debugLineNum = 2163003;BA.debugLine="salesBtn1.Initialize(\"salesBtn1\")";
mostCurrent._salesbtn1.Initialize(mostCurrent.activityBA,"salesBtn1");
RDebugUtils.currentLine=2163004;
 //BA.debugLineNum = 2163004;BA.debugLine="salesBtn2.Initialize(\"salesBtn2\")";
mostCurrent._salesbtn2.Initialize(mostCurrent.activityBA,"salesBtn2");
RDebugUtils.currentLine=2163005;
 //BA.debugLineNum = 2163005;BA.debugLine="salesBtn3.Initialize(\"salesBtn3\")";
mostCurrent._salesbtn3.Initialize(mostCurrent.activityBA,"salesBtn3");
RDebugUtils.currentLine=2163007;
 //BA.debugLineNum = 2163007;BA.debugLine="Dim showHideBtn As Button";
mostCurrent._showhidebtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2163008;
 //BA.debugLineNum = 2163008;BA.debugLine="showHideBtn.Initialize(\"showHideBtn\")";
mostCurrent._showhidebtn.Initialize(mostCurrent.activityBA,"showHideBtn");
RDebugUtils.currentLine=2163009;
 //BA.debugLineNum = 2163009;BA.debugLine="barGraph.Initialize(Activity, purchasePanel,";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_branchsales1,_branchsales2,_branchsales3,_branchnames,_legend,(int) (10000),"Sales Per Branch",_branchsales1,"Branch",mostCurrent._nxtbtn,mostCurrent._backbtn,mostCurrent._sortbtn1,mostCurrent._sortbtn2,mostCurrent._defbtn,mostCurrent._salesbtn1,mostCurrent._salesbtn2,mostCurrent._salesbtn3,mostCurrent._showhidebtn);
RDebugUtils.currentLine=2163010;
 //BA.debugLineNum = 2163010;BA.debugLine="barGraph.totalPages = branchCount / 5";
mostCurrent._bargraph._totalpages /*int*/  = (int) (_branchcount/(double)5);
RDebugUtils.currentLine=2163011;
 //BA.debugLineNum = 2163011;BA.debugLine="barGraph.UpdateGraph";
mostCurrent._bargraph._updategraph /*String*/ (null);
RDebugUtils.currentLine=2163012;
 //BA.debugLineNum = 2163012;BA.debugLine="barGraphInitialized = True";
_bargraphinitialized = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2163013;
 //BA.debugLineNum = 2163013;BA.debugLine="Log(\"Bar graph initialized\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22163013","Bar graph initialized",0);
 }else {
RDebugUtils.currentLine=2163016;
 //BA.debugLineNum = 2163016;BA.debugLine="barGraph.pageNo = currentPage";
mostCurrent._bargraph._pageno /*int*/  = _currentpage;
RDebugUtils.currentLine=2163017;
 //BA.debugLineNum = 2163017;BA.debugLine="barGraph.sale_1 = branchSales1";
mostCurrent._bargraph._sale_1 /*int[]*/  = _branchsales1;
RDebugUtils.currentLine=2163018;
 //BA.debugLineNum = 2163018;BA.debugLine="barGraph.sale_2 = branchSales2";
mostCurrent._bargraph._sale_2 /*int[]*/  = _branchsales2;
RDebugUtils.currentLine=2163019;
 //BA.debugLineNum = 2163019;BA.debugLine="barGraph.sale_3 = branchSales3";
mostCurrent._bargraph._sale_3 /*int[]*/  = _branchsales3;
RDebugUtils.currentLine=2163020;
 //BA.debugLineNum = 2163020;BA.debugLine="barGraph.product1 = branchNames";
mostCurrent._bargraph._product1 /*String[]*/  = _branchnames;
RDebugUtils.currentLine=2163021;
 //BA.debugLineNum = 2163021;BA.debugLine="barGraph.comId1 = branchSales1 ' Assuming th";
mostCurrent._bargraph._comid1 /*int[]*/  = _branchsales1;
RDebugUtils.currentLine=2163023;
 //BA.debugLineNum = 2163023;BA.debugLine="barGraph.UpdateGraph";
mostCurrent._bargraph._updategraph /*String*/ (null);
RDebugUtils.currentLine=2163024;
 //BA.debugLineNum = 2163024;BA.debugLine="Log(\"Bar graph updated\")";
anywheresoftware.b4a.keywords.Common.LogImpl("22163024","Bar graph updated",0);
 };
RDebugUtils.currentLine=2163028;
 //BA.debugLineNum = 2163028;BA.debugLine="backbtn.Enabled = currentPage > 1";
mostCurrent._backbtn.setEnabled(_currentpage>1);
RDebugUtils.currentLine=2163029;
 //BA.debugLineNum = 2163029;BA.debugLine="nxtBtn.Enabled = salesArray.Size > 0 ' Adjust";
mostCurrent._nxtbtn.setEnabled(_salesarray.getSize()>0);
 break; }
case 3: {
RDebugUtils.currentLine=2163032;
 //BA.debugLineNum = 2163032;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2163033;
 //BA.debugLineNum = 2163033;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=2163036;
 //BA.debugLineNum = 2163036;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("22163036","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e299) {
			processBA.setLastException(e299);RDebugUtils.currentLine=2163040;
 //BA.debugLineNum = 2163040;BA.debugLine="Log(\"Error parsing data: \" & LastException.Mess";
anywheresoftware.b4a.keywords.Common.LogImpl("22163040","Error parsing data: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
RDebugUtils.currentLine=2163041;
 //BA.debugLineNum = 2163041;BA.debugLine="ToastMessageShow(\"Error parsing graph data\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing graph data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=2163044;
 //BA.debugLineNum = 2163044;BA.debugLine="Log(\"Job failed: \" & job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("22163044","Job failed: "+_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=2163045;
 //BA.debugLineNum = 2163045;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2163048;
 //BA.debugLineNum = 2163048;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=2163049;
 //BA.debugLineNum = 2163049;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="branch_selected = selectedCompany";
_branch_selected = _selectedcompany;
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="StartActivity(\"Device\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Device"));
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="End Sub";
return "";
}
public static String  _nxtbtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtbtn_click", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub nxtBtn_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="currentPage = currentPage + 1";
_currentpage = (int) (_currentpage+1);
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="Log($\"Next page: ${currentPage}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("22752514",("Next page: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+""),0);
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="LoadCompanyDataBranchGraph ' Updates graph";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="LoadCompanyData ' Updates panels";
_loadcompanydata();
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn1_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn1_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub salesBtn1_Click";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
 };
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("23080199",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
anywheresoftware.b4a.keywords.Common.LogImpl("23080200"," sales 1 Button clicked: "+_index,0);
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn2_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn2_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub salesBtn2_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
 };
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("23145735",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("23145736",_index,0);
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="Log(\"(Sale2)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("23145737","(Sale2)",0);
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="End Sub";
return "";
}
public static String  _salesbtn3_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "salesbtn3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "salesbtn3_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _index = "";
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub salesBtn3_Click";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="Dim index As String = btn.Tag";
_index = BA.ObjectToString(_btn.getTag());
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="salesData1 = index.ToLowerCase";
_salesdata1 = (int)(Double.parseDouble(_index.toLowerCase()));
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
if ((mostCurrent._sortdefaultvalue).equals("asc") || (mostCurrent._sortdefaultvalue).equals("desc")) { 
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
 };
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="Log(sortDefaultValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("23211271",mostCurrent._sortdefaultvalue,0);
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="Log(index)";
anywheresoftware.b4a.keywords.Common.LogImpl("23211273",_index,0);
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="Log(\"(Sale3)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("23211274","(Sale3)",0);
RDebugUtils.currentLine=3211275;
 //BA.debugLineNum = 3211275;BA.debugLine="End Sub";
return "";
}
public static String  _showhidebtn_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showhidebtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showhidebtn_click", null));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Public Sub showHideBtn_Click";
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="If showHide = True Then";
if (_showhide==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="showHide = False";
_showhide = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="showHide = True";
_showhide = anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=3276807;
 //BA.debugLineNum = 3276807;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=3276808;
 //BA.debugLineNum = 3276808;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn1_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn1_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub sortBtn1_Click";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="sortDefaultValue = index.ToLowerCase";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("23014661",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=3014663;
 //BA.debugLineNum = 3014663;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn2_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn2_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub sortBtn2_Click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="sortDefaultValue = index.ToLowerCase";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="LoadCompanyDataBranchGraph";
_loadcompanydatabranchgraph();
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("22949125",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="End Sub";
return "";
}
public static String  _totaltarget_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltarget_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltarget_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
String _total_count = "";
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub totalTarget_Click";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Dim target_id_btn As Label = Sender";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="Dim total_count As String = target_id_btn.Text";
_total_count = _target_id_btn.getText();
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="target_id_display.Text = target_id";
mostCurrent._target_id_display.setText(BA.ObjectToCharSequence(_target_id));
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="target_countLabel.Text = total_count";
mostCurrent._target_countlabel.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=2359303;
 //BA.debugLineNum = 2359303;BA.debugLine="End Sub";
return "";
}
public static String  _totaltargettitle_click() throws Exception{
RDebugUtils.currentModule="branch";
if (Debug.shouldDelegate(mostCurrent.activityBA, "totaltargettitle_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "totaltargettitle_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _target_id_btn = null;
String _target_id = "";
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub totalTargetTitle_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="popupPanel.Visible = True";
mostCurrent._popuppanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Dim target_id_btn As Label = Sender";
_target_id_btn = new anywheresoftware.b4a.objects.LabelWrapper();
_target_id_btn = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
_target_id = BA.ObjectToString(_target_id_btn.getTag());
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="End Sub";
return "";
}
}