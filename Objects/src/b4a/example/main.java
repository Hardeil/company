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
public static int _primaryfontsize = 0;
public static int _secondaryfontsize = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public b4a.example.bargraph _bargraph = null;
public b4a.example.bargraph _bargraphpurchase = null;
public anywheresoftware.b4a.objects.PanelWrapper _purchasepanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _barpanel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _salenxtbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _salebackbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _purchnxtbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _purchbackbtn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sortbtnpurchase1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sortbtnpurchase2 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sortbtn1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _defbtn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sortbtn2 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sales1btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sales2btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _sales3btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _defbtnpurchase = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _purch1btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _purch2btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _purch3btn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _showdetailbutton = null;
public static String[] _legend = null;
public static String[] _legendpurchase = null;
public static int _height = 0;
public anywheresoftware.b4a.objects.PanelWrapper _companypanel = null;
public static int _totalgraphdataheight = 0;
public static int _totalgetdataheight = 0;
public static String _sortdefaultvalue = "";
public static int _salesdata1 = 0;
public static int _currentpage = 0;
public static boolean _bargraphinitialized = false;
public static boolean _bargraphinitializedpurchase = false;
public static String _phpurlcompany = "";
public static float _calculatedsize = 0f;
public static int _toppositionsale = 0;
public static int _toppositionpurch = 0;
public anywheresoftware.b4a.objects.PanelWrapper _dashpanel = null;
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _myimage = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
anywheresoftware.b4a.objects.LabelWrapper _dashlabel = null;
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
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="dashPanel.Initialize(\"\")";
mostCurrent._dashpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="topPositionSale = Panel2.Height";
_toppositionsale = mostCurrent._panel2.getHeight();
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="ScrollView1.Panel.AddView(dashPanel, 5dip, Panel2";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._dashpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),mostCurrent._panel2.getHeight(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirAssets";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dashboard.png");
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="dashPanel.AddView(imgView, 0dip, 12.5dip, 15dip,";
mostCurrent._dashpanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (mostCurrent._dashpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="Dim dashLabel As Label";
_dashlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="dashLabel.Initialize(\"\")";
_dashlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="dashLabel.Text = \"Dashboard\"";
_dashlabel.setText(BA.ObjectToCharSequence("Dashboard"));
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="dashLabel.TextColor = Colors.Black";
_dashlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="dashLabel.Gravity = Gravity.CENTER_VERTICAL";
_dashlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="dashLabel.Typeface = Typeface.MONOSPACE";
_dashlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="dashPanel.AddView(dashLabel, imgView.Width + 5dip";
mostCurrent._dashpanel.AddView((android.view.View)(_dashlabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._dashpanel.getWidth(),mostCurrent._dashpanel.getHeight());
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="calculatedSize = AdjustFontSizeToHeight(dashLabel";
_calculatedsize = _adjustfontsizetoheight(_dashlabel,(float) (2));
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="dashLabel.TextSize = calculatedSize";
_dashlabel.setTextSize(_calculatedsize);
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="barPanel.Initialize(\"\")";
mostCurrent._barpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="companyPanel.Initialize(\"Panel\")";
mostCurrent._companypanel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=131113;
 //BA.debugLineNum = 131113;BA.debugLine="LoadGraphData";
_loadgraphdata();
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="LoadGraphDataPurchase";
_loadgraphdatapurchase();
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=131116;
 //BA.debugLineNum = 131116;BA.debugLine="End Sub";
return "";
}
public static float  _adjustfontsizetoheight(anywheresoftware.b4a.objects.LabelWrapper _lbl,float _fontscalefactor) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "adjustfontsizetoheight", false))
	 {return ((Float) Debug.delegate(mostCurrent.activityBA, "adjustfontsizetoheight", new Object[] {_lbl,_fontscalefactor}));}
