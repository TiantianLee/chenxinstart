/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016/2/25 11:38:35                           */
/*==============================================================*/


drop table CAF_CPUINFO cascade constraints;

drop table CAF_INVOKEINFO cascade constraints;

drop table CAF_MEMINFO cascade constraints;

drop table CAF_SERVICEINFO cascade constraints;

/*==============================================================*/
/* Table: CAF_CPUINFO                                           */
/*==============================================================*/
create table CAF_CPUINFO 
(
   ID                   VARCHAR(36)          not null,
   SERVICEID            VARCHAR(36),
   IP                   VARCHAR(20),
   CPURATE              NUMBER,
   CREATETIME           DATE,
   UPDATETIME           DATE,
   DELETETIME           DATE,
   constraint PK_CAF_CPUINFO primary key (ID)
);

comment on table CAF_CPUINFO is
'CPU信息';

comment on column CAF_CPUINFO.ID is
'ID';

comment on column CAF_CPUINFO.SERVICEID is
'SERVICEID';

comment on column CAF_CPUINFO.IP is
'IP';

comment on column CAF_CPUINFO.CPURATE is
'CPURATE';

comment on column CAF_CPUINFO.CREATETIME is
'CREATETIME';

comment on column CAF_CPUINFO.UPDATETIME is
'UPDATETIME';

comment on column CAF_CPUINFO.DELETETIME is
'DELETETIME';

/*==============================================================*/
/* Table: CAF_INVOKEINFO                                        */
/*==============================================================*/
create table CAF_INVOKEINFO 
(
   ID                   VARCHAR(36)          not null,
   SERVICEID            VARCHAR(36),
   INVOKENUM            NUMBER,
   CREATETIME           DATE,
   UPDATETIME           DATE,
   DELETETIME           DATE,
   constraint PK_CAF_INVOKEINFO primary key (ID)
);

comment on table CAF_INVOKEINFO is
'服务调用信息';

comment on column CAF_INVOKEINFO.ID is
'ID';

comment on column CAF_INVOKEINFO.SERVICEID is
'SERVICEID';

comment on column CAF_INVOKEINFO.INVOKENUM is
'INVOKENUM';

comment on column CAF_INVOKEINFO.CREATETIME is
'CREATETIME';

comment on column CAF_INVOKEINFO.UPDATETIME is
'UPDATETIME';

comment on column CAF_INVOKEINFO.DELETETIME is
'DELETETIME';

/*==============================================================*/
/* Table: CAF_MEMINFO                                           */
/*==============================================================*/
create table CAF_MEMINFO 
(
   ID                   VARCHAR(36)          not null,
   SERVICEID            VARCHAR(36),
   IP                   VARCHAR(20),
   MEMRATE              NUMBER,
   CREATETIME           DATE,
   UPDATETIME           DATE,
   DELETETIME           DATE,
   constraint PK_CAF_MEMINFO primary key (ID)
);

comment on table CAF_MEMINFO is
'内存信息';

comment on column CAF_MEMINFO.ID is
'ID';

comment on column CAF_MEMINFO.SERVICEID is
'SERVICEID';

comment on column CAF_MEMINFO.IP is
'IP';

comment on column CAF_MEMINFO.MEMRATE is
'MEMRATE';

comment on column CAF_MEMINFO.CREATETIME is
'CREATETIME';

comment on column CAF_MEMINFO.UPDATETIME is
'UPDATETIME';

comment on column CAF_MEMINFO.DELETETIME is
'DELETETIME';

/*==============================================================*/
/* Table: CAF_SERVICEINFO                                       */
/*==============================================================*/
create table CAF_SERVICEINFO 
(
   ID                   VARCHAR(36)          not null,
   SERVICENAME          VARCHAR(50),
   VERSION              VARCHAR(30),
   IP                   VARCHAR(20),
   PORT                 VARCHAR(6),
   CREATETIME           DATE,
   UPDATETIME           DATE,
   DELETETIME           DATE,
   constraint PK_CAF_SERVICEINFO primary key (ID)
);

comment on table CAF_SERVICEINFO is
'服务信息';

comment on column CAF_SERVICEINFO.ID is
'ID';

comment on column CAF_SERVICEINFO.SERVICENAME is
'服务名称';

comment on column CAF_SERVICEINFO.VERSION is
'版本';

comment on column CAF_SERVICEINFO.IP is
'IP';

comment on column CAF_SERVICEINFO.PORT is
'端口';

comment on column CAF_SERVICEINFO.CREATETIME is
'创建时间';

comment on column CAF_SERVICEINFO.UPDATETIME is
'更新时间';

comment on column CAF_SERVICEINFO.DELETETIME is
'删除时间';

