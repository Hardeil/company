
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
public static RemoteObject _company = RemoteObject.createImmutable("");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _phpurl = RemoteObject.createImmutable("");
public static RemoteObject _tabledetails = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _button1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _navigate = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _primaryfontsize = RemoteObject.createImmutable(0);
public static RemoteObject _secondaryfontsize = RemoteObject.createImmutable(0);
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _panel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _bargraph = RemoteObject.declareNull("b4a.example.bargraph");
public static RemoteObject _bargraph1 = RemoteObject.declareNull("b4a.example.bargraph");
public static RemoteObject _purchasepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _barpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _activitypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _salenxtbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _salebackbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _purchnxtbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _purchbackbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _sortbtn1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _defbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sortbtn2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sales1btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sales2btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sales3btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _legend = null;
public static RemoteObject _height = RemoteObject.createImmutable(0);
public static RemoteObject _companypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _totalgraphdataheight = RemoteObject.createImmutable(0);
public static RemoteObject _totalgetdataheight = RemoteObject.createImmutable(0);
public static RemoteObject _sortdefaultvalue = RemoteObject.createImmutable("");
public static RemoteObject _salesdata1 = RemoteObject.createImmutable(0);
public static RemoteObject _currentpage = RemoteObject.createImmutable(0);
public static RemoteObject _bargraphinitialized = RemoteObject.createImmutable(false);
public static RemoteObject _phpurlcompany = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.device _device = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",branch.mostCurrent._activity,"activityPanel",branch.mostCurrent._activitypanel,"barGraph",Debug.moduleToString(b4a.example.bargraph.class),"barGraph1",branch.mostCurrent._bargraph1,"barGraphInitialized",branch._bargraphinitialized,"barPanel",branch.mostCurrent._barpanel,"Button1",branch.mostCurrent._button1,"company",branch._company,"companyPanel",branch.mostCurrent._companypanel,"currentPage",branch._currentpage,"defBtn",branch.mostCurrent._defbtn,"Device",Debug.moduleToString(b4a.example.device.class),"height",branch._height,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"Label1",branch.mostCurrent._label1,"legend",branch.mostCurrent._legend,"Main",Debug.moduleToString(b4a.example.main.class),"navigate",branch.mostCurrent._navigate,"Panel1",branch.mostCurrent._panel1,"Panel2",branch.mostCurrent._panel2,"PHPURL",branch.mostCurrent._phpurl,"PHPURLCompany",branch.mostCurrent._phpurlcompany,"primaryFontSize",branch._primaryfontsize,"purchasePanel",branch.mostCurrent._purchasepanel,"purchBackBtn",branch.mostCurrent._purchbackbtn,"purchNxtBtn",branch.mostCurrent._purchnxtbtn,"saleBackBtn",branch.mostCurrent._salebackbtn,"saleNxtBtn",branch.mostCurrent._salenxtbtn,"sales1btn",branch.mostCurrent._sales1btn,"sales2btn",branch.mostCurrent._sales2btn,"sales3btn",branch.mostCurrent._sales3btn,"salesData1",branch._salesdata1,"ScrollView1",branch.mostCurrent._scrollview1,"secondaryFontSize",branch._secondaryfontsize,"sortBtn1",branch.mostCurrent._sortbtn1,"sortBtn2",branch.mostCurrent._sortbtn2,"sortDefaultValue",branch.mostCurrent._sortdefaultvalue,"Starter",Debug.moduleToString(b4a.example.starter.class),"TableDetails",branch.mostCurrent._tabledetails,"totalGetDataHeight",branch._totalgetdataheight,"totalGraphDataHeight",branch._totalgraphdataheight,"xui",branch._xui};
}
}