float _fontsize = 0f;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub AdjustFontSizeToHeight(lbl As Label, fontScale";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim fontSize As Float = lbl.Height * fontScaleFac";
_fontsize = (float) (_lbl.getHeight()*_fontscalefactor/(double)_getdevicedensity());
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="lbl.TextSize = fontSize ' Apply the size directly";
_lbl.setTextSize(_fontsize);
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Return fontSize";
if (true) return _fontsize;
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="End Sub";
return 0f;
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
try {RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
mostCurrent._phpurlcompany = ("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"&company_sales="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_salesdata1))+"&sort_type="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+"");
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Job1.Initialize(\"GetCompany\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetCompany",main.getObject());
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="Job1.Download(PHPURLCompany)";
_job1._download /*String*/ (null,mostCurrent._phpurlcompany);
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Graph Data..."));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="Log(\"LoadGraphData Error: \" & LastException.Mess";
anywheresoftware.b4a.keywords.Common.LogImpl("2262152","LoadGraphData Error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="ToastMessageShow(\"Error initiating graph load: \"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error initiating graph load: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="End Sub";
return "";
}
public static String  _loadgraphdatapurchase() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadgraphdatapurchase", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadgraphdatapurchase", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub LoadGraphDataPurchase";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Try";
try {RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
mostCurrent._phpurlcompany = ("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"&company_purchase="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_salesdata1))+"&sort_type="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+"");
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="Job1.Initialize(\"GetCompanyPurchase\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetCompanyPurchase",main.getObject());
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="Job1.Download(PHPURLCompany)";
_job1._download /*String*/ (null,mostCurrent._phpurlcompany);
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Graph Data..."));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="Log(\"LoadGraphData Error: \" & LastException.Mess";
anywheresoftware.b4a.keywords.Common.LogImpl("2327688","LoadGraphData Error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="ToastMessageShow(\"Error initiating graph load: \"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error initiating graph load: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 196610;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
mostCurrent._phpurlcompany = ("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_currentpage))+"");
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",main.getObject());
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("2196616",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="End Sub";
return "";
}
public static float  _getdevicedensity() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getdevicedensity", false))
	 {return ((Float) Debug.delegate(mostCurrent.activityBA, "getdevicedensity", null));}
int _pixelwidth = 0;
int _dipwidth = 0;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub GetDeviceDensity As Float";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim pixelWidth As Int = 100%x";
_pixelwidth = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA);
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Dim dipWidth As Int = 100dip";
_dipwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Return pixelWidth / dipWidth";
if (true) return (float) (_pixelwidth/(double)_dipwidth);
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="End Sub";
return 0f;
}
public static String  _defbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "defbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "defbtn_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub defBtn_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="sortDefaultValue = \"\"";
mostCurrent._sortdefaultvalue = "";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Log(\"Default sorting applied\")";
anywheresoftware.b4a.keywords.Common.LogImpl("2851970","Default sorting applied",0);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="LoadGraphData";
_loadgraphdata();
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="End Sub";
return "";
}
public static String  _defbtnpurchase_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "defbtnpurchase_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "defbtnpurchase_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub defBtnPurchase_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="sortDefaultValue = \"\"";
mostCurrent._sortdefaultvalue = "";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Log(\"Default sorting applied for purchases\")";
anywheresoftware.b4a.keywords.Common.LogImpl("2917506","Default sorting applied for purchases",0);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="LoadGraphDataPurchase";
_loadgraphdatapurchase();
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _getdataheight = 0;
int _getcompanysalesheight = 0;
int _getcompanypurchaseheight = 0;
anywheresoftware.b4a.objects.collections.List _salesarray = null;
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
anywheresoftware.b4a.objects.collections.Map _record = null;
anywheresoftware.b4a.objects.PanelWrapper _totalsalepanel = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _myimage = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
anywheresoftware.b4a.objects.LabelWrapper _totalsalelabel = null;
anywheresoftware.b4a.objects.PanelWrapper _totalpurchasepanel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpurchaselabel = null;
int _padding = 0;
int _count = 0;
int _rownum = 0;
int _mainpanelwidth = 0;
int _panelheight = 0;
int _col = 0;
int _row = 0;
String _name = "";
int _company_id = 0;
int _total_count = 0;
int _total_pos = 0;
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
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Try";
try {RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="Dim getDataHeight As Int = 0";
_getdataheight = (int) (0);
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="Dim GetCompanySalesHeight As Int = 0";
_getcompanysalesheight = (int) (0);
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="Dim GetCompanyPurchaseHeight As Int = 0";
_getcompanypurchaseheight = (int) (0);
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetCompany","GetCompanyPurchase","GetData","UpdateData")) {
case 0: {
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
_totalcompanies = _salesarray.getSize();
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="Dim sales(totalCompanies) As Int";
_sales = new int[_totalcompanies];
;
RDebugUtils.currentLine=393236;
 //BA.debugLineNum = 393236;BA.debugLine="Dim comId(totalCompanies) As Int";
_comid = new int[_totalcompanies];
;
RDebugUtils.currentLine=393237;
 //BA.debugLineNum = 393237;BA.debugLine="Dim sales1(totalCompanies) As Int";
_sales1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=393238;
 //BA.debugLineNum = 393238;BA.debugLine="Dim sales2(totalCompanies) As Int";
_sales2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=393239;
 //BA.debugLineNum = 393239;BA.debugLine="Dim purchase(totalCompanies) As Int";
_purchase = new int[_totalcompanies];
;
RDebugUtils.currentLine=393240;
 //BA.debugLineNum = 393240;BA.debugLine="Dim purchase1(totalCompanies) As Int";
_purchase1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=393241;
 //BA.debugLineNum = 393241;BA.debugLine="Dim purchase2(totalCompanies) As Int";
_purchase2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=393242;
 //BA.debugLineNum = 393242;BA.debugLine="Dim companyName(totalCompanies) As String";
_companyname = new String[_totalcompanies];
java.util.Arrays.fill(_companyname,"");
RDebugUtils.currentLine=393243;
 //BA.debugLineNum = 393243;BA.debugLine="Dim max_value(totalCompanies) As Int";
_max_value = new int[_totalcompanies];
;
RDebugUtils.currentLine=393244;
 //BA.debugLineNum = 393244;BA.debugLine="Dim maxSale As Int = 0";
_maxsale = (int) (0);
RDebugUtils.currentLine=393246;
 //BA.debugLineNum = 393246;BA.debugLine="For i = 0 To totalCompanies - 1";
{
final int step27 = 1;
final int limit27 = (int) (_totalcompanies-1);
_i = (int) (0) ;
for (;_i <= limit27 ;_i = _i + step27 ) {
RDebugUtils.currentLine=393247;
 //BA.debugLineNum = 393247;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=393248;
 //BA.debugLineNum = 393248;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
_companyname[_i] = BA.ObjectToString(_record.GetDefault((Object)("company_name"),(Object)("Unknown")));
RDebugUtils.currentLine=393249;
 //BA.debugLineNum = 393249;BA.debugLine="comId(i) = record.GetDefault(\"company_id\", 0";
_comid[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("company_id"),(Object)(0))));
RDebugUtils.currentLine=393250;
 //BA.debugLineNum = 393250;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
_sales[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_1"),(Object)(0))));
RDebugUtils.currentLine=393251;
 //BA.debugLineNum = 393251;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
_sales1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_2"),(Object)(0))));
RDebugUtils.currentLine=393252;
 //BA.debugLineNum = 393252;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
_sales2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_3"),(Object)(0))));
RDebugUtils.currentLine=393253;
 //BA.debugLineNum = 393253;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
_purchase[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_1"),(Object)(0))));
RDebugUtils.currentLine=393254;
 //BA.debugLineNum = 393254;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
_purchase1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_2"),(Object)(0))));
RDebugUtils.currentLine=393255;
 //BA.debugLineNum = 393255;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_3";
_purchase2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_3"),(Object)(0))));
RDebugUtils.currentLine=393256;
 //BA.debugLineNum = 393256;BA.debugLine="max_value(i) = record.GetDefault(\"max_sales\"";
_max_value[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("max_sales"),(Object)(0))));
RDebugUtils.currentLine=393257;
 //BA.debugLineNum = 393257;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
_maxsale = (int) (anywheresoftware.b4a.keywords.Common.Max(_maxsale,_max_value[_i]));
 }
};
RDebugUtils.currentLine=393260;
 //BA.debugLineNum = 393260;BA.debugLine="Dim totalSalePanel As Panel";
_totalsalepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=393261;
 //BA.debugLineNum = 393261;BA.debugLine="totalSalePanel.Initialize(\"\")";
_totalsalepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393262;
 //BA.debugLineNum = 393262;BA.debugLine="totalSalePanel.Height = 40dip";
_totalsalepanel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=393263;
 //BA.debugLineNum = 393263;BA.debugLine="barPanel.Height = 530dip";
mostCurrent._barpanel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (530)));
RDebugUtils.currentLine=393264;
 //BA.debugLineNum = 393264;BA.debugLine="GetCompanySalesHeight = Panel2.Height + dashP";
_getcompanysalesheight = (int) (mostCurrent._panel2.getHeight()+mostCurrent._dashpanel.getHeight());
RDebugUtils.currentLine=393265;
 //BA.debugLineNum = 393265;BA.debugLine="If Not(barGraphInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_bargraphinitialized)) { 
RDebugUtils.currentLine=393266;
 //BA.debugLineNum = 393266;BA.debugLine="saleNxtBtn.Initialize(\"nxtBtn\")";
mostCurrent._salenxtbtn.Initialize(mostCurrent.activityBA,"nxtBtn");
RDebugUtils.currentLine=393267;
 //BA.debugLineNum = 393267;BA.debugLine="saleBackBtn.Initialize(\"backbtn\")";
mostCurrent._salebackbtn.Initialize(mostCurrent.activityBA,"backbtn");
RDebugUtils.currentLine=393268;
 //BA.debugLineNum = 393268;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
mostCurrent._sortbtn1.Initialize(mostCurrent.activityBA,"sortBtn1");
RDebugUtils.currentLine=393269;
 //BA.debugLineNum = 393269;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
mostCurrent._sortbtn2.Initialize(mostCurrent.activityBA,"sortBtn2");
RDebugUtils.currentLine=393270;
 //BA.debugLineNum = 393270;BA.debugLine="defBtn.Initialize(\"defBtn\")";
mostCurrent._defbtn.Initialize(mostCurrent.activityBA,"defBtn");
RDebugUtils.currentLine=393271;
 //BA.debugLineNum = 393271;BA.debugLine="sales1btn.Initialize(\"sales1btn\")";
mostCurrent._sales1btn.Initialize(mostCurrent.activityBA,"sales1btn");
RDebugUtils.currentLine=393272;
 //BA.debugLineNum = 393272;BA.debugLine="sales2btn.Initialize(\"sales2btn\")";
mostCurrent._sales2btn.Initialize(mostCurrent.activityBA,"sales2btn");
RDebugUtils.currentLine=393273;
 //BA.debugLineNum = 393273;BA.debugLine="sales3btn.Initialize(\"sales3btn\")";
mostCurrent._sales3btn.Initialize(mostCurrent.activityBA,"sales3btn");
RDebugUtils.currentLine=393274;
 //BA.debugLineNum = 393274;BA.debugLine="showDetailButton.Initialize(\"showDetailButto";
mostCurrent._showdetailbutton.Initialize(mostCurrent.activityBA,"showDetailButton");
RDebugUtils.currentLine=393277;
 //BA.debugLineNum = 393277;BA.debugLine="ScrollView1.Panel.AddView(totalSalePanel, 5d";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_totalsalepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),_getcompanysalesheight,mostCurrent._activity.getWidth(),_totalsalepanel.getHeight());
RDebugUtils.currentLine=393279;
 //BA.debugLineNum = 393279;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirA";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"stock.png");
RDebugUtils.currentLine=393280;
 //BA.debugLineNum = 393280;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=393281;
 //BA.debugLineNum = 393281;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393282;
 //BA.debugLineNum = 393282;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=393283;
 //BA.debugLineNum = 393283;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=393284;
 //BA.debugLineNum = 393284;BA.debugLine="totalSalePanel.AddView(imgView, 0dip, 12.5di";
_totalsalepanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_totalsalepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=393286;
 //BA.debugLineNum = 393286;BA.debugLine="Dim totalSaleLabel As Label";
_totalsalelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=393287;
 //BA.debugLineNum = 393287;BA.debugLine="totalSaleLabel.Initialize(\"\")";
_totalsalelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393288;
 //BA.debugLineNum = 393288;BA.debugLine="totalSaleLabel.Text = \"Total Sales\"";
_totalsalelabel.setText(BA.ObjectToCharSequence("Total Sales"));
RDebugUtils.currentLine=393289;
 //BA.debugLineNum = 393289;BA.debugLine="totalSaleLabel.TextColor = Colors.Black";
_totalsalelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=393290;
 //BA.debugLineNum = 393290;BA.debugLine="totalSaleLabel.Gravity = Gravity.CENTER_VERT";
_totalsalelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=393291;
 //BA.debugLineNum = 393291;BA.debugLine="totalSaleLabel.Typeface = Typeface.MONOSPACE";
_totalsalelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=393292;
 //BA.debugLineNum = 393292;BA.debugLine="totalSalePanel.AddView(totalSaleLabel, imgVi";
_totalsalepanel.AddView((android.view.View)(_totalsalelabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=393293;
 //BA.debugLineNum = 393293;BA.debugLine="AdjustFontSizeToHeight(totalSaleLabel, 2)";
_adjustfontsizetoheight(_totalsalelabel,(float) (2));
RDebugUtils.currentLine=393295;
 //BA.debugLineNum = 393295;BA.debugLine="topPositionSale = topPositionSale + totalSal";
_toppositionsale = (int) (_toppositionsale+_totalsalepanel.getHeight());
RDebugUtils.currentLine=393296;
 //BA.debugLineNum = 393296;BA.debugLine="GetCompanySalesHeight = GetCompanySalesHeigh";
_getcompanysalesheight = (int) (_getcompanysalesheight+_totalsalepanel.getHeight());
RDebugUtils.currentLine=393297;
 //BA.debugLineNum = 393297;BA.debugLine="ScrollView1.Panel.AddView(barPanel, 25dip, G";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._barpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),_getcompanysalesheight,(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),mostCurrent._barpanel.getHeight());
RDebugUtils.currentLine=393298;
 //BA.debugLineNum = 393298;BA.debugLine="barPanel.Color = Colors.White";
mostCurrent._barpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=393299;
 //BA.debugLineNum = 393299;BA.debugLine="barPanel.RemoveAllViews";
mostCurrent._barpanel.RemoveAllViews();
RDebugUtils.currentLine=393300;
 //BA.debugLineNum = 393300;BA.debugLine="barPanel.Invalidate";
mostCurrent._barpanel.Invalidate();
RDebugUtils.currentLine=393302;
 //BA.debugLineNum = 393302;BA.debugLine="GetCompanyPurchaseHeight = GetCompanySalesHe";
_getcompanypurchaseheight = (int) (_getcompanysalesheight+mostCurrent._barpanel.getHeight());
RDebugUtils.currentLine=393303;
 //BA.debugLineNum = 393303;BA.debugLine="Log($\"GetCompanyPurchaseHeight:${GetCompanyP";
anywheresoftware.b4a.keywords.Common.LogImpl("2393303",("GetCompanyPurchaseHeight:"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_getcompanypurchaseheight))+""),0);
RDebugUtils.currentLine=393304;
 //BA.debugLineNum = 393304;BA.debugLine="barGraph.Initialize(Activity, barPanel, sale";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._barpanel,_sales,_sales1,_sales2,_companyname,mostCurrent._legend,_maxsale,"Total Sale of the Company",_comid,"Branch",mostCurrent._salenxtbtn,mostCurrent._salebackbtn,mostCurrent._sortbtn1,mostCurrent._sortbtn2,mostCurrent._defbtn,mostCurrent._sales1btn,mostCurrent._sales2btn,mostCurrent._sales3btn,mostCurrent._showdetailbutton);
RDebugUtils.currentLine=393305;
 //BA.debugLineNum = 393305;BA.debugLine="barGraphInitialized = True";
_bargraphinitialized = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=393306;
 //BA.debugLineNum = 393306;BA.debugLine="topPositionSale = topPositionSale + barPanel";
_toppositionsale = (int) (_toppositionsale+mostCurrent._barpanel.getHeight());
RDebugUtils.currentLine=393307;
 //BA.debugLineNum = 393307;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 }else {
RDebugUtils.currentLine=393309;
 //BA.debugLineNum = 393309;BA.debugLine="barGraph.sale_1 = sales";
mostCurrent._bargraph._sale_1 /*int[]*/  = _sales;
RDebugUtils.currentLine=393310;
 //BA.debugLineNum = 393310;BA.debugLine="barGraph.sale_2 = sales1";
mostCurrent._bargraph._sale_2 /*int[]*/  = _sales1;
RDebugUtils.currentLine=393311;
 //BA.debugLineNum = 393311;BA.debugLine="barGraph.sale_3 = sales2";
mostCurrent._bargraph._sale_3 /*int[]*/  = _sales2;
RDebugUtils.currentLine=393312;
 //BA.debugLineNum = 393312;BA.debugLine="barGraph.product1 = companyName";
mostCurrent._bargraph._product1 /*String[]*/  = _companyname;
RDebugUtils.currentLine=393313;
 //BA.debugLineNum = 393313;BA.debugLine="barGraph.comId1 = comId ' Corrected to use c";
mostCurrent._bargraph._comid1 /*int[]*/  = _comid;
RDebugUtils.currentLine=393314;
 //BA.debugLineNum = 393314;BA.debugLine="barGraph.UpdateGraph";
mostCurrent._bargraph._updategraph /*String*/ (null);
 };
RDebugUtils.currentLine=393316;
 //BA.debugLineNum = 393316;BA.debugLine="GetCompanySalesHeight = Panel2.Height + dashP";
_getcompanysalesheight = (int) (mostCurrent._panel2.getHeight()+mostCurrent._dashpanel.getHeight()+_totalsalepanel.getHeight()+mostCurrent._barpanel.getHeight());
RDebugUtils.currentLine=393317;
 //BA.debugLineNum = 393317;BA.debugLine="topPositionSale = GetCompanySalesHeight";
_toppositionsale = _getcompanysalesheight;
RDebugUtils.currentLine=393318;
 //BA.debugLineNum = 393318;BA.debugLine="GetCompanyPurchaseHeight = GetCompanySalesHei";
_getcompanypurchaseheight = _getcompanysalesheight;
RDebugUtils.currentLine=393319;
 //BA.debugLineNum = 393319;BA.debugLine="Log($\"GetCompanyPurchaseHeight:${GetCompanyPu";
anywheresoftware.b4a.keywords.Common.LogImpl("2393319",("GetCompanyPurchaseHeight:"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_getcompanypurchaseheight))+""),0);
 break; }
case 1: {
RDebugUtils.currentLine=393321;
 //BA.debugLineNum = 393321;BA.debugLine="Log($\"topPositionSale:${topPositionSale}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("2393321",("topPositionSale:"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_toppositionsale))+""),0);
RDebugUtils.currentLine=393322;
 //BA.debugLineNum = 393322;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=393323;
 //BA.debugLineNum = 393323;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=393324;
 //BA.debugLineNum = 393324;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393325;
 //BA.debugLineNum = 393325;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=393327;
 //BA.debugLineNum = 393327;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
_totalcompanies = _salesarray.getSize();
RDebugUtils.currentLine=393328;
 //BA.debugLineNum = 393328;BA.debugLine="Dim purchase(totalCompanies) As Int";
_purchase = new int[_totalcompanies];
;
RDebugUtils.currentLine=393329;
 //BA.debugLineNum = 393329;BA.debugLine="Dim purchase1(totalCompanies) As Int";
_purchase1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=393330;
 //BA.debugLineNum = 393330;BA.debugLine="Dim purchase2(totalCompanies) As Int";
_purchase2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=393331;
 //BA.debugLineNum = 393331;BA.debugLine="Dim companyName(totalCompanies) As String";
_companyname = new String[_totalcompanies];
java.util.Arrays.fill(_companyname,"");
RDebugUtils.currentLine=393332;
 //BA.debugLineNum = 393332;BA.debugLine="Dim comId(totalCompanies) As Int";
_comid = new int[_totalcompanies];
;
RDebugUtils.currentLine=393333;
 //BA.debugLineNum = 393333;BA.debugLine="Dim maxSale As Int = 0";
_maxsale = (int) (0);
RDebugUtils.currentLine=393335;
 //BA.debugLineNum = 393335;BA.debugLine="For i = 0 To totalCompanies - 1";
{
final int step108 = 1;
final int limit108 = (int) (_totalcompanies-1);
_i = (int) (0) ;
for (;_i <= limit108 ;_i = _i + step108 ) {
RDebugUtils.currentLine=393336;
 //BA.debugLineNum = 393336;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=393337;
 //BA.debugLineNum = 393337;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
_companyname[_i] = BA.ObjectToString(_record.GetDefault((Object)("company_name"),(Object)("Unknown")));
RDebugUtils.currentLine=393338;
 //BA.debugLineNum = 393338;BA.debugLine="comId(i) = record.GetDefault(\"company_id\", 0";
_comid[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("company_id"),(Object)(0))));
RDebugUtils.currentLine=393339;
 //BA.debugLineNum = 393339;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
_purchase[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_1"),(Object)(0))));
RDebugUtils.currentLine=393340;
 //BA.debugLineNum = 393340;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
_purchase1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_2"),(Object)(0))));
RDebugUtils.currentLine=393341;
 //BA.debugLineNum = 393341;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_3";
_purchase2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_3"),(Object)(0))));
RDebugUtils.currentLine=393342;
 //BA.debugLineNum = 393342;BA.debugLine="maxSale = Max(maxSale, record.GetDefault(\"ma";
_maxsale = (int) (anywheresoftware.b4a.keywords.Common.Max(_maxsale,(double)(BA.ObjectToNumber(_record.GetDefault((Object)("max_sales"),(Object)(0))))));
 }
};
RDebugUtils.currentLine=393345;
 //BA.debugLineNum = 393345;BA.debugLine="Dim totalPurchasePanel As Panel";
_totalpurchasepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=393346;
 //BA.debugLineNum = 393346;BA.debugLine="totalPurchasePanel.Initialize(\"\")";
_totalpurchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393347;
 //BA.debugLineNum = 393347;BA.debugLine="purchasePanel.Height = 450dip";
mostCurrent._purchasepanel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (450)));
RDebugUtils.currentLine=393348;
 //BA.debugLineNum = 393348;BA.debugLine="totalPurchasePanel.Height = 40dip";
_totalpurchasepanel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=393349;
 //BA.debugLineNum = 393349;BA.debugLine="GetCompanyPurchaseHeight = 900";
_getcompanypurchaseheight = (int) (900);
RDebugUtils.currentLine=393350;
 //BA.debugLineNum = 393350;BA.debugLine="If barGraphInitializedPurchase = False Then";
if (_bargraphinitializedpurchase==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=393351;
 //BA.debugLineNum = 393351;BA.debugLine="purchNxtBtn.Initialize(\"purchNxtBtn\")";
mostCurrent._purchnxtbtn.Initialize(mostCurrent.activityBA,"purchNxtBtn");
RDebugUtils.currentLine=393352;
 //BA.debugLineNum = 393352;BA.debugLine="purchBackBtn.Initialize(\"purchBackBtn\")";
mostCurrent._purchbackbtn.Initialize(mostCurrent.activityBA,"purchBackBtn");
RDebugUtils.currentLine=393353;
 //BA.debugLineNum = 393353;BA.debugLine="sortBtnPurchase1.Initialize(\"sortBtnPurchase";
mostCurrent._sortbtnpurchase1.Initialize(mostCurrent.activityBA,"sortBtnPurchase1");
RDebugUtils.currentLine=393354;
 //BA.debugLineNum = 393354;BA.debugLine="sortBtnPurchase2.Initialize(\"sortBtnPurchase";
mostCurrent._sortbtnpurchase2.Initialize(mostCurrent.activityBA,"sortBtnPurchase2");
RDebugUtils.currentLine=393355;
 //BA.debugLineNum = 393355;BA.debugLine="defBtnPurchase.Initialize(\"defBtnPurchase\")";
mostCurrent._defbtnpurchase.Initialize(mostCurrent.activityBA,"defBtnPurchase");
RDebugUtils.currentLine=393356;
 //BA.debugLineNum = 393356;BA.debugLine="purch1btn.Initialize(\"purch1btn\")";
mostCurrent._purch1btn.Initialize(mostCurrent.activityBA,"purch1btn");
RDebugUtils.currentLine=393357;
 //BA.debugLineNum = 393357;BA.debugLine="purch2btn.Initialize(\"purch2btn\")";
mostCurrent._purch2btn.Initialize(mostCurrent.activityBA,"purch2btn");
RDebugUtils.currentLine=393358;
 //BA.debugLineNum = 393358;BA.debugLine="purch3btn.Initialize(\"purch3btn\")";
mostCurrent._purch3btn.Initialize(mostCurrent.activityBA,"purch3btn");
RDebugUtils.currentLine=393359;
 //BA.debugLineNum = 393359;BA.debugLine="showDetailButton.Initialize(\"showDetailButto";
mostCurrent._showdetailbutton.Initialize(mostCurrent.activityBA,"showDetailButton");
RDebugUtils.currentLine=393361;
 //BA.debugLineNum = 393361;BA.debugLine="ScrollView1.Panel.AddView(totalPurchasePanel";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_totalpurchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),_getcompanypurchaseheight,mostCurrent._activity.getWidth(),_totalpurchasepanel.getHeight());
RDebugUtils.currentLine=393363;
 //BA.debugLineNum = 393363;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirA";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"stock.png");
RDebugUtils.currentLine=393364;
 //BA.debugLineNum = 393364;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=393365;
 //BA.debugLineNum = 393365;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393366;
 //BA.debugLineNum = 393366;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=393367;
 //BA.debugLineNum = 393367;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=393368;
 //BA.debugLineNum = 393368;BA.debugLine="totalPurchasePanel.AddView(imgView, 0dip, 12";
_totalpurchasepanel.AddView((android.view.View)(_imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12.5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_totalpurchasepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))));
RDebugUtils.currentLine=393370;
 //BA.debugLineNum = 393370;BA.debugLine="Dim totalPurchaseLabel As Label";
_totalpurchaselabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=393371;
 //BA.debugLineNum = 393371;BA.debugLine="totalPurchaseLabel.Initialize(\"\")";
_totalpurchaselabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393372;
 //BA.debugLineNum = 393372;BA.debugLine="totalPurchaseLabel.Text = \"Total Purchases\"";
_totalpurchaselabel.setText(BA.ObjectToCharSequence("Total Purchases"));
RDebugUtils.currentLine=393373;
 //BA.debugLineNum = 393373;BA.debugLine="totalPurchaseLabel.TextColor = Colors.Black";
_totalpurchaselabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=393374;
 //BA.debugLineNum = 393374;BA.debugLine="totalPurchaseLabel.Gravity = Gravity.CENTER_";
_totalpurchaselabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=393375;
 //BA.debugLineNum = 393375;BA.debugLine="totalPurchaseLabel.Typeface = Typeface.MONOS";
_totalpurchaselabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=393376;
 //BA.debugLineNum = 393376;BA.debugLine="totalPurchasePanel.AddView(totalPurchaseLabe";
_totalpurchasepanel.AddView((android.view.View)(_totalpurchaselabel.getObject()),(int) (_imgview.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._activity.getWidth(),_totalpurchasepanel.getHeight());
RDebugUtils.currentLine=393377;
 //BA.debugLineNum = 393377;BA.debugLine="AdjustFontSizeToHeight(totalPurchaseLabel, 2";
_adjustfontsizetoheight(_totalpurchaselabel,(float) (2));
RDebugUtils.currentLine=393379;
 //BA.debugLineNum = 393379;BA.debugLine="GetCompanyPurchaseHeight = GetCompanyPurchas";
_getcompanypurchaseheight = (int) (_getcompanypurchaseheight+_totalpurchasepanel.getHeight());
RDebugUtils.currentLine=393380;
 //BA.debugLineNum = 393380;BA.debugLine="ScrollView1.Panel.AddView(purchasePanel, 25d";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),_getcompanypurchaseheight,(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),mostCurrent._purchasepanel.getHeight());
RDebugUtils.currentLine=393381;
 //BA.debugLineNum = 393381;BA.debugLine="purchasePanel.Color = Colors.White";
mostCurrent._purchasepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=393382;
 //BA.debugLineNum = 393382;BA.debugLine="purchasePanel.RemoveAllViews";
mostCurrent._purchasepanel.RemoveAllViews();
RDebugUtils.currentLine=393383;
 //BA.debugLineNum = 393383;BA.debugLine="purchasePanel.Invalidate";
mostCurrent._purchasepanel.Invalidate();
RDebugUtils.currentLine=393385;
 //BA.debugLineNum = 393385;BA.debugLine="barGraphPurchase.Initialize(Activity, purcha";
mostCurrent._bargraphpurchase._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_purchase,_purchase1,_purchase2,_companyname,mostCurrent._legendpurchase,_maxsale,"Total Purchase Per Company",_comid,"Branch",mostCurrent._purchnxtbtn,mostCurrent._purchbackbtn,mostCurrent._sortbtnpurchase1,mostCurrent._sortbtnpurchase2,mostCurrent._defbtnpurchase,mostCurrent._purch1btn,mostCurrent._purch2btn,mostCurrent._purch3btn,mostCurrent._showdetailbutton);
RDebugUtils.currentLine=393386;
 //BA.debugLineNum = 393386;BA.debugLine="barGraphInitializedPurchase = True";
