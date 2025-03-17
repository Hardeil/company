
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class branch implements IRemote{
	public static branch mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public branch() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("branch"), "b4a.example.branch");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, branch.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _company_name = RemoteObject.createImmutable("");
public static RemoteObject _branch_selected = RemoteObject.createImmutable("");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _phpurl = RemoteObject.createImmutable("");
public static RemoteObject _phpurl1 = RemoteObject.createImmutable("");
public static RemoteObject _tabledetails = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _labeltitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _titlefontsize = RemoteObject.createImmutable(0);
public static RemoteObject _primaryfontsize = RemoteObject.createImmutable(0);
public static RemoteObject _secondaryfontsize = RemoteObject.createImmutable(0);
public static RemoteObject _num = RemoteObject.createImmutable(0);
public static RemoteObject _panel3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _home = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _branches = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _popuppanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _target_countlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _target_id_display = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _totaltarget = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _bargraph = RemoteObject.declareNull("b4a.example.bargraph");
public static RemoteObject _nxtbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _backbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _purchasepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _currentpage = RemoteObject.createImmutable(0);
public static RemoteObject _totalsales = RemoteObject.createImmutable(0);
public static RemoteObject _bargraphinitialized = RemoteObject.createImmutable(false);
public static RemoteObject _panel4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _scrollviewpanel4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _sortbtn1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _defbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sortbtn2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _salesbtn1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _salesbtn2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _salesbtn3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _salesdata1 = RemoteObject.createImmutable(0);
public static RemoteObject _salesdatadefault = RemoteObject.createImmutable(0);
public static RemoteObject _sortdefaultvalue = RemoteObject.createImmutable("");
public static RemoteObject _showhidebtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.example.main _main = null;
public static b4a.example.device _device = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",branch.mostCurrent._activity,"backbtn",branch.mostCurrent._backbtn,"barGraph",Debug.moduleToString(b4a.example.bargraph.class),"barGraphInitialized",branch._bargraphinitialized,"branch_selected",branch._branch_selected,"branches",branch.mostCurrent._branches,"company_name",branch._company_name,"currentPage",branch._currentpage,"defBtn",branch.mostCurrent._defbtn,"Device",Debug.moduleToString(b4a.example.device.class),"home",branch.mostCurrent._home,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"LabelTitle",branch.mostCurrent._labeltitle,"Main",Debug.moduleToString(b4a.example.main.class),"num",branch._num,"nxtBtn",branch.mostCurrent._nxtbtn,"Panel",branch.mostCurrent._panel,"Panel3",branch.mostCurrent._panel3,"Panel4",branch.mostCurrent._panel4,"PHPURL",branch.mostCurrent._phpurl,"PHPURL1",branch.mostCurrent._phpurl1,"popupPanel",branch.mostCurrent._popuppanel,"primaryFontSize",branch._primaryfontsize,"purchasePanel",branch.mostCurrent._purchasepanel,"salesBtn1",branch.mostCurrent._salesbtn1,"salesBtn2",branch.mostCurrent._salesbtn2,"salesBtn3",branch.mostCurrent._salesbtn3,"salesData1",branch._salesdata1,"salesDataDefault",branch._salesdatadefault,"ScrollView1",branch.mostCurrent._scrollview1,"scrollViewPanel4",branch.mostCurrent._scrollviewpanel4,"secondaryFontSize",branch._secondaryfontsize,"showHideBtn",branch.mostCurrent._showhidebtn,"sortBtn1",branch.mostCurrent._sortbtn1,"sortBtn2",branch.mostCurrent._sortbtn2,"sortDefaultValue",branch.mostCurrent._sortdefaultvalue,"Starter",Debug.moduleToString(b4a.example.starter.class),"TableDetails",branch.mostCurrent._tabledetails,"target_countLabel",branch.mostCurrent._target_countlabel,"target_id_display",branch.mostCurrent._target_id_display,"titleFontSize",branch._titlefontsize,"totalSales",branch._totalsales,"totalTarget",branch.mostCurrent._totaltarget,"xui",branch._xui};
}
}