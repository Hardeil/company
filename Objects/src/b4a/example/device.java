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
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Activity.LoadLayout(\"Device\")";
mostCurrent._activity.LoadLayout("Device",mostCurrent.activityBA);
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="ScrollView1.Width = 100%x";
mostCurrent._scrollview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="ScrollViewPanel.Initialize(\"\")";
mostCurrent._scrollviewpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._scrollviewpanel.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="TableDetails.Initialize";
mostCurrent._tabledetails.Initialize();
RDebugUtils.currentLine=1769491;
 //BA.debugLineNum = 1769491;BA.debugLine="Dim tableLabel As Panel";
_tablelabel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1769492;
 //BA.debugLineNum = 1769492;BA.debugLine="tableLabel.Initialize(\"deviceTitle\")";
_tablelabel.Initialize(mostCurrent.activityBA,"deviceTitle");
RDebugUtils.currentLine=1769493;
 //BA.debugLineNum = 1769493;BA.debugLine="tableLabel.Color = Colors.Black";
_tablelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1769494;
 //BA.debugLineNum = 1769494;BA.debugLine="Panel1.AddView(tableLabel, 0, Panel2.Height+Panel";
mostCurrent._panel1.AddView((android.view.View)(_tablelabel.getObject()),(int) (0),(int) (mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=1769496;
 //BA.debugLineNum = 1769496;BA.debugLine="ScrollView1.Top = tableLabel.Height + Panel2.Heig";
mostCurrent._scrollview1.setTop((int) (_tablelabel.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=1769498;
 //BA.debugLineNum = 1769498;BA.debugLine="panelWidth = tableLabel.Width /6";
_panelwidth = (int) (_tablelabel.getWidth()/(double)6);
RDebugUtils.currentLine=1769500;
 //BA.debugLineNum = 1769500;BA.debugLine="Dim idLabel As Label";
_idlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769501;
 //BA.debugLineNum = 1769501;BA.debugLine="idLabel.Initialize(\"\")";
_idlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769502;
 //BA.debugLineNum = 1769502;BA.debugLine="idLabel.Text = \"ID\"";
_idlabel.setText(BA.ObjectToCharSequence("ID"));
RDebugUtils.currentLine=1769503;
 //BA.debugLineNum = 1769503;BA.debugLine="idLabel.TextColor= Colors.White";
_idlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769504;
 //BA.debugLineNum = 1769504;BA.debugLine="idLabel.Gravity = Gravity.CENTER_VERTICAL";
_idlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769505;
 //BA.debugLineNum = 1769505;BA.debugLine="idLabel.Typeface = Typeface.MONOSPACE";
_idlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769506;
 //BA.debugLineNum = 1769506;BA.debugLine="tableLabel.AddView(idLabel,tdleftPos,0dip,panelWi";
_tablelabel.AddView((android.view.View)(_idlabel.getObject()),_tdleftpos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=1769508;
 //BA.debugLineNum = 1769508;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769509;
 //BA.debugLineNum = 1769509;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769510;
 //BA.debugLineNum = 1769510;BA.debugLine="deviceLabel.Text = \"NAME\"";
_devicelabel.setText(BA.ObjectToCharSequence("NAME"));
RDebugUtils.currentLine=1769511;
 //BA.debugLineNum = 1769511;BA.debugLine="deviceLabel.TextColor= Colors.White";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769512;
 //BA.debugLineNum = 1769512;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769513;
 //BA.debugLineNum = 1769513;BA.debugLine="deviceLabel.Typeface = Typeface.MONOSPACE";
_devicelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769514;
 //BA.debugLineNum = 1769514;BA.debugLine="tableLabel.AddView(deviceLabel,panelWidth,0,panel";
_tablelabel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=1769516;
 //BA.debugLineNum = 1769516;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769517;
 //BA.debugLineNum = 1769517;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769518;
 //BA.debugLineNum = 1769518;BA.debugLine="serialLabel.Text = \"SERIAL NUMBER\"";
_seriallabel.setText(BA.ObjectToCharSequence("SERIAL NUMBER"));
RDebugUtils.currentLine=1769519;
 //BA.debugLineNum = 1769519;BA.debugLine="serialLabel.TextSize = 11";
_seriallabel.setTextSize((float) (11));
RDebugUtils.currentLine=1769520;
 //BA.debugLineNum = 1769520;BA.debugLine="serialLabel.TextColor= Colors.White";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769521;
 //BA.debugLineNum = 1769521;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769522;
 //BA.debugLineNum = 1769522;BA.debugLine="serialLabel.Typeface = Typeface.MONOSPACE";
_seriallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769523;
 //BA.debugLineNum = 1769523;BA.debugLine="tableLabel.AddView(serialLabel,panelWidth*2,0,pan";
_tablelabel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=1769525;
 //BA.debugLineNum = 1769525;BA.debugLine="Dim sale1Label As Label";
_sale1label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769526;
 //BA.debugLineNum = 1769526;BA.debugLine="sale1Label.Initialize(\"\")";
_sale1label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769527;
 //BA.debugLineNum = 1769527;BA.debugLine="sale1Label.Text = \"FIRST SALE\"";
_sale1label.setText(BA.ObjectToCharSequence("FIRST SALE"));
RDebugUtils.currentLine=1769528;
 //BA.debugLineNum = 1769528;BA.debugLine="sale1Label.TextColor= Colors.White";
_sale1label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769529;
 //BA.debugLineNum = 1769529;BA.debugLine="sale1Label.TextSize = 11";
_sale1label.setTextSize((float) (11));
RDebugUtils.currentLine=1769530;
 //BA.debugLineNum = 1769530;BA.debugLine="sale1Label.Gravity = Gravity.CENTER_VERTICAL";
_sale1label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769531;
 //BA.debugLineNum = 1769531;BA.debugLine="sale1Label.Typeface = Typeface.MONOSPACE";
_sale1label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769532;
 //BA.debugLineNum = 1769532;BA.debugLine="tableLabel.AddView(sale1Label,panelWidth*3,0,pane";
_tablelabel.AddView((android.view.View)(_sale1label.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=1769534;
 //BA.debugLineNum = 1769534;BA.debugLine="Dim sale2Label As Label";
_sale2label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769535;
 //BA.debugLineNum = 1769535;BA.debugLine="sale2Label.Initialize(\"\")";
_sale2label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769536;
 //BA.debugLineNum = 1769536;BA.debugLine="sale2Label.Text = \"SECOND SALE\"";
_sale2label.setText(BA.ObjectToCharSequence("SECOND SALE"));
RDebugUtils.currentLine=1769537;
 //BA.debugLineNum = 1769537;BA.debugLine="sale2Label.TextColor= Colors.White";
_sale2label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769538;
 //BA.debugLineNum = 1769538;BA.debugLine="sale2Label.TextSize = 11";
_sale2label.setTextSize((float) (11));
RDebugUtils.currentLine=1769539;
 //BA.debugLineNum = 1769539;BA.debugLine="sale2Label.Gravity = Gravity.CENTER_VERTICAL";
_sale2label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769540;
 //BA.debugLineNum = 1769540;BA.debugLine="sale2Label.Typeface = Typeface.MONOSPACE";
_sale2label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769541;
 //BA.debugLineNum = 1769541;BA.debugLine="tableLabel.AddView(sale2Label,panelWidth*4,0,pane";
_tablelabel.AddView((android.view.View)(_sale2label.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=1769543;
 //BA.debugLineNum = 1769543;BA.debugLine="Dim sale3Label As Label";
_sale3label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1769544;
 //BA.debugLineNum = 1769544;BA.debugLine="sale3Label.Initialize(\"\")";
_sale3label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1769545;
 //BA.debugLineNum = 1769545;BA.debugLine="sale3Label.Text = \"THIRD SALE\"";
_sale3label.setText(BA.ObjectToCharSequence("THIRD SALE"));
RDebugUtils.currentLine=1769546;
 //BA.debugLineNum = 1769546;BA.debugLine="sale3Label.TextSize = 11";
_sale3label.setTextSize((float) (11));
RDebugUtils.currentLine=1769547;
 //BA.debugLineNum = 1769547;BA.debugLine="sale3Label.TextColor= Colors.White";
_sale3label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1769548;
 //BA.debugLineNum = 1769548;BA.debugLine="sale3Label.Gravity = Gravity.CENTER_VERTICAL";
_sale3label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769549;
 //BA.debugLineNum = 1769549;BA.debugLine="sale3Label.Typeface = Typeface.MONOSPACE";
_sale3label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769550;
 //BA.debugLineNum = 1769550;BA.debugLine="tableLabel.AddView(sale3Label,panelWidth*5,0,pane";
_tablelabel.AddView((android.view.View)(_sale3label.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_tablelabel.getHeight());
RDebugUtils.currentLine=1769553;
 //BA.debugLineNum = 1769553;BA.debugLine="home.Initialize(\"home\")";
mostCurrent._home.Initialize(mostCurrent.activityBA,"home");
RDebugUtils.currentLine=1769554;
 //BA.debugLineNum = 1769554;BA.debugLine="home.Text = \"HOME |\"";
mostCurrent._home.setText(BA.ObjectToCharSequence("HOME |"));
RDebugUtils.currentLine=1769555;
 //BA.debugLineNum = 1769555;BA.debugLine="home.TextColor = Colors.Black";
mostCurrent._home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1769556;
 //BA.debugLineNum = 1769556;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
mostCurrent._home.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769557;
 //BA.debugLineNum = 1769557;BA.debugLine="home.Gravity = Gravity.CENTER";
mostCurrent._home.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1769558;
 //BA.debugLineNum = 1769558;BA.debugLine="home.TextSize = 16 '";
mostCurrent._home.setTextSize((float) (16));
RDebugUtils.currentLine=1769559;
 //BA.debugLineNum = 1769559;BA.debugLine="Panel4.AddView(home, 0, 0, responsiveLabel(home),";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._home.getObject()),(int) (0),(int) (0),_responsivelabel(mostCurrent._home),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=1769560;
 //BA.debugLineNum = 1769560;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=1769562;
 //BA.debugLineNum = 1769562;BA.debugLine="branches.Initialize(\"branch\")";
mostCurrent._branches.Initialize(mostCurrent.activityBA,"branch");
RDebugUtils.currentLine=1769563;
 //BA.debugLineNum = 1769563;BA.debugLine="branches.Text = \"Branches\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches"));
RDebugUtils.currentLine=1769564;
 //BA.debugLineNum = 1769564;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
mostCurrent._branches.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769565;
 //BA.debugLineNum = 1769565;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._branches.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769566;
 //BA.debugLineNum = 1769566;BA.debugLine="branches.TextSize = 16";
mostCurrent._branches.setTextSize((float) (16));
RDebugUtils.currentLine=1769567;
 //BA.debugLineNum = 1769567;BA.debugLine="branches.TextColor = Colors.Black";
mostCurrent._branches.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1769568;
 //BA.debugLineNum = 1769568;BA.debugLine="Panel4.AddView(branches, responsiveLabel(home), 0";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._branches.getObject()),_responsivelabel(mostCurrent._home),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (210)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=1769571;
 //BA.debugLineNum = 1769571;BA.debugLine="devices.Initialize(\"device\")";
mostCurrent._devices.Initialize(mostCurrent.activityBA,"device");
RDebugUtils.currentLine=1769572;
 //BA.debugLineNum = 1769572;BA.debugLine="devices.Text = \"Devices\"";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices"));
RDebugUtils.currentLine=1769573;
 //BA.debugLineNum = 1769573;BA.debugLine="devices.Typeface = Typeface.MONOSPACE";
mostCurrent._devices.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1769574;
 //BA.debugLineNum = 1769574;BA.debugLine="devices.Gravity = Gravity.CENTER_VERTICAL";
mostCurrent._devices.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1769575;
 //BA.debugLineNum = 1769575;BA.debugLine="devices.TextSize = 16";
mostCurrent._devices.setTextSize((float) (16));
RDebugUtils.currentLine=1769576;
 //BA.debugLineNum = 1769576;BA.debugLine="Panel4.AddView(devices, branches.Left + branches.";
mostCurrent._panel4.AddView((android.view.View)(mostCurrent._devices.getObject()),(int) (mostCurrent._branches.getLeft()+mostCurrent._branches.getWidth()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),mostCurrent._panel4.getHeight());
RDebugUtils.currentLine=1769577;
 //BA.debugLineNum = 1769577;BA.debugLine="Panel4.Color = Colors.Transparent";
mostCurrent._panel4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=1769579;
 //BA.debugLineNum = 1769579;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=1769580;
 //BA.debugLineNum = 1769580;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=1769581;
 //BA.debugLineNum = 1769581;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=1769583;
 //BA.debugLineNum = 1769583;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=1769584;
 //BA.debugLineNum = 1769584;BA.debugLine="End Sub";
return "";
}
public static int  _responsivelabel(anywheresoftware.b4a.objects.LabelWrapper _label) throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "responsivelabel", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "responsivelabel", new Object[] {_label}));}
int _charwidth = 0;
int _padding = 0;
int _homewidth = 0;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Dim charWidth As Int = 10dip";
_charwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
_homewidth = (int) ((_label.getText().length()*_charwidth)+_padding);
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="Return homeWidth";
if (true) return _homewidth;
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="End Sub";
return 0;
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="PHPURL = \"https://192.168.8.142/Company/fetch.php";
mostCurrent._phpurl = "https://192.168.8.142/Company/fetch.php?action=get_device&id="+mostCurrent._branch._branch_selected /*String*/ +"&page="+BA.NumberToString(_pageno)+"&limit="+BA.NumberToString(_limit);
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="Job1.Initialize(\"LoadData\", Me)";
_job1._initialize /*String*/ (null,processBA,"LoadData",device.getObject());
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="device";
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub backBtn_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="If pageNo > 1 Then";
if (_pageno>1) { 
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="pageNo = pageNo - 1";
_pageno = (int) (_pageno-1);
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="num = 1";
_num = (int) (1);
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 };
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="End Sub";
return "";
}
public static String  _branch_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "branch_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "branch_click", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Private Sub branch_Click";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="End Sub";
return "";
}
public static String  _home_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "home_click", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Private Sub home_Click";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="Try";
try {RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="ScrollViewPanel.RemoveAllViews";
mostCurrent._scrollviewpanel.RemoveAllViews();
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="Dim YPos As Int = 0";
_ypos = (int) (0);
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="Dim Margin As Int = 0dip";
_margin = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0));
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="Dim TotalHeight As Int = 0";
_totalheight = (int) (0);
RDebugUtils.currentLine=2097164;
 //BA.debugLineNum = 2097164;BA.debugLine="Dim totalDevices As Int = 0";
_totaldevices = (int) (0);
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="YPos = YPos + 0%y + Margin";
_ypos = (int) (_ypos+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA)+_margin);
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="Dim tdFontSize As Int = 13";
_tdfontsize = (int) (13);
RDebugUtils.currentLine=2097168;
 //BA.debugLineNum = 2097168;BA.debugLine="TotalLabel.Initialize(\"TotalLabel\")";
mostCurrent._totallabel.Initialize(mostCurrent.activityBA,"TotalLabel");
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group16 = mostCurrent._tabledetails;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group16.Get(index16)));
RDebugUtils.currentLine=2097171;
 //BA.debugLineNum = 2097171;BA.debugLine="Dim serial_num As String = record.Get(\"serial\"";
_serial_num = BA.ObjectToString(_record.Get((Object)("serial")));
RDebugUtils.currentLine=2097172;
 //BA.debugLineNum = 2097172;BA.debugLine="Dim sales1 As String = record.Get(\"sales1\")";
_sales1 = BA.ObjectToString(_record.Get((Object)("sales1")));
RDebugUtils.currentLine=2097173;
 //BA.debugLineNum = 2097173;BA.debugLine="Dim sales2 As String = record.Get(\"sales2\")";
_sales2 = BA.ObjectToString(_record.Get((Object)("sales2")));
RDebugUtils.currentLine=2097174;
 //BA.debugLineNum = 2097174;BA.debugLine="Dim sales3 As String = record.Get(\"sales3\")";
_sales3 = BA.ObjectToString(_record.Get((Object)("sales3")));
RDebugUtils.currentLine=2097175;
 //BA.debugLineNum = 2097175;BA.debugLine="Dim id As Int = record.Get(\"num\")";
_id = (int)(BA.ObjectToNumber(_record.Get((Object)("num"))));
RDebugUtils.currentLine=2097176;
 //BA.debugLineNum = 2097176;BA.debugLine="totalDevices = record.Get(\"totalDevices\")";
_totaldevices = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=2097177;
 //BA.debugLineNum = 2097177;BA.debugLine="Dim comName As String = record.Get(\"comName\")";
_comname = BA.ObjectToString(_record.Get((Object)("comName")));
RDebugUtils.currentLine=2097178;
 //BA.debugLineNum = 2097178;BA.debugLine="LabelTitle.Text = record.Get(\"branchName\")";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(_record.Get((Object)("branchName"))));
RDebugUtils.currentLine=2097179;
 //BA.debugLineNum = 2097179;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCase";
mostCurrent._labeltitle.setText(BA.ObjectToCharSequence(mostCurrent._labeltitle.getText().toUpperCase()));
RDebugUtils.currentLine=2097181;
 //BA.debugLineNum = 2097181;BA.debugLine="Label1.Text = comName";
mostCurrent._label1.setText(BA.ObjectToCharSequence(_comname));
RDebugUtils.currentLine=2097182;
 //BA.debugLineNum = 2097182;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=2097184;
 //BA.debugLineNum = 2097184;BA.debugLine="branches.Text = \"Branches - \"&comName&\" |\"";
mostCurrent._branches.setText(BA.ObjectToCharSequence("Branches - "+_comname+" |"));
RDebugUtils.currentLine=2097185;
 //BA.debugLineNum = 2097185;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
mostCurrent._branches.setText(BA.ObjectToCharSequence(mostCurrent._branches.getText().toUpperCase()));
RDebugUtils.currentLine=2097187;
 //BA.debugLineNum = 2097187;BA.debugLine="devices.Text = \"Devices - \"&record.Get(\"branch";
mostCurrent._devices.setText(BA.ObjectToCharSequence("Devices - "+BA.ObjectToString(_record.Get((Object)("branchName")))));
RDebugUtils.currentLine=2097188;
 //BA.debugLineNum = 2097188;BA.debugLine="devices.Text = devices.Text.ToUpperCase";
mostCurrent._devices.setText(BA.ObjectToCharSequence(mostCurrent._devices.getText().toUpperCase()));
RDebugUtils.currentLine=2097190;
 //BA.debugLineNum = 2097190;BA.debugLine="Dim ItemPanel As Panel";
_itempanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2097191;
 //BA.debugLineNum = 2097191;BA.debugLine="ItemPanel.Initialize(\"\")";
_itempanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097192;
 //BA.debugLineNum = 2097192;BA.debugLine="ItemPanel.SetLayout(0, YPos, ScrollView1.Width";
_itempanel.SetLayout((int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
RDebugUtils.currentLine=2097193;
 //BA.debugLineNum = 2097193;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_itempanel.getObject()),(int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=2097194;
 //BA.debugLineNum = 2097194;BA.debugLine="panelWidth = ItemPanel.Width /6";
_panelwidth = (int) (_itempanel.getWidth()/(double)6);
RDebugUtils.currentLine=2097195;
 //BA.debugLineNum = 2097195;BA.debugLine="If num Mod 2 = 0 Then";
if (_num%2==0) { 
RDebugUtils.currentLine=2097196;
 //BA.debugLineNum = 2097196;BA.debugLine="ItemPanel.Color = Colors.LightGray";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 }else {
RDebugUtils.currentLine=2097198;
 //BA.debugLineNum = 2097198;BA.debugLine="ItemPanel.Color = Colors.ARGB(255, 251, 251,";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
 };
RDebugUtils.currentLine=2097201;
 //BA.debugLineNum = 2097201;BA.debugLine="Dim number As Label";
_number = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097202;
 //BA.debugLineNum = 2097202;BA.debugLine="number.Initialize(\"\")";
_number.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097203;
 //BA.debugLineNum = 2097203;BA.debugLine="number.Text = id";
_number.setText(BA.ObjectToCharSequence(_id));
RDebugUtils.currentLine=2097204;
 //BA.debugLineNum = 2097204;BA.debugLine="number.TextSize = tdFontSize";
_number.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=2097205;
 //BA.debugLineNum = 2097205;BA.debugLine="number.TextColor = Colors.Black";
_number.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097206;
 //BA.debugLineNum = 2097206;BA.debugLine="number.Gravity = Gravity.CENTER_VERTICAL";
_number.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2097207;
 //BA.debugLineNum = 2097207;BA.debugLine="number.Typeface = Typeface.MONOSPACE";
_number.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2097208;
 //BA.debugLineNum = 2097208;BA.debugLine="ItemPanel.AddView(number, tdleftPos, 0, panelW";
_itempanel.AddView((android.view.View)(_number.getObject()),_tdleftpos,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=2097210;
 //BA.debugLineNum = 2097210;BA.debugLine="Dim deviceLabel As Label";
_devicelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097211;
 //BA.debugLineNum = 2097211;BA.debugLine="deviceLabel.Initialize(\"\")";
_devicelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097212;
 //BA.debugLineNum = 2097212;BA.debugLine="deviceLabel.Text = \"Pos0\"&id";
_devicelabel.setText(BA.ObjectToCharSequence("Pos0"+BA.NumberToString(_id)));
RDebugUtils.currentLine=2097213;
 //BA.debugLineNum = 2097213;BA.debugLine="deviceLabel.TextSize = tdFontSize";
_devicelabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=2097214;
 //BA.debugLineNum = 2097214;BA.debugLine="deviceLabel.TextColor = Colors.Black";
_devicelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097215;
 //BA.debugLineNum = 2097215;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
_devicelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2097216;
 //BA.debugLineNum = 2097216;BA.debugLine="ItemPanel.AddView(deviceLabel, panelWidth, 0,";
_itempanel.AddView((android.view.View)(_devicelabel.getObject()),_panelwidth,(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=2097218;
 //BA.debugLineNum = 2097218;BA.debugLine="Dim serialLabel As Label";
_seriallabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097219;
 //BA.debugLineNum = 2097219;BA.debugLine="serialLabel.Initialize(\"\")";
_seriallabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097220;
 //BA.debugLineNum = 2097220;BA.debugLine="serialLabel.Text = serial_num";
_seriallabel.setText(BA.ObjectToCharSequence(_serial_num));
RDebugUtils.currentLine=2097221;
 //BA.debugLineNum = 2097221;BA.debugLine="serialLabel.TextSize = tdFontSize";
_seriallabel.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=2097222;
 //BA.debugLineNum = 2097222;BA.debugLine="serialLabel.TextColor = Colors.Black";
_seriallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097223;
 //BA.debugLineNum = 2097223;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
_seriallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2097224;
 //BA.debugLineNum = 2097224;BA.debugLine="ItemPanel.AddView(serialLabel, panelWidth*2, 0";
_itempanel.AddView((android.view.View)(_seriallabel.getObject()),(int) (_panelwidth*2),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=2097226;
 //BA.debugLineNum = 2097226;BA.debugLine="Dim sale As Label";
_sale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097227;
 //BA.debugLineNum = 2097227;BA.debugLine="sale.Initialize(\"\")";
_sale.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097228;
 //BA.debugLineNum = 2097228;BA.debugLine="sale.Text = sales1";
_sale.setText(BA.ObjectToCharSequence(_sales1));
RDebugUtils.currentLine=2097229;
 //BA.debugLineNum = 2097229;BA.debugLine="sale.TextSize = tdFontSize";
_sale.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=2097230;
 //BA.debugLineNum = 2097230;BA.debugLine="sale.TextColor = Colors.Black";
_sale.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097231;
 //BA.debugLineNum = 2097231;BA.debugLine="sale.Gravity = Gravity.CENTER_VERTICAL";
_sale.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2097232;
 //BA.debugLineNum = 2097232;BA.debugLine="ItemPanel.AddView(sale, panelWidth*3, 0, panel";
_itempanel.AddView((android.view.View)(_sale.getObject()),(int) (_panelwidth*3),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=2097234;
 //BA.debugLineNum = 2097234;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097235;
 //BA.debugLineNum = 2097235;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097236;
 //BA.debugLineNum = 2097236;BA.debugLine="sale1.Text = sales2";
_sale1.setText(BA.ObjectToCharSequence(_sales2));
RDebugUtils.currentLine=2097237;
 //BA.debugLineNum = 2097237;BA.debugLine="sale1.TextSize = tdFontSize";
_sale1.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=2097238;
 //BA.debugLineNum = 2097238;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097239;
 //BA.debugLineNum = 2097239;BA.debugLine="sale1.Gravity = Gravity.CENTER_VERTICAL";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2097240;
 //BA.debugLineNum = 2097240;BA.debugLine="ItemPanel.AddView(sale1, panelWidth*4, 0, pane";
_itempanel.AddView((android.view.View)(_sale1.getObject()),(int) (_panelwidth*4),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=2097242;
 //BA.debugLineNum = 2097242;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097243;
 //BA.debugLineNum = 2097243;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097244;
 //BA.debugLineNum = 2097244;BA.debugLine="sale2.Text = sales3";
_sale2.setText(BA.ObjectToCharSequence(_sales3));
RDebugUtils.currentLine=2097245;
 //BA.debugLineNum = 2097245;BA.debugLine="sale2.TextSize = tdFontSize";
_sale2.setTextSize((float) (_tdfontsize));
RDebugUtils.currentLine=2097246;
 //BA.debugLineNum = 2097246;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097247;
 //BA.debugLineNum = 2097247;BA.debugLine="sale2.Gravity = Gravity.CENTER_VERTICAL";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=2097248;
 //BA.debugLineNum = 2097248;BA.debugLine="ItemPanel.AddView(sale2, panelWidth*5, 0, pane";
_itempanel.AddView((android.view.View)(_sale2.getObject()),(int) (_panelwidth*5),(int) (0),_panelwidth,_itempanel.getHeight());
RDebugUtils.currentLine=2097250;
 //BA.debugLineNum = 2097250;BA.debugLine="Dim backBtn As Label";
_backbtn = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097251;
 //BA.debugLineNum = 2097251;BA.debugLine="backBtn.Initialize(\"backBtn\")";
_backbtn.Initialize(mostCurrent.activityBA,"backBtn");
RDebugUtils.currentLine=2097252;
 //BA.debugLineNum = 2097252;BA.debugLine="backBtn.TextColor =Colors.White";
_backbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097253;
 //BA.debugLineNum = 2097253;BA.debugLine="backBtn.Text = \"<\"";
_backbtn.setText(BA.ObjectToCharSequence("<"));
RDebugUtils.currentLine=2097254;
 //BA.debugLineNum = 2097254;BA.debugLine="backBtn.Gravity = Gravity.CENTER";
_backbtn.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2097255;
 //BA.debugLineNum = 2097255;BA.debugLine="backBtn.Typeface = Typeface.SERIF";
_backbtn.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2097256;
 //BA.debugLineNum = 2097256;BA.debugLine="backBtn.Color = Colors.Black";
_backbtn.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097257;
 //BA.debugLineNum = 2097257;BA.debugLine="backBtn.TextSize = 25";
_backbtn.setTextSize((float) (25));
RDebugUtils.currentLine=2097258;
 //BA.debugLineNum = 2097258;BA.debugLine="Panel3.AddView(backBtn,3dip,5dip,50dip,Panel3.";
mostCurrent._panel3.AddView((android.view.View)(_backbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=2097260;
 //BA.debugLineNum = 2097260;BA.debugLine="pageLabel.Initialize(\"pageLabel\")";
mostCurrent._pagelabel.Initialize(mostCurrent.activityBA,"pageLabel");
RDebugUtils.currentLine=2097261;
 //BA.debugLineNum = 2097261;BA.debugLine="pageLabel.TextColor =Colors.Black";
mostCurrent._pagelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097262;
 //BA.debugLineNum = 2097262;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=2097263;
 //BA.debugLineNum = 2097263;BA.debugLine="pageLabel.Gravity = Gravity.CENTER";
mostCurrent._pagelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2097264;
 //BA.debugLineNum = 2097264;BA.debugLine="pageLabel.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._pagelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=2097265;
 //BA.debugLineNum = 2097265;BA.debugLine="pageLabel.Color = Colors.white";
mostCurrent._pagelabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097266;
 //BA.debugLineNum = 2097266;BA.debugLine="pageLabel.TextSize = 15";
mostCurrent._pagelabel.setTextSize((float) (15));
RDebugUtils.currentLine=2097267;
 //BA.debugLineNum = 2097267;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2097268;
 //BA.debugLineNum = 2097268;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097269;
 //BA.debugLineNum = 2097269;BA.debugLine="Panel3.AddView(pageLabel,backBtn.Width+backBtn";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._pagelabel.getObject()),(int) (_backbtn.getWidth()+_backbtn.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
RDebugUtils.currentLine=2097271;
 //BA.debugLineNum = 2097271;BA.debugLine="Dim nxtLabel As Label";
_nxtlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097272;
 //BA.debugLineNum = 2097272;BA.debugLine="nxtLabel.Initialize(\"nxtLabel\")";
_nxtlabel.Initialize(mostCurrent.activityBA,"nxtLabel");
RDebugUtils.currentLine=2097273;
 //BA.debugLineNum = 2097273;BA.debugLine="nxtLabel.TextColor =Colors.White";
_nxtlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097274;
 //BA.debugLineNum = 2097274;BA.debugLine="nxtLabel.Text = \">\"";
_nxtlabel.setText(BA.ObjectToCharSequence(">"));
RDebugUtils.currentLine=2097275;
 //BA.debugLineNum = 2097275;BA.debugLine="nxtLabel.Gravity = Gravity.CENTER";
_nxtlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2097276;
 //BA.debugLineNum = 2097276;BA.debugLine="nxtLabel.Typeface = Typeface.SERIF";
_nxtlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=2097277;
 //BA.debugLineNum = 2097277;BA.debugLine="nxtLabel.Color = Colors.black";
_nxtlabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2097278;
 //BA.debugLineNum = 2097278;BA.debugLine="nxtLabel.TextSize = 25";
_nxtlabel.setTextSize((float) (25));
RDebugUtils.currentLine=2097279;
 //BA.debugLineNum = 2097279;BA.debugLine="Panel3.AddView(nxtLabel,pageLabel.Width+pageLa";
mostCurrent._panel3.AddView((android.view.View)(_nxtlabel.getObject()),(int) (mostCurrent._pagelabel.getWidth()+mostCurrent._pagelabel.getLeft()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=2097281;
 //BA.debugLineNum = 2097281;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2097282;
 //BA.debugLineNum = 2097282;BA.debugLine="cd.Initialize2(Colors.Black, 5dip, 2dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097283;
 //BA.debugLineNum = 2097283;BA.debugLine="backBtn.Background = cd";
_backbtn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2097284;
 //BA.debugLineNum = 2097284;BA.debugLine="nxtLabel.Background = cd";
_nxtlabel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2097288;
 //BA.debugLineNum = 2097288;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin ' Upda";
_ypos = (int) (_ypos+_itempanel.getHeight()+_margin);
RDebugUtils.currentLine=2097289;
 //BA.debugLineNum = 2097289;BA.debugLine="nxtLabel.Enabled = False";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2097290;
 //BA.debugLineNum = 2097290;BA.debugLine="If limit * pageNo < totalDevices Then";
if (_limit*_pageno<_totaldevices) { 
RDebugUtils.currentLine=2097291;
 //BA.debugLineNum = 2097291;BA.debugLine="nxtLabel.Enabled = True";
_nxtlabel.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2097295;
 //BA.debugLineNum = 2097295;BA.debugLine="TotalHeight = TotalHeight + 65dip";
_totalheight = (int) (_totalheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65)));
RDebugUtils.currentLine=2097296;
 //BA.debugLineNum = 2097296;BA.debugLine="ScrollView1.Panel.Height =TotalHeight";
mostCurrent._scrollview1.getPanel().setHeight(_totalheight);
RDebugUtils.currentLine=2097297;
 //BA.debugLineNum = 2097297;BA.debugLine="num = num +1";
_num = (int) (_num+1);
RDebugUtils.currentLine=2097298;
 //BA.debugLineNum = 2097298;BA.debugLine="TotalLabel.Text = \"\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(""));
 }
};
RDebugUtils.currentLine=2097302;
 //BA.debugLineNum = 2097302;BA.debugLine="TotalLabel.RemoveView";
mostCurrent._totallabel.RemoveView();
RDebugUtils.currentLine=2097303;
 //BA.debugLineNum = 2097303;BA.debugLine="TotalLabel.TextColor =Colors.White";
mostCurrent._totallabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097304;
 //BA.debugLineNum = 2097304;BA.debugLine="TotalLabel.Text = num&\" out of \"&totalDevices&\"";
mostCurrent._totallabel.setText(BA.ObjectToCharSequence(BA.NumberToString(_num)+" out of "+BA.NumberToString(_totaldevices)+" devices"));
RDebugUtils.currentLine=2097305;
 //BA.debugLineNum = 2097305;BA.debugLine="TotalLabel.Gravity = Gravity.CENTER";
mostCurrent._totallabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2097306;
 //BA.debugLineNum = 2097306;BA.debugLine="TotalLabel.Typeface = Typeface.MONOSPACE";
mostCurrent._totallabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=2097307;
 //BA.debugLineNum = 2097307;BA.debugLine="TotalLabel.Color = Colors.Transparent";
mostCurrent._totallabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=2097308;
 //BA.debugLineNum = 2097308;BA.debugLine="TotalLabel.TextSize = 15";
mostCurrent._totallabel.setTextSize((float) (15));
RDebugUtils.currentLine=2097310;
 //BA.debugLineNum = 2097310;BA.debugLine="Panel3.AddView(TotalLabel,Panel3.Width-240dip,5";
mostCurrent._panel3.AddView((android.view.View)(mostCurrent._totallabel.getObject()),(int) (mostCurrent._panel3.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (240))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (230)),(int) (mostCurrent._panel3.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 } 
       catch (Exception e136) {
			processBA.setLastException(e136); };
 }else {
RDebugUtils.currentLine=2097316;
 //BA.debugLineNum = 2097316;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2097319;
 //BA.debugLineNum = 2097319;BA.debugLine="End Sub";
return "";
}
public static String  _nxtlabel_click() throws Exception{
RDebugUtils.currentModule="device";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nxtlabel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nxtlabel_click", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub nxtLabel_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="pageNo = pageNo + 1";
_pageno = (int) (_pageno+1);
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="pageLabel.Text = pageNo";
mostCurrent._pagelabel.setText(BA.ObjectToCharSequence(_pageno));
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="End Sub";
return "";
}
}