_bargraphinitializedpurchase = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=393387;
 //BA.debugLineNum = 393387;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 }else {
RDebugUtils.currentLine=393389;
 //BA.debugLineNum = 393389;BA.debugLine="barGraphPurchase.sale_1 = purchase ' Adjuste";
mostCurrent._bargraphpurchase._sale_1 /*int[]*/  = _purchase;
RDebugUtils.currentLine=393390;
 //BA.debugLineNum = 393390;BA.debugLine="barGraphPurchase.sale_2 = purchase1";
mostCurrent._bargraphpurchase._sale_2 /*int[]*/  = _purchase1;
RDebugUtils.currentLine=393391;
 //BA.debugLineNum = 393391;BA.debugLine="barGraphPurchase.sale_3 = purchase2";
mostCurrent._bargraphpurchase._sale_3 /*int[]*/  = _purchase2;
RDebugUtils.currentLine=393392;
 //BA.debugLineNum = 393392;BA.debugLine="barGraphPurchase.product1 = companyName";
mostCurrent._bargraphpurchase._product1 /*String[]*/  = _companyname;
RDebugUtils.currentLine=393393;
 //BA.debugLineNum = 393393;BA.debugLine="barGraphPurchase.comId1 = comId ' Corrected";
mostCurrent._bargraphpurchase._comid1 /*int[]*/  = _comid;
RDebugUtils.currentLine=393394;
 //BA.debugLineNum = 393394;BA.debugLine="barGraphPurchase.UpdateGraph";
