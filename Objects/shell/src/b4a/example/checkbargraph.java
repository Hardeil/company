
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class checkbargraph {
    public static RemoteObject myClass;
	public checkbargraph() {
	}
    public static PCBA staticBA = new PCBA(null, checkbargraph.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _checkboxes = null;
public static RemoteObject _checkedsales = null;
public static RemoteObject _active = RemoteObject.declareNull("anywheresoftware.b4a.objects.ActivityWrapper");
public static RemoteObject _barpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _nxtbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _backbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _sales = null;
public static RemoteObject _sales1 = null;
public static RemoteObject _sales2 = null;
public static RemoteObject _comname = null;
public static RemoteObject _maxsale = RemoteObject.createImmutable(0);
public static b4a.example.main _main = null;
public static b4a.example.branch _branch = null;
public static b4a.example.device _device = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"Active",_ref.getField(false, "_active"),"backBtn",_ref.getField(false, "_backbtn"),"barPanel",_ref.getField(false, "_barpanel"),"checkBoxes",_ref.getField(false, "_checkboxes"),"checkedSales",_ref.getField(false, "_checkedsales"),"comName",_ref.getField(false, "_comname"),"maxSale",_ref.getField(false, "_maxsale"),"nxtBtn",_ref.getField(false, "_nxtbtn"),"sales",_ref.getField(false, "_sales"),"sales1",_ref.getField(false, "_sales1"),"sales2",_ref.getField(false, "_sales2")};
}
}