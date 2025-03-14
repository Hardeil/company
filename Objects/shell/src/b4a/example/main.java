
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
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
		pcBA = new PCBA(this, main.class);
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
public static RemoteObject _calculatedsize = RemoteObject.createImmutable(0f);
public static b4a.example.branch _branch = null;
public static b4a.example.device _device = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"activityPanel",main.mostCurrent._activitypanel,"barGraph",Debug.moduleToString(b4a.example.bargraph.class),"barGraph1",main.mostCurrent._bargraph1,"barGraphInitialized",main._bargraphinitialized,"barPanel",main.mostCurrent._barpanel,"Branch",Debug.moduleToString(b4a.example.branch.class),"Button1",main.mostCurrent._button1,"calculatedSize",main._calculatedsize,"company",main._company,"companyPanel",main.mostCurrent._companypanel,"currentPage",main._currentpage,"defBtn",main.mostCurrent._defbtn,"Device",Debug.moduleToString(b4a.example.device.class),"height",main._height,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"Label1",main.mostCurrent._label1,"legend",main.mostCurrent._legend,"navigate",main.mostCurrent._navigate,"Panel1",main.mostCurrent._panel1,"Panel2",main.mostCurrent._panel2,"PHPURL",main.mostCurrent._phpurl,"PHPURLCompany",main.mostCurrent._phpurlcompany,"primaryFontSize",main._primaryfontsize,"purchasePanel",main.mostCurrent._purchasepanel,"purchBackBtn",main.mostCurrent._purchbackbtn,"purchNxtBtn",main.mostCurrent._purchnxtbtn,"saleBackBtn",main.mostCurrent._salebackbtn,"saleNxtBtn",main.mostCurrent._salenxtbtn,"sales1btn",main.mostCurrent._sales1btn,"sales2btn",main.mostCurrent._sales2btn,"sales3btn",main.mostCurrent._sales3btn,"salesData1",main._salesdata1,"ScrollView1",main.mostCurrent._scrollview1,"secondaryFontSize",main._secondaryfontsize,"sortBtn1",main.mostCurrent._sortbtn1,"sortBtn2",main.mostCurrent._sortbtn2,"sortDefaultValue",main.mostCurrent._sortdefaultvalue,"Starter",Debug.moduleToString(b4a.example.starter.class),"TableDetails",main.mostCurrent._tabledetails,"totalGetDataHeight",main._totalgetdataheight,"totalGraphDataHeight",main._totalgraphdataheight,"xui",main._xui};
}
}