mostCurrent._bargraphpurchase._updategraph /*String*/ (null);
 };
RDebugUtils.currentLine=393396;
 //BA.debugLineNum = 393396;BA.debugLine="topPositionPurch = topPositionSale + totalPur";
_toppositionpurch = (int) (_toppositionsale+_totalpurchasepanel.getTop()+mostCurrent._purchasepanel.getHeight());
RDebugUtils.currentLine=393397;
 //BA.debugLineNum = 393397;BA.debugLine="ScrollView1.Panel.Height = purchasePanel.top";
mostCurrent._scrollview1.getPanel().setHeight((int) (mostCurrent._purchasepanel.getTop()+mostCurrent._purchasepanel.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (360))));
 break; }
case 2: {
RDebugUtils.currentLine=393399;
 //BA.debugLineNum = 393399;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=393400;
 //BA.debugLineNum = 393400;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=393401;
 //BA.debugLineNum = 393401;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393402;
 //BA.debugLineNum = 393402;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=393404;
 //BA.debugLineNum = 393404;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=393405;
 //BA.debugLineNum = 393405;BA.debugLine="Dim count As Int = 0";
_count = (int) (0);
RDebugUtils.currentLine=393406;
 //BA.debugLineNum = 393406;BA.debugLine="Dim rowNum As Int = 3";
_rownum = (int) (3);
RDebugUtils.currentLine=393407;
 //BA.debugLineNum = 393407;BA.debugLine="Dim mainPanelWidth As Int = 0";
_mainpanelwidth = (int) (0);
RDebugUtils.currentLine=393408;
 //BA.debugLineNum = 393408;BA.debugLine="Dim panelHeight As Int = 150dip";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150));
RDebugUtils.currentLine=393409;
 //BA.debugLineNum = 393409;BA.debugLine="height = panelHeight - 70dip";
_height = (int) (_panelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=393410;
 //BA.debugLineNum = 393410;BA.debugLine="For Each record As Map In salesArray";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group177 = _salesarray;
final int groupLen177 = group177.getSize()
;int index177 = 0;
;
for (; index177 < groupLen177;index177++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group177.Get(index177)));
RDebugUtils.currentLine=393411;
 //BA.debugLineNum = 393411;BA.debugLine="If count Mod 3 = 0 Then height = height + pa";
if (_count%3==0) { 
_height = (int) (_height+_panelheight);};
RDebugUtils.currentLine=393412;
 //BA.debugLineNum = 393412;BA.debugLine="Dim col As Int = count Mod 3";
_col = (int) (_count%3);
RDebugUtils.currentLine=393413;
 //BA.debugLineNum = 393413;BA.debugLine="Dim row As Int = Floor(count / 3)";
_row = (int) (anywheresoftware.b4a.keywords.Common.Floor(_count/(double)3));
RDebugUtils.currentLine=393414;
 //BA.debugLineNum = 393414;BA.debugLine="Dim name As String = record.Get(\"company_nam";
_name = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=393415;
 //BA.debugLineNum = 393415;BA.debugLine="Dim company_id As Int = record.Get(\"company_";
_company_id = (int)(BA.ObjectToNumber(_record.Get((Object)("company_id"))));
RDebugUtils.currentLine=393416;
 //BA.debugLineNum = 393416;BA.debugLine="Dim total_count As Int = record.Get(\"total_b";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("total_branch_count"))));
RDebugUtils.currentLine=393417;
 //BA.debugLineNum = 393417;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDevi";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=393420;
 //BA.debugLineNum = 393420;BA.debugLine="companyPanel.Initialize(\"Panel\")";
mostCurrent._companypanel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=393421;
 //BA.debugLineNum = 393421;BA.debugLine="ScrollView1.Panel.AddView(companyPanel, 25di";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._companypanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (1580),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),_height);
RDebugUtils.currentLine=393423;
 //BA.debugLineNum = 393423;BA.debugLine="mainPanelWidth = companyPanel.Width / rowNum";
_mainpanelwidth = (int) (mostCurrent._companypanel.getWidth()/(double)_rownum);
RDebugUtils.currentLine=393424;
 //BA.debugLineNum = 393424;BA.debugLine="Dim Panel As Panel";
_panel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=393425;
 //BA.debugLineNum = 393425;BA.debugLine="Panel.Initialize(\"\")";
_panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393426;
 //BA.debugLineNum = 393426;BA.debugLine="companyPanel.AddView(Panel, col * (mainPanel";
mostCurrent._companypanel.AddView((android.view.View)(_panel.getObject()),(int) (_col*(_mainpanelwidth+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)))),(int) (mostCurrent._panel2.getHeight()+(_row*(_panelheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))))),(int) (_mainpanelwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),_panelheight);
RDebugUtils.currentLine=393428;
 //BA.debugLineNum = 393428;BA.debugLine="Dim PanelTitle As Panel";
