package com.huawei.sermant.core.service.send;


import com.huawei.sermant.core.config.common.BaseConfig;
import com.huawei.sermant.core.config.common.ConfigTypeKey;

@ConfigTypeKey("gateway")
public class GatewayConfig implements BaseConfig {

    private String serverIp = "127.0.0.1";

    private int serverPort = 6888;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}
