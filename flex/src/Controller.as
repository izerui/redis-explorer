package {
import com.adobe.cairngorm.control.FrontController;
import com.izerui.commond.GetDbAmountCommond;
import com.izerui.commond.GetHashValueCommond;
import com.izerui.commond.GetIdletimeCommond;
import com.izerui.commond.GetKeysCommond;
import com.izerui.commond.GetListValueCommond;
import com.izerui.commond.GetServerConfigsCommond;
import com.izerui.commond.GetSetValueCommond;
import com.izerui.commond.GetStringValueCommond;
import com.izerui.commond.GetTTLsCommond;
import com.izerui.commond.GetZSetValueCommond;
import com.izerui.commond.RemoveServerConfigCommond;
import com.izerui.commond.SaveHashValueCommond;
import com.izerui.commond.SaveServerConfigCommond;
import com.izerui.commond.SaveStringValueCommond;
import com.izerui.commond.SetExpireCommond;

public class Controller extends FrontController {

    public function initialize():void {
        this.addCommand("getServerConfigs", GetServerConfigsCommond);
        this.addCommand("saveServerConfig", SaveServerConfigCommond);
        this.addCommand("removeServerConfig", RemoveServerConfigCommond);
        this.addCommand("getDbAmount", GetDbAmountCommond);
        this.addCommand("getKeys", GetKeysCommond);
        this.addCommand("getStringValue", GetStringValueCommond);
        this.addCommand("getHashValue", GetHashValueCommond);
        this.addCommand("getListValue", GetListValueCommond);
        this.addCommand("getSetValue", GetSetValueCommond);
        this.addCommand("getZSetValue", GetZSetValueCommond);
        this.addCommand("saveHashValue", SaveHashValueCommond);
        this.addCommand("saveStringValue", SaveStringValueCommond);
        this.addCommand("getIdletime", GetIdletimeCommond);
        this.addCommand("getTTLs", GetTTLsCommond);
        this.addCommand("setExpire", SetExpireCommond);
    }

    public function Controller() {
        this.initialize();
    }
}
}