_paneltitle = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=393429;
 //BA.debugLineNum = 393429;BA.debugLine="PanelTitle.Initialize(\"Panel2\")";
_paneltitle.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=393430;
 //BA.debugLineNum = 393430;BA.debugLine="PanelTitle.Color = Colors.Black";
_paneltitle.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=393431;
 //BA.debugLineNum = 393431;BA.debugLine="PanelTitle.Tag = name";
_paneltitle.setTag((Object)(_name));
RDebugUtils.currentLine=393432;
 //BA.debugLineNum = 393432;BA.debugLine="Panel.AddView(PanelTitle, 0, 0, Panel.Width,";
_panel.AddView((android.view.View)(_paneltitle.getObject()),(int) (0),(int) (0),_panel.getWidth(),(int) (_panelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120))));
RDebugUtils.currentLine=393434;
 //BA.debugLineNum = 393434;BA.debugLine="Dim Label17 As Label";
_label17 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=393435;
 //BA.debugLineNum = 393435;BA.debugLine="Label17.Initialize(\"Label17\")";
_label17.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=393436;
 //BA.debugLineNum = 393436;BA.debugLine="Label17.Text = name.ToUpperCase";
_label17.setText(BA.ObjectToCharSequence(_name.toUpperCase()));
RDebugUtils.currentLine=393437;
 //BA.debugLineNum = 393437;BA.debugLine="Label17.Tag = company_id";
_label17.setTag((Object)(_company_id));
RDebugUtils.currentLine=393438;
 //BA.debugLineNum = 393438;BA.debugLine="Label17.TextSize = 18";
_label17.setTextSize((float) (18));
RDebugUtils.currentLine=393439;
 //BA.debugLineNum = 393439;BA.debugLine="Label17.TextColor = Colors.White";
_label17.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=393440;
 //BA.debugLineNum = 393440;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
_label17.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=393441;
 //BA.debugLineNum = 393441;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
_label17.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=393442;
 //BA.debugLineNum = 393442;BA.debugLine="PanelTitle.AddView(Label17, 5dip, 0dip, Pane";
_paneltitle.AddView((android.view.View)(_label17.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_paneltitle.getWidth(),_paneltitle.getHeight());
RDebugUtils.currentLine=393444;
 //BA.debugLineNum = 393444;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirA";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=393445;
 //BA.debugLineNum = 393445;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=393446;
 //BA.debugLineNum = 393446;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393447;
 //BA.debugLineNum = 393447;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=393448;
 //BA.debugLineNum = 393448;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393449;
 //BA.debugLineNum = 393449;BA.debugLine="imgView.Gravity = Gravity.FILL";
_imgview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=393450;
 //BA.debugLineNum = 393450;BA.debugLine="imgView.Bitmap = myImage";
_imgview.setBitmap((android.graphics.Bitmap)(_myimage.getObject()));
RDebugUtils.currentLine=393451;
 //BA.debugLineNum = 393451;BA.debugLine="PanelTitle.AddView(imgView, PanelTitle.Widt";
_paneltitle.AddView((android.view.View)(_imgview.getObject()),(int) (_paneltitle.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),(int) (_paneltitle.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 }else {
RDebugUtils.currentLine=393453;
 //BA.debugLineNum = 393453;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("2393453","Error loading image",0);
 };
RDebugUtils.currentLine=393456;
 //BA.debugLineNum = 393456;BA.debugLine="Dim panelWidth As Int = Panel.Width / 3";
_panelwidth = (int) (_panel.getWidth()/(double)3);
RDebugUtils.currentLine=393457;
 //BA.debugLineNum = 393457;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=393458;
 //BA.debugLineNum = 393458;BA.debugLine="Dim labelheight As Int = panelHeight - Panel";
_labelheight = (int) (_panelheight-_paneltitle.getHeight());
RDebugUtils.currentLine=393459;
 //BA.debugLineNum = 393459;BA.debugLine="panelWidth = Panel.Width / 2";
_panelwidth = (int) (_panel.getWidth()/(double)2);
RDebugUtils.currentLine=393461;
 //BA.debugLineNum = 393461;BA.debugLine="Dim totalStore As Label";
_totalstore = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=393462;
 //BA.debugLineNum = 393462;BA.debugLine="totalStore.Initialize(\"\")";
_totalstore.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393463;
 //BA.debugLineNum = 393463;BA.debugLine="totalStore.Text = total_count";
_totalstore.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=393464;
 //BA.debugLineNum = 393464;BA.debugLine="totalStore.TextColor = Colors.Black";
_totalstore.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=393465;
 //BA.debugLineNum = 393465;BA.debugLine="totalStore.TextSize = primaryFontSize";
_totalstore.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=393466;
 //BA.debugLineNum = 393466;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
_totalstore.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=393467;
 //BA.debugLineNum = 393467;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
_totalstore.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=393468;
 //BA.debugLineNum = 393468;BA.debugLine="Panel.AddView(totalStore, 0, PanelTitle.Heig";
_panel.AddView((android.view.View)(_totalstore.getObject()),(int) (0),_paneltitle.getHeight(),_panelwidth,(int) (_labelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))));
RDebugUtils.currentLine=393470;
 //BA.debugLineNum = 393470;BA.debugLine="Dim totalStoreLabel As Label";
_totalstorelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=393471;
 //BA.debugLineNum = 393471;BA.debugLine="totalStoreLabel.Initialize(\"\")";
_totalstorelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393472;
 //BA.debugLineNum = 393472;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
_totalstorelabel.setText(BA.ObjectToCharSequence(" Total Store"));
RDebugUtils.currentLine=393473;
 //BA.debugLineNum = 393473;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
_totalstorelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=393474;
 //BA.debugLineNum = 393474;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSize";
_totalstorelabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=393475;
 //BA.debugLineNum = 393475;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
_totalstorelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=393476;
 //BA.debugLineNum = 393476;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPAC";
_totalstorelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=393477;
 //BA.debugLineNum = 393477;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text.";
_totalstorelabel.setText(BA.ObjectToCharSequence(_totalstorelabel.getText().toUpperCase()));
RDebugUtils.currentLine=393478;
 //BA.debugLineNum = 393478;BA.debugLine="Panel.AddView(totalStoreLabel, 0, totalStore";
_panel.AddView((android.view.View)(_totalstorelabel.getObject()),(int) (0),(int) (_totalstore.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=393480;
 //BA.debugLineNum = 393480;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=393481;
 //BA.debugLineNum = 393481;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393482;
 //BA.debugLineNum = 393482;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=393483;
 //BA.debugLineNum = 393483;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=393484;
 //BA.debugLineNum = 393484;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=393485;
 //BA.debugLineNum = 393485;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=393486;
 //BA.debugLineNum = 393486;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=393487;
 //BA.debugLineNum = 393487;BA.debugLine="Panel.AddView(totalPos, panelWidth, PanelTit";
_panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,_paneltitle.getHeight(),_panelwidth,(int) (_labelheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))));
RDebugUtils.currentLine=393489;
 //BA.debugLineNum = 393489;BA.debugLine="Dim totalPosLabel As Label";
_totalposlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=393490;
 //BA.debugLineNum = 393490;BA.debugLine="totalPosLabel.Initialize(\"\")";
_totalposlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393491;
 //BA.debugLineNum = 393491;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
_totalposlabel.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=393492;
 //BA.debugLineNum = 393492;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
_totalposlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=393493;
 //BA.debugLineNum = 393493;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
_totalposlabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=393494;
 //BA.debugLineNum = 393494;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
_totalposlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=393495;
 //BA.debugLineNum = 393495;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
_totalposlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=393496;
 //BA.debugLineNum = 393496;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToUp";
_totalposlabel.setText(BA.ObjectToCharSequence(_totalposlabel.getText().toUpperCase()));
RDebugUtils.currentLine=393497;
 //BA.debugLineNum = 393497;BA.debugLine="Panel.AddView(totalPosLabel, panelWidth, tot";
_panel.AddView((android.view.View)(_totalposlabel.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=393499;
 //BA.debugLineNum = 393499;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=393500;
 //BA.debugLineNum = 393500;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 0dip, Col";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=393501;
 //BA.debugLineNum = 393501;BA.debugLine="Panel.Background = cd";
_panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=393502;
 //BA.debugLineNum = 393502;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 }
};
RDebugUtils.currentLine=393504;
 //BA.debugLineNum = 393504;BA.debugLine="totalGetDataHeight = Panel2.Height + companyP";
_totalgetdataheight = (int) (mostCurrent._panel2.getHeight()+mostCurrent._companypanel.getHeight());
 break; }
case 3: {
RDebugUtils.currentLine=393507;
 //BA.debugLineNum = 393507;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393508;
 //BA.debugLineNum = 393508;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=393510;
 //BA.debugLineNum = 393510;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("2393510","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e267) {
			processBA.setLastException(e267);RDebugUtils.currentLine=393514;
 //BA.debugLineNum = 393514;BA.debugLine="Log(\"Error parsing data: \" & LastException.Mess";
anywheresoftware.b4a.keywords.Common.LogImpl("2393514","Error parsing data: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
 }else {
RDebugUtils.currentLine=393517;
 //BA.debugLineNum = 393517;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=393519;
 //BA.debugLineNum = 393519;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=393520;
 //BA.debugLineNum = 393520;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 589825;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Starter.company_selected = selectedCompany";
mostCurrent._starter._company_selected /*String*/  = _selectedcompany;
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="End Sub";
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
anywheresoftware.b4a.keywords.Common.LogImpl("2655361","sad",0);
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _purch1btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purch1btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purch1btn_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub purch1btn_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="salesData1 = 1";
_salesdata1 = (int) (1);
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="Log(\"Purchase 1 selected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21310722","Purchase 1 selected",0);
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="If sortDefaultValue <> \"\" Then";
if ((mostCurrent._sortdefaultvalue).equals("") == false) { 
 };
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="End Sub";
return "";
}
public static String  _purch2btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purch2btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purch2btn_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub purch2btn_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="salesData1 = 2";
_salesdata1 = (int) (2);
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Log(\"Purchase 2 selected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21376258","Purchase 2 selected",0);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="If sortDefaultValue <> \"\" Then";
if ((mostCurrent._sortdefaultvalue).equals("") == false) { 
 };
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="End Sub";
return "";
}
public static String  _purch3btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "purch3btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "purch3btn_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub purch3btn_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="salesData1 = 3";
_salesdata1 = (int) (3);
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Log(\"Purchase 3 selected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21441794","Purchase 3 selected",0);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="If sortDefaultValue <> \"\" Then";
if ((mostCurrent._sortdefaultvalue).equals("") == false) { 
 };
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="End Sub";
return "";
}
public static String  _sales1btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sales1btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sales1btn_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub sales1btn_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="salesData1 = 1";
_salesdata1 = (int) (1);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Log(\"Sales 1 selected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("2983042","Sales 1 selected",0);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="If sortDefaultValue <> \"\" Then";
if ((mostCurrent._sortdefaultvalue).equals("") == false) { 
 };
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="End Sub";
return "";
}
public static String  _sales2btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sales2btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sales2btn_click", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub sales2btn_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="salesData1 = 2";
_salesdata1 = (int) (2);
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Log(\"Sales 2 selected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21048578","Sales 2 selected",0);
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="If sortDefaultValue <> \"\" Then";
if ((mostCurrent._sortdefaultvalue).equals("") == false) { 
 };
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="End Sub";
return "";
}
public static String  _sales3btn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sales3btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sales3btn_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub sales3btn_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="salesData1 = 3";
_salesdata1 = (int) (3);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Log(\"Sales 3 selected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("21114114","Sales 3 selected",0);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="If sortDefaultValue <> \"\" Then";
if ((mostCurrent._sortdefaultvalue).equals("") == false) { 
 };
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtn1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn1_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
boolean[] _checkedsales = null;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub sortBtn1_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"asc\"";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("2720901",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
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
public static String  _sortbtn2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtn2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtn2_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
boolean[] _checkedsales = null;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub sortBtn2_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"desc\"";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("2786437",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="If Not(barGraphInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_bargraphinitialized)) { 
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Graph not yet initialized."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="Dim checkedSales() As Boolean = barGraph.GetCheck";
_checkedsales = mostCurrent._bargraph._getcheckedsales /*boolean[]*/ (null);
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="If checkedSales.Length > 0 Then";
if (_checkedsales.length>0) { 
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="Select Case salesData1";
switch (_salesdata1) {
case 1: {
RDebugUtils.currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="If Not(checkedSales(0)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (0)])) { 
RDebugUtils.currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="ToastMessageShow(\"Please show Sales1 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales1 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786451;
 //BA.debugLineNum = 786451;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 2: {
RDebugUtils.currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="If Not(checkedSales(1)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (1)])) { 
RDebugUtils.currentLine=786455;
 //BA.debugLineNum = 786455;BA.debugLine="ToastMessageShow(\"Please show Sales2 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales2 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786456;
 //BA.debugLineNum = 786456;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 3: {
RDebugUtils.currentLine=786459;
 //BA.debugLineNum = 786459;BA.debugLine="If Not(checkedSales(2)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (2)])) { 
RDebugUtils.currentLine=786460;
 //BA.debugLineNum = 786460;BA.debugLine="ToastMessageShow(\"Please show Sales3 in the l";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Sales3 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786461;
 //BA.debugLineNum = 786461;BA.debugLine="Return";
if (true) return "";
 };
 break; }
}
;
 };
RDebugUtils.currentLine=786466;
 //BA.debugLineNum = 786466;BA.debugLine="LoadGraphData";
_loadgraphdata();
RDebugUtils.currentLine=786467;
 //BA.debugLineNum = 786467;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtnpurchase1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtnpurchase1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtnpurchase1_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
boolean[] _checkedsales = null;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub sortBtnPurchase1_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"desc\"";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("21179653",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="If Not(barGraphInitializedPurchase) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_bargraphinitializedpurchase)) { 
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Graph not yet initialized."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="Dim checkedSales() As Boolean = barGraphPurchase.";
_checkedsales = mostCurrent._bargraphpurchase._getcheckedsales /*boolean[]*/ (null);
RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="If checkedSales.Length > 0 Then";
if (_checkedsales.length>0) { 
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="Select Case salesData1";
switch (_salesdata1) {
case 1: {
RDebugUtils.currentLine=1179665;
 //BA.debugLineNum = 1179665;BA.debugLine="If Not(checkedSales(0)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (0)])) { 
RDebugUtils.currentLine=1179666;
 //BA.debugLineNum = 1179666;BA.debugLine="ToastMessageShow(\"Please show Purchase 1 in t";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Purchase 1 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179667;
 //BA.debugLineNum = 1179667;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 2: {
RDebugUtils.currentLine=1179670;
 //BA.debugLineNum = 1179670;BA.debugLine="If Not(checkedSales(1)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (1)])) { 
RDebugUtils.currentLine=1179671;
 //BA.debugLineNum = 1179671;BA.debugLine="ToastMessageShow(\"Please show Purchase 2 in t";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Purchase 2 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179672;
 //BA.debugLineNum = 1179672;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 3: {
RDebugUtils.currentLine=1179675;
 //BA.debugLineNum = 1179675;BA.debugLine="If Not(checkedSales(2)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (2)])) { 
RDebugUtils.currentLine=1179676;
 //BA.debugLineNum = 1179676;BA.debugLine="ToastMessageShow(\"Please show Purchase 3 in t";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Purchase 3 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179677;
 //BA.debugLineNum = 1179677;BA.debugLine="Return";
if (true) return "";
 };
 break; }
}
;
 };
RDebugUtils.currentLine=1179682;
 //BA.debugLineNum = 1179682;BA.debugLine="LoadGraphDataPurchase";
_loadgraphdatapurchase();
RDebugUtils.currentLine=1179683;
 //BA.debugLineNum = 1179683;BA.debugLine="End Sub";
return "";
}
public static String  _sortbtnpurchase2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sortbtnpurchase2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sortbtnpurchase2_click", null));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _chk = null;
String _index = "";
boolean[] _checkedsales = null;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub sortBtnPurchase2_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim chk As RadioButton = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper(), (android.widget.RadioButton)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="Dim index As String = chk.Tag";
_index = BA.ObjectToString(_chk.getTag());
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="sortDefaultValue = index.ToLowerCase ' \"desc\"";
mostCurrent._sortdefaultvalue = _index.toLowerCase();
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("21245189",("sort value: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(mostCurrent._sortdefaultvalue))+""),0);
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="If Not(barGraphInitializedPurchase) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_bargraphinitializedpurchase)) { 
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="ToastMessageShow(\"Graph not yet initialized.\", T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Graph not yet initialized."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="Dim checkedSales() As Boolean = barGraphPurchase.";
_checkedsales = mostCurrent._bargraphpurchase._getcheckedsales /*boolean[]*/ (null);
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="If checkedSales.Length > 0 Then";
if (_checkedsales.length>0) { 
RDebugUtils.currentLine=1245199;
 //BA.debugLineNum = 1245199;BA.debugLine="Select Case salesData1";
switch (_salesdata1) {
case 1: {
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="If Not(checkedSales(0)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (0)])) { 
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="ToastMessageShow(\"Please show Purchase 1 in t";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Purchase 1 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245203;
 //BA.debugLineNum = 1245203;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 2: {
RDebugUtils.currentLine=1245206;
 //BA.debugLineNum = 1245206;BA.debugLine="If Not(checkedSales(1)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (1)])) { 
RDebugUtils.currentLine=1245207;
 //BA.debugLineNum = 1245207;BA.debugLine="ToastMessageShow(\"Please show Purchase 2 in t";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Purchase 2 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245208;
 //BA.debugLineNum = 1245208;BA.debugLine="Return";
if (true) return "";
 };
 break; }
case 3: {
RDebugUtils.currentLine=1245211;
 //BA.debugLineNum = 1245211;BA.debugLine="If Not(checkedSales(2)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_checkedsales[(int) (2)])) { 
RDebugUtils.currentLine=1245212;
 //BA.debugLineNum = 1245212;BA.debugLine="ToastMessageShow(\"Please show Purchase 3 in t";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please show Purchase 3 in the legend before sorting by it."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245213;
 //BA.debugLineNum = 1245213;BA.debugLine="Return";
if (true) return "";
 };
 break; }
}
;
 };
RDebugUtils.currentLine=1245218;
 //BA.debugLineNum = 1245218;BA.debugLine="LoadGraphDataPurchase";
_loadgraphdatapurchase();
RDebugUtils.currentLine=1245219;
 //BA.debugLineNum = 1245219;BA.debugLine="End Sub";
return "";
}
}