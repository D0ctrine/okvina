package com.edu.domain.application;

import java.util.List;

import com.edu.domain.application.commands.setting.headntail.CreateHnTCommand;
import com.edu.domain.application.commands.setting.headntail.UpdateHnTCommand;
import com.edu.domain.model.settingfile.headntail.headntail;
import com.edu.domain.model.user.UserId;

public interface HeadnTailService {
    /**
   * 메일 시작과 끝 리스트 가져오기
   */
  List<headntail> getList(String cfgId);

  /**
   * 메일 세팅 신규 생성
   */
  List<headntail> create(List<CreateHnTCommand> ec);

/**
   * 메일 세팅 복사본 생성
   */
  Boolean createCopy(List<headntail> ec, UserId userid, String cfgId);

  /**
   * 파일 세팅 삭제
   * ID(PK)를 통해 카테고리를 삭제한다.
   */
  headntail delete(UpdateHnTCommand htc);

  /**
   * 파일 세팅 갱신
   */
  List<headntail> update(List<UpdateHnTCommand> htc);
}
