package com.edu.domain.application.commands.config.ftp;

import com.edu.domain.model.user.UserId;

public class CreateFtpCommand {
  private UserId userId;
  private String cfgId;
  private String ftpAddr;
  private String userid;
  private String pwd;
  private String baseDir;
  private String type;

  public CreateFtpCommand(UserId userId,String cfgId,String ftpAddr,String userid,String pwd,String baseDir,String type){
    this.userId = userId;
    this.cfgId = cfgId;
    this.ftpAddr = ftpAddr;
    this.userid = userid;
    this.pwd = pwd;
    this.baseDir = baseDir;
    this.type = type;
  }

  public UserId getUserId() {
    return userId;
  }

  public String getCfgId() {
    return cfgId;
  }

  public String getFtpAddr() {
    return ftpAddr;
  }

  public String getUserid() {
    return userid;
  }

  public String getPwd() {
    return pwd;
  }

  public String getBaseDir() {
    return baseDir;
  }

  public String getType() {
    return type;
  }

}
