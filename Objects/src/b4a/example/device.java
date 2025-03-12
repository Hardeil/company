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

public class device extends Activity implements B4AActivity{
	public static device mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.device");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (device).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.device");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.device", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (device) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (device) Resume **");
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
		return device.class;
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
            BA.LogInfo("** Activity (device) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (device) Pause event (activity is not paused). **");
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
            device mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (device) Resume **");
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
public static int _limit = 0;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _scrollviewpanel = null;
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
public anywheresoftware.b4a.objects.LabelWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public static int _num = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel3 = null;
public static int _pageno = 0;
public anywheresoftware.b4a.objects.LabelWrapper _pagelabel = null;
public static String _phpurl = "";
public static int _panelwidth = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _branches = null;
public anywheresoftware.b4a.objects.LabelWrapper _devices = null;
public anywheresoftware.b4a.objects.LabelWrapper _home = null;
public static int _tdleftpos = 0;
public anywheresoftware.b4a.objects.LabelWrapper _totallabel = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.branch _branch = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.PanelWrapper _tablelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _idlabel = null;
anywheresoftware.b4a.objects.LabelWrapper _devicelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _seriallabel = null;
anywheresoftware.b4a.objects.LabelWrapper _sale1label = null;
anywheresoftware.b4a.objects.LabelWrapper _sale2label = null;
anywheresoftware.b4a.objects.LabelWrapper _sale3label = null;
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient = null;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Activity.LoadLayout(\"Device\")";
mostCurrent._activity.LoadLayout("Device",mostCurrent.activityBA);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="ScrollView1.Width = 100%x";
mostCurrent._scrollview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="ScrollViewPanel.Initialize(\"\")";
mostCurrent._scrollviewpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._scrollviewpanel.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="TableDetails.Initialize";
mostCurrent._tabledetails.Initialize();
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="Dim tableLabel As Panel";
_tablelabel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="tableLabel.Initialize(\"deviceTitle\")";
_tablelabel.Initialize(mostCurrent.activityBA,"deviceTitle");
RDebugUtils.currentLine=983061;
 //BA.debugLineNum = 983061;BA.debugLine="tableLabel.Color = Colors.Black";
_tablelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=983062;
 //BA.debugLineNum = 983062;BA.debugLine="Panel1.AddView(tableLabel, 0, Panel2.Height+Panel";
mostCurrent._panel1.AddView((android.view.View)(_tablelabel.getObject()),(int) (0),(int) (mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=983064;
 //BA.debugLineNum = 983064;BA.debugLine="ScrollView1.Top = tableLabel.Height + Panel2.Heig";
mostCurrent._scrollview1.setTop((int) (_tablelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=983066;
 //BA.debugLineNum = 983066;BA.debugLine="panelWidth = tableLabel.Width /6";
_panelwidth = (int) (_tablelabel.getWidth()/(double)6);
RDebugUtils.currentLine=983068;
 //BA.debugLineNum = 983068;BA.debugLine="Dim idLabel As Label";
_idlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983069;
 //BA.debugLineNum = 983069;BA.debugLine="idLabel.Initialize(\"\")";
_idlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983070;
 //BA.debugLineNum = 983070;BA.debugLine="idLabel.Text = \"ID\"";
_idlabel.setText(BA.ObjectToCharSequence("ID"));
RDebugUtils.currentLine=983071;
 //BA.debugLineNum = 983071;BA.debugLine="idLabel.TextColor= Colors.White";
_idlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=983072;
 //BA.debugLineNum = 983072;BA.debugLine="idLabel.Gravity = Gravity.CENTER_VERTICAL";
_idlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983073;
 //BA.debugLineNum = 983073;BA.debugLine="idLabel.Typeface = Typeface.MONOSPACE";
_idlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983074;
 //BA.debugLineNum = 983074;BA.debugLine="tableLabel.AddView(idLabel,tdleftPos,0dip,panelWi";
_tablelabel.AddView((android.view.View)(_idlabel.getObject()),_tdleftpos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=983076;
 //BA.debugLineNum = 983076;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983077;
 //BA.debugLineNum = 983077;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983078;
 //BA.debugLineNum = 983078;BA.debugLine="deviceLabel.Text = \"NAME\"";
_devicelabel.setText(BA.ObjectToCharSequence("NAME"));
RDebugUtils.currentLine=983079;
 //BA.debugLineNum = 983079;BA.debugLine="deviceLabel.TextColor= Colors.White";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=983080;
 //BA.debugLineNum = 983080;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983081;
 //BA.debugLineNum = 983081;BA.debugLine="deviceLabel.Typeface = Typeface.MONOSPACE";
_devicelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983082;
 //BA.debugLineNum = 983082;BA.debugLine="tableLabel.AddView(deviceLabel,panelWidth,0,panel";
_tablelabel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=983084;
 //BA.debugLineNum = 983084;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983085;
 //BA.debugLineNum = 983085;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983086;
 //BA.debugLineNum = 983086;BA.debugLine="serialLabel.Text = \"SERIAL NUMBER\"";
_seriallabel.setText(BA.ObjectToCharSequence("SERIAL NUMBER"));
RDebugUtils.currentLine=983087;
 //BA.debugLineNum = 983087;BA.debugLine="serialLabel.TextSize = 11";
_seriallabel.setTextSize((float) (11));
RDebugUtils.currentLine=983088;
 //BA.debugLineNum = 983088;BA.debugLine="serialLabel.TextColor= Colors.White";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=983089;
 //BA.debugLineNum = 983089;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983090;
 //BA.debugLineNum = 983090;BA.debugLine="serialLabel.Typeface = Typeface.MONOSPACE";
_seriallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983091;
 //BA.debugLineNum = 983091;BA.debugLine="tableLabel.AddView(serialLabel,panelWidth*2,0,pan";
_tablelabel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=983093;
 //BA.debugLineNum = 983093;BA.debugLine="Dim sale1Label As Label";
_sale1label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983094;
 //BA.debugLineNum = 983094;BA.debugLine="sale1Label.Initialize(\"\")";
_sale1label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983095;
 //BA.debugLineNum = 983095;BA.debugLine="sale1Label.Text = \"FIRST SALE\"";
_sale1label.setText(BA.ObjectToCharSequence("FIRST SALE"));
RDebugUtils.currentLine=983096;
 //BA.debugLineNum = 983096;BA.debugLine="sale1Label.TextColor= Colors.White";
_sale1label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=983097;
 //BA.debugLineNum = 983097;BA.debugLine="sale1Label.TextSize = 11";
_sale1label.setTextSize((float) (11));
RDebugUtils.currentLine=983098;
 //BA.debugLineNum = 983098;BA.debugLine="sale1Label.Gravity = Gravity.CENTER_VERTICAL";
_sale1label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983099;
 //BA.debugLineNum = 983099;BA.debugLine="sale1Label.Typeface = Typeface.MONOSPACE";
_sale1label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983100;
 //BA.debugLineNum = 983100;BA.debugLine="tableLabel.AddView(sale1Label,panelWidth*3,0,pane";
_tablelabel.AddView((android.view.View)(_sale1label.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=983102;
 //BA.debugLineNum = 983102;BA.debugLine="Dim sale2Label As Label";
_sale2label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983103;
 //BA.debugLineNum = 983103;BA.debugLine="sale2Label.Initialize(\"\")";
_sale2label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983104;
 //BA.debugLineNum = 983104;BA.debugLine="sale2Label.Text = \"SECOND SALE\"";
_sale2label.setText(BA.ObjectToCharSequence("SECOND SALE"));
RDebugUtils.currentLine=983105;
 //BA.debugLineNum = 983105;BA.debugLine="sale2Label.TextColor= Colors.White";
_sale2label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=983106;
 //BA.debugLineNum = 983106;BA.debugLine="sale2Label.TextSize = 11";
_sale2label.setTextSize((float) (11));
RDebugUtils.currentLine=983107;
 //BA.debugLineNum = 983107;BA.debugLine="sale2Label.Gravity = Gravity.CENTER_VERTICAL";
_sale2label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983108;
 //BA.debugLineNum = 983108;BA.debugLine="sale2Label.Typeface = Typeface.MONOSPACE";
_sale2label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983109;
 //BA.debugLineNum = 983109;BA.debugLine="tableLabel.AddView(sale2Label,panelWidth*4,0,pane";
_tablelabel.AddView((android.view.View)(_sale2label.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=983111;
 //BA.debugLineNum = 983111;BA.debugLine="Dim sale3Label As Label";
_sale3label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983112;
 //BA.debugLineNum = 983112;BA.debugLine="sale3Label.Initialize(\"\")";
_sale3label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983113;
 //BA.debugLineNum = 983113;BA.debugLine="sale3Label.Text = \"THIRD SALE\"";
_sale3label.setText(BA.ObjectToCharSequence("THIRD SALE"));
RDebugUtils.currentLine=983114;
 //BA.debugLineNum = 983114;BA.debugLine="sale3Label.TextSize = 11";
_sale3label.setTextSize((float) (11));
RDebugUtils.currentLine=983115;
 //BA.debugLineNum = 983115;BA.debugLine="sale3Label.TextColor= Colors.White";
_sale3label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=983116;
 //BA.debugLineNum = 983116;BA.debugLine="sale3Label.Gravity = Gravity.CENTER_VERTICAL";
_sale3label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983117;
 //BA.debugLineNum = 983117;BA.debugLine="sale3Label.Typeface = Typeface.MONOSPACE";
_sale3label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983118;
 //BA.debugLineNum = 983118;BA.debugLine="tableLabel.AddView(sale3Label,panelWidth*5,0,pane";
_tablelabel.AddView((android.view.View)(_sale3label.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=983121;
 //BA.debugLineNum = 983121;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=983122;
 //BA.debugLineNum = 983122;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=983123;
 //BA.debugLineNum = 983123;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=983124;
 //BA.debugLineNum = 983124;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983125;
 //BA.debugLineNum = 983125;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=983126;
 //BA.debugLineNum = 983126;BA.debugLine="home.TextSize = 16 '";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=983127;
 //BA.debugLineNum = 983127;BA.debugLine="Panel4.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=983128;
 //BA.debugLineNum = 983128;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=983130;
 //BA.debugLineNum = 983130;BA.debugLine="branches.Initialize(\"branch\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"branch");
RDebugUtils.currentLine=983131;
 //BA.debugLineNum = 983131;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=983132;
 //BA.debugLineNum = 983132;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983133;
 //BA.debugLineNum = 983133;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983134;
 //BA.debugLineNum = 983134;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=983135;
 //BA.debugLineNum = 983135;BA.debugLine="branches.TextColor = Colors.Black";
mostCurrent._branches.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=983136;
 //BA.debugLineNum = 983136;BA.debugLine="Panel4.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (210)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=983139;
 //BA.debugLineNum = 983139;BA.debugLine="devices.Initialize(\"device\")";
mostCurrent._devices.Initialize(mostCurrent.activityBA,"device");
RDebugUtils.currentLine=983140;
 //BA.debugLineNum = 983140;BA.debugLine="devices.Text = \"Devices\"";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices"));
RDebugUtils.currentLine=983141;
 //BA.debugLineNum = 983141;BA.debugLine="devices.Typeface = Typeface.MONOSPACE";
mostCurrent._devices.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=983142;
 //BA.debugLineNum = 983142;BA.debugLine="devices.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._devices.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983143;
 //BA.debugLineNum = 983143;BA.debugLine="devices.TextSize = 16";
mostCurrent._devices.setTextSize((float) (16));
RDebugUtils.currentLine=983144;
 //BA.debugLineNum = 983144;BA.debugLine="Panel4.AddView(devices, branches.Left + branches.";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._devices.getObject()),(int) (mostCurrent._branches.getLeft()+mostCurrent._branches.getWidth()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=983145;
 //BA.debugLineNum = 983145;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=983147;
 //BA.debugLineNum = 983147;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=983148;
 //BA.debugLineNum = 983148;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=983149;
 //BA.debugLineNum = 983149;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=983151;
 //BA.debugLineNum = 983151;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=983152;
 //BA.debugLineNum = 983152;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="PHPURL = \"https://192.168.8.117/Company/fetch.php";
mostCurrent._phpurl = "https://192.168.8.117/Company/fetch.php?action=get_device&id="+mostCurrent._branch._branch_selected /*String*/ +"&page="+BA.NumberToString(_pageno)+"&limit="+BA.NumberToString(_limit);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Log(PHPURL)";
anywheresoftware.b4a.keywords.Common.LogImpl("31114114",mostCurrent._phpurl,0);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Job1.Initialize(\"\", Me)";
_job1._initialize /*String*/ (null,processBA,"",device.getObject());
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="device";
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub backBtn_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="If pageNo > 1 Then";
if (_pageno>1) { 
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="pageNo = pageNo - 1";
_pageno = (int) (_pageno-1);
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="num = 1";
_num = (int) (1);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 };
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="End Sub";
return "";
}
public static String  _branch_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "branch_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "branch_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub branch_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _ypos = 0;
int _margin = 0;
int _totalheight = 0;
int _totaldevices = 0;
int _tdfontsize = 0;
anywheresoftware.b4a.objects.collections.Map _record = null;
String _serial_num = "";
String _sales1 = "";
String _sales2 = "";
String _sales3 = "";
int _id = 0;
String _comname = "";
anywheresoftware.b4a.objects.PanelWrapper _itempanel = null;
anywheresoftware.b4a.objects.LabelWrapper _number = null;
anywheresoftware.b4a.objects.LabelWrapper _devicelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _seriallabel = null;
anywheresoftware.b4a.objects.LabelWrapper _sale = null;
anywheresoftware.b4a.objects.LabelWrapper _sale1 = null;
anywheresoftware.b4a.objects.LabelWrapper _sale2 = null;
anywheresoftware.b4a.objects.LabelWrapper _backbtn = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
anywheresoftware.b4a.objects.LabelWrapper _nxtlabel = null;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="Try";
try {RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="ScrollViewPanel.RemoveAllViews";
mostCurrent._scrollviewpanel.RemoveAllViews();
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="Dim YPos As Int = 0";
_ypos = (int) (0);
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="Dim Margin As Int = 0dip";
_margin = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0));
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="Dim TotalHeight As Int = 0";
_totalheight = (int) (0);
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="Dim totalDevices As Int = 0";
_totaldevices = (int) (0);
RDebugUtils.currentLine=1310733;
 //BA.debugLineNum = 1310733;BA.debugLine="YPos = YPos + 0%y + Margin";
_ypos = (int) (_ypos+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA)+_margin);
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="Dim tdFontSize As Int = 13";
_tdfontsize = (int) (13);
RDebugUtils.currentLine=1310736;
 //BA.debugLineNum = 1310736;BA.debugLine="TotalLabel.Initialize(\"TotalLabel\")";
mostCurrent._totallabel.Initialize(mostCurrent.activityBA,"TotalLabel");
RDebugUtils.currentLine=1310737;
 //BA.debugLineNum = 1310737;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group16 = mostCurrent._tabledetails;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group16.Get(index16)));
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="Dim serial_num As String = record.Get(\"serial\"";
_serial_num = BA.ObjectToString(_record.Get((Object)("serial")));
RDebugUtils.currentLine=1310740;
 //BA.debugLineNum = 1310740;BA.debugLine="Dim sales1 As String = record.Get(\"sales1\")";
_sales1 = BA.ObjectToString(_record.Get((Object)("sales1")));
RDebugUtils.currentLine=1310741;
 //BA.debugLineNum = 1310741;BA.debugLine="Dim sales2 As String = record.Get(\"sales2\")";
_sales2 = BA.ObjectToString(_record.Get((Object)("sales2")));
RDebugUtils.currentLine=1310742;
 //BA.debugLineNum = 1310742;BA.debugLine="Dim sales3 As String = record.Get(\"sales3\")";
_sales3 = BA.ObjectToString(_record.Get((Object)("sales3")));
RDebugUtils.currentLine=1310744;
 //BA.debugLineNum = 1310744;BA.debugLine="Dim id As Int = 0";
_id = (int) (0);
RDebugUtils.currentLine=1310745;
 //BA.debugLineNum = 1310745;BA.debugLine="totalDevices = record.Get(\"totalDevices\")";
_totaldevices = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=1310746;
 //BA.debugLineNum = 1310746;BA.debugLine="Dim comName As String = record.Get(\"comName\")";
_comname = BA.ObjectToString(_record.Get((Object)("comName")));
RDebugUtils.currentLine=1310747;
 //BA.debugLineNum = 1310747;BA.debugLine="LabelTitle.Text = record.Get(\"branchName\")";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_record.Get((Object)("branchName"))));
RDebugUtils.currentLine=1310748;
 //BA.debugLineNum = 1310748;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCase";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=1310750;
 //BA.debugLineNum = 1310750;BA.debugLine="Label1.Text = comName";
mostCurrent._label1.setText(BA.ObjectToCharSequence(_comname));
RDebugUtils.currentLine=1310751;
 //BA.debugLineNum = 1310751;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=1310753;
 //BA.debugLineNum = 1310753;BA.debugLine="branches.Text = \"Branches - \"&comName&\" |\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_comname+" |"));
RDebugUtils.currentLine=1310754;
 //BA.debugLineNum = 1310754;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=1310756;
 //BA.debugLineNum = 1310756;BA.debugLine="devices.Text = \"Devices - \"&record.Get(\"branch";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices - "+BA.ObjectToString(_record.Get((Object)("branchName")))));
RDebugUtils.currentLine=1310757;
 //BA.debugLineNum = 1310757;BA.debugLine="devices.Text = devices.Text.ToUpperCase";
mostCurrent._devices.setText(BA.ObjectToCharSequence(mostCurrent._devices.getText().toUpperCase()));
RDebugUtils.currentLine=1310759;
 //BA.debugLineNum = 1310759;BA.debugLine="Dim ItemPanel As Panel";
_itempanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1310760;
 //BA.debugLineNum = 1310760;BA.debugLine="ItemPanel.Initialize(\"\")";
_itempanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1310761;
 //BA.debugLineNum = 1310761;BA.debugLine="ItemPanel.SetLayout(0, YPos, ScrollView1.Width";
_itempanel.SetLayout((int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
RDebugUtils.currentLine=1310762;
 //BA.debugLineNum = 1310762;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_itempanel.getObject()),(int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=1310763;
 //BA.debugLineNum = 1310763;BA.debugLine="panelWidth = ItemPanel.Width /6";
_panelwidth = (int) (_itempanel.getWidth()/(double)6);
RDebugUtils.currentLine=1310764;
 //BA.debugLineNum = 1310764;BA.debugLine="If num Mod 2 = 0 Then";
if (_num%2==0) { 
RDebugUtils.currentLine=1310765;
 //BA.debugLineNum = 1310765;BA.debugLine="ItemPanel.Color = Colors.LightGray";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 }else {
RDebugUtils.currentLine=1310767;
 //BA.debugLineNum = 1310767;BA.debugLine="ItemPanel.Color = Colors.ARGB(255, 251, 251,";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
 };
RDebugUtils.currentLine=1310770;
 //BA.debugLineNum = 1310770;BA.debugLine="Dim number As Label";
_number = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1310771;
 //BA.debugLineNum = 1310771;BA.debugLine="number.Initialize(\"\")";
_number.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1310772;
 //BA.debugLineNum = 1310772;BA.debugLine="number.Text = id";
_number.setText(BA.ObjectToCharSequence(_id));
RDebugUtils.currentLine=1310773;
 //BA.debugLineNum = 1310773;BA.debugLine="number.TextSize = tdFontSize";
_number.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=1310774;
 //BA.debugLineNum = 1310774;BA.debugLine="number.TextColor = Colors.Black";
_number.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310775;
 //BA.debugLineNum = 1310775;BA.debugLine="number.Gravity = Gravity.CENTER_VERTICAL";
_number.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1310776;
 //BA.debugLineNum = 1310776;BA.debugLine="number.Typeface = Typeface.MONOSPACE";
_number.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1310777;
 //BA.debugLineNum = 1310777;BA.debugLine="ItemPanel.AddView(number, tdleftPos, 0, panelW";
_itempanel.AddView((android.view.View)(_number.getObject()),_tdleftpos,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=1310779;
 //BA.debugLineNum = 1310779;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1310780;
 //BA.debugLineNum = 1310780;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1310781;
 //BA.debugLineNum = 1310781;BA.debugLine="deviceLabel.Text = \"Pos0\"&id";
_devicelabel.setText(BA.ObjectToCharSequence("Pos0"+BA.NumberToString(_id)));
RDebugUtils.currentLine=1310782;
 //BA.debugLineNum = 1310782;BA.debugLine="deviceLabel.TextSize = tdFontSize";
_devicelabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=1310783;
 //BA.debugLineNum = 1310783;BA.debugLine="deviceLabel.TextColor = Colors.Black";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310784;
 //BA.debugLineNum = 1310784;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1310785;
 //BA.debugLineNum = 1310785;BA.debugLine="ItemPanel.AddView(deviceLabel, panelWidth, 0,";
_itempanel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=1310787;
 //BA.debugLineNum = 1310787;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1310788;
 //BA.debugLineNum = 1310788;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1310789;
 //BA.debugLineNum = 1310789;BA.debugLine="serialLabel.Text = serial_num";
_seriallabel.setText(BA.ObjectToCharSequence(_serial_num));
RDebugUtils.currentLine=1310790;
 //BA.debugLineNum = 1310790;BA.debugLine="serialLabel.TextSize = tdFontSize";
_seriallabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=1310791;
 //BA.debugLineNum = 1310791;BA.debugLine="serialLabel.TextColor = Colors.Black";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310792;
 //BA.debugLineNum = 1310792;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1310793;
 //BA.debugLineNum = 1310793;BA.debugLine="ItemPanel.AddView(serialLabel, panelWidth*2, 0";
_itempanel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=1310795;
 //BA.debugLineNum = 1310795;BA.debugLine="Dim sale As Label";
_sale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1310796;
 //BA.debugLineNum = 1310796;BA.debugLine="sale.Initialize(\"\")";
_sale.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1310797;
 //BA.debugLineNum = 1310797;BA.debugLine="sale.Text = sales1";
_sale.setText(BA.ObjectToCharSequence(_sales1));
RDebugUtils.currentLine=1310798;
 //BA.debugLineNum = 1310798;BA.debugLine="sale.TextSize = tdFontSize";
_sale.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=1310799;
 //BA.debugLineNum = 1310799;BA.debugLine="sale.TextColor = Colors.Black";
_sale.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310800;
 //BA.debugLineNum = 1310800;BA.debugLine="sale.Gravity = Gravity.CENTER_VERTICAL";
_sale.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1310801;
 //BA.debugLineNum = 1310801;BA.debugLine="ItemPanel.AddView(sale, panelWidth*3, 0, panel";
_itempanel.AddView((android.view.View)(_sale.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=1310803;
 //BA.debugLineNum = 1310803;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1310804;
 //BA.debugLineNum = 1310804;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1310805;
 //BA.debugLineNum = 1310805;BA.debugLine="sale1.Text = sales2";
_sale1.setText(BA.ObjectToCharSequence(_sales2));
RDebugUtils.currentLine=1310806;
 //BA.debugLineNum = 1310806;BA.debugLine="sale1.TextSize = tdFontSize";
_sale1.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=1310807;
 //BA.debugLineNum = 1310807;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310808;
 //BA.debugLineNum = 1310808;BA.debugLine="sale1.Gravity = Gravity.CENTER_VERTICAL";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1310809;
 //BA.debugLineNum = 1310809;BA.debugLine="ItemPanel.AddView(sale1, panelWidth*4, 0, pane";
_itempanel.AddView((android.view.View)(_sale1.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=1310811;
 //BA.debugLineNum = 1310811;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1310812;
 //BA.debugLineNum = 1310812;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1310813;
 //BA.debugLineNum = 1310813;BA.debugLine="sale2.Text = sales3";
_sale2.setText(BA.ObjectToCharSequence(_sales3));
RDebugUtils.currentLine=1310814;
 //BA.debugLineNum = 1310814;BA.debugLine="sale2.TextSize = tdFontSize";
_sale2.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=1310815;
 //BA.debugLineNum = 1310815;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310816;
 //BA.debugLineNum = 1310816;BA.debugLine="sale2.Gravity = Gravity.CENTER_VERTICAL";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1310817;
 //BA.debugLineNum = 1310817;BA.debugLine="ItemPanel.AddView(sale2, panelWidth*5, 0, pane";
_itempanel.AddView((android.view.View)(_sale2.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=1310819;
 //BA.debugLineNum = 1310819;BA.debugLine="Dim backBtn As Label";
_backbtn = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1310820;
 //BA.debugLineNum = 1310820;BA.debugLine="backBtn.Initialize(\"backBtn\")";
_backbtn.Initialize(mostCurrent.activityBA,"backBtn");
RDebugUtils.currentLine=1310821;
 //BA.debugLineNum = 1310821;BA.debugLine="backBtn.TextColor =Colors.White";
_backbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1310822;
 //BA.debugLineNum = 1310822;BA.debugLine="backBtn.Text = \"<\"";
_backbtn.setText(BA.ObjectToCharSequence("<"));
RDebugUtils.currentLine=1310823;
 //BA.debugLineNum = 1310823;BA.debugLine="backBtn.Gravity = Gravity.CENTER";
_backbtn.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1310824;
 //BA.debugLineNum = 1310824;BA.debugLine="backBtn.Typeface = Typeface.SERIF";
_backbtn.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1310825;
 //BA.debugLineNum = 1310825;BA.debugLine="backBtn.Color = Colors.Black";
_backbtn.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310826;
 //BA.debugLineNum = 1310826;BA.debugLine="backBtn.TextSize = 25";
_backbtn.setTextSize((float) (25));
RDebugUtils.currentLine=1310827;
 //BA.debugLineNum = 1310827;BA.debugLine="Panel3.AddView(backBtn,3dip,5dip,50dip,Panel3.";
mostCurrent._panel3.AddView((android.view.View)(_backbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=1310829;
 //BA.debugLineNum = 1310829;BA.debugLine="pageLabel.Initialize(\"pageLabel\")";
mostCurrent._pagelabel.Initialize(mostCurrent.activityBA,"pageLabel");
RDebugUtils.currentLine=1310830;
 //BA.debugLineNum = 1310830;BA.debugLine="pageLabel.TextColor =Colors.Black";
mostCurrent._pagelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310831;
 //BA.debugLineNum = 1310831;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=1310832;
 //BA.debugLineNum = 1310832;BA.debugLine="pageLabel.Gravity = Gravity.CENTER";
mostCurrent._pagelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1310833;
 //BA.debugLineNum = 1310833;BA.debugLine="pageLabel.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._pagelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1310834;
 //BA.debugLineNum = 1310834;BA.debugLine="pageLabel.Color = Colors.white";
mostCurrent._pagelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1310835;
 //BA.debugLineNum = 1310835;BA.debugLine="pageLabel.TextSize = 15";
mostCurrent._pagelabel.setTextSize((float) (15));
RDebugUtils.currentLine=1310836;
 //BA.debugLineNum = 1310836;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1310837;
 //BA.debugLineNum = 1310837;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310838;
 //BA.debugLineNum = 1310838;BA.debugLine="Panel3.AddView(pageLabel,backBtn.Width+backBtn";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._pagelabel.getObject()),(int) (_backbtn.getWidth()+_backbtn.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
RDebugUtils.currentLine=1310840;
 //BA.debugLineNum = 1310840;BA.debugLine="Dim nxtLabel As Label";
_nxtlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1310841;
 //BA.debugLineNum = 1310841;BA.debugLine="nxtLabel.Initialize(\"nxtLabel\")";
_nxtlabel.Initialize(mostCurrent.activityBA,"nxtLabel");
RDebugUtils.currentLine=1310842;
 //BA.debugLineNum = 1310842;BA.debugLine="nxtLabel.TextColor =Colors.White";
_nxtlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1310843;
 //BA.debugLineNum = 1310843;BA.debugLine="nxtLabel.Text = \">\"";
_nxtlabel.setText(BA.ObjectToCharSequence(">"));
RDebugUtils.currentLine=1310844;
 //BA.debugLineNum = 1310844;BA.debugLine="nxtLabel.Gravity = Gravity.CENTER";
_nxtlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1310845;
 //BA.debugLineNum = 1310845;BA.debugLine="nxtLabel.Typeface = Typeface.SERIF";
_nxtlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=1310846;
 //BA.debugLineNum = 1310846;BA.debugLine="nxtLabel.Color = Colors.black";
_nxtlabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1310847;
 //BA.debugLineNum = 1310847;BA.debugLine="nxtLabel.TextSize = 25";
_nxtlabel.setTextSize((float) (25));
RDebugUtils.currentLine=1310848;
 //BA.debugLineNum = 1310848;BA.debugLine="Panel3.AddView(nxtLabel,pageLabel.Width+pageLa";
mostCurrent._panel3.AddView((android.view.View)(_nxtlabel.getObject()),(int) (mostCurrent._pagelabel.getWidth()+mostCurrent._pagelabel.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=1310850;
 //BA.debugLineNum = 1310850;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1310851;
 //BA.debugLineNum = 1310851;BA.debugLine="cd.Initialize2(Colors.Black, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1310852;
 //BA.debugLineNum = 1310852;BA.debugLine="backBtn.Background = cd";
_backbtn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=1310853;
 //BA.debugLineNum = 1310853;BA.debugLine="nxtLabel.Background = cd";
_nxtlabel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=1310857;
 //BA.debugLineNum = 1310857;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin ' Upda";
_ypos = (int) (_ypos+_itempanel.getHeight()+_margin);
RDebugUtils.currentLine=1310858;
 //BA.debugLineNum = 1310858;BA.debugLine="nxtLabel.Enabled = False";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310859;
 //BA.debugLineNum = 1310859;BA.debugLine="If limit * pageNo < totalDevices Then";
if (_limit*_pageno<_totaldevices) { 
RDebugUtils.currentLine=1310860;
 //BA.debugLineNum = 1310860;BA.debugLine="nxtLabel.Enabled = True";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1310864;
 //BA.debugLineNum = 1310864;BA.debugLine="TotalHeight = TotalHeight + 65dip";
_totalheight = (int) (_totalheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65)));
RDebugUtils.currentLine=1310865;
 //BA.debugLineNum = 1310865;BA.debugLine="ScrollView1.Panel.Height =TotalHeight";
mostCurrent._scrollview1.getPanel().setHeight(_totalheight);
RDebugUtils.currentLine=1310866;
 //BA.debugLineNum = 1310866;BA.debugLine="num = num +1";
_num = (int) (_num+1);
RDebugUtils.currentLine=1310867;
 //BA.debugLineNum = 1310867;BA.debugLine="TotalLabel.Text = \"\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=1310871;
 //BA.debugLineNum = 1310871;BA.debugLine="TotalLabel.RemoveView";
mostCurrent._totallabel.RemoveView();
RDebugUtils.currentLine=1310872;
 //BA.debugLineNum = 1310872;BA.debugLine="TotalLabel.TextColor =Colors.White";
mostCurrent._totallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1310873;
 //BA.debugLineNum = 1310873;BA.debugLine="TotalLabel.Text = num&\" out of \"&totalDevices&\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(BA.NumberToString(_num)+" out of "+BA.NumberToString(_totaldevices)+" devices"));
RDebugUtils.currentLine=1310874;
 //BA.debugLineNum = 1310874;BA.debugLine="TotalLabel.Gravity = Gravity.CENTER";
mostCurrent._totallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1310875;
 //BA.debugLineNum = 1310875;BA.debugLine="TotalLabel.Typeface = Typeface.MONOSPACE";
mostCurrent._totallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1310876;
 //BA.debugLineNum = 1310876;BA.debugLine="TotalLabel.Color = Colors.Transparent";
mostCurrent._totallabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=1310877;
 //BA.debugLineNum = 1310877;BA.debugLine="TotalLabel.TextSize = 15";
mostCurrent._totallabel.setTextSize((float) (15));
RDebugUtils.currentLine=1310879;
 //BA.debugLineNum = 1310879;BA.debugLine="Panel3.AddView(TotalLabel,Panel3.Width-240dip,5";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._totallabel.getObject()),(int) (mostCurrent._panel3.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (240))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (230)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 } 
       catch (Exception e136) {
			processBA.setLastException(e136); };
 }else {
RDebugUtils.currentLine=1310885;
 //BA.debugLineNum = 1310885;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1310888;
 //BA.debugLineNum = 1310888;BA.debugLine="End Sub";
return "";
}
public static String  _nxtlabel_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtlabel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtlabel_click", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub nxtLabel_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="pageNo = pageNo + 1";
_pageno = (int) (_pageno+1);
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="End Sub";
return "";
}
}