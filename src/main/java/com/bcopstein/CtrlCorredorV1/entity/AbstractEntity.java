package com.bcopstein.CtrlCorredorV1.entity;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

  public abstract Long getId();

  public abstract void setId(Long id);

}