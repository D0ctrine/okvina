package com.edu.domain.application.commands.config.email;

import com.edu.domain.model.user.UserId;

public class CreateEmailCommand {
  private UserId userId;
  private String cfgId;
  private String host;
  private String port;
  private String accessId;
  private String accessPwd;

  public CreateEmailCommand(UserId userId,String cfgId,String host,String port,String accessId,String accessPwd){
      this.userId = userId;
      this.cfgId = cfgId;
      this.host = host;
      this.port = port;
      this.accessId = accessId;
      this.accessPwd = accessPwd;
  }

  public UserId getUserId() {
    return userId;
  }

  public String getCfgId() {
    return cfgId;
  }

  public String getHost() {
    return host;
  }

  public String getPort() {
    return port;
  }

  public String getAccessId() {
    return accessId;
  }

  public String getAccessPwd() {
    return accessPwd;
  }

}