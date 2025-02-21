
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

public class device implements IRemote{
	public static device mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public device() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("device"), "b4a.example.device");
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
		pcBA = new PCBA(this, device.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _limit = RemoteObject.createImmutable(0);
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _scrollviewpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _tabledetails = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _labeltitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _num = RemoteObject.createImmutable(0);
public static RemoteObject _panel3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pageno = RemoteObject.createImmutable(0);
public static RemoteObject _pagelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _phpurl = RemoteObject.createImmutable("");
public static RemoteObject _panelwidth = RemoteObject.createImmutable(0);
public static RemoteObject _panel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _branches = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _devices = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _home = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _tdleftpos = RemoteObject.createImmutable(0);
public static RemoteObject _totallabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.example.main _main = null;
public static b4a.example.branch _branch = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",device.mostCurrent._activity,"Branch",Debug.moduleToString(b4a.example.branch.class),"branches",device.mostCurrent._branches,"devices",device.mostCurrent._devices,"home",device.mostCurrent._home,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"Label1",device.mostCurrent._label1,"LabelTitle",device.mostCurrent._labeltitle,"limit",device._limit,"Main",Debug.moduleToString(b4a.example.main.class),"num",device._num,"pageLabel",device.mostCurrent._pagelabel,"pageNo",device._pageno,"Panel1",device.mostCurrent._panel1,"Panel2",device.mostCurrent._panel2,"Panel3",device.mostCurrent._panel3,"Panel4",device.mostCurrent._panel4,"panelWidth",device._panelwidth,"PHPURL",device.mostCurrent._phpurl,"ScrollView1",device.mostCurrent._scrollview1,"ScrollViewPanel",device.mostCurrent._scrollviewpanel,"Starter",Debug.moduleToString(b4a.example.starter.class),"TableDetails",device.mostCurrent._tabledetails,"tdleftPos",device._tdleftpos,"TotalLabel",device.mostCurrent._totallabel,"xui",device._xui};
}
}