DROP TABLE RESTAURANTE;
DROP TABLE EVENTO;
DROP TABLE INGREDIENTE;

CREATE TABLE RESTAURANTE 
(
  ID NUMBER NOT NULL,
  NOMBRE VARCHAR2(255 BYTE), 
  REPRESENTANTE VARCHAR2(255 BYTE),
  TIPO_COMIDA VARCHAR2(255 BYTE),
  ID_ZONA NUMBER NOT NULL,
  ID_PAGINAWEB NUMBER,
  CONSTRAINT RESTAURANTE_PK PRIMARY KEY (ID,
  CONSTRAINT FK_IDZONA FOREIGN KEY (ID_ZONA) REFERENCES ZONA(ID),
  CONSTRAINT FK_IDPAGINAWEB FOREIGN KEY (ID_PAGINAWEB) REFERENCES PAGINAWEB(ID)

);

CREATE TABLE EVENTO 
(
  ID NUMBER NOT NULL,
  FECHA DATE,
  NUM_COMENSALES NUMBER, 
  ID_ZONA NUMBER,
  ID_USUARIOCLIENTE NUMBER,
  CONSTRAINT EVENTO_PK PRIMARY KEY (ID),
  CONSTRAINT FK_ID_ZONA FOREIGN KEY (ID_ZONA) REFERENCES ZONA(ID),
  CONSTRAINT FK_USUARIOCLIENTE FOREIGN KEY (ID_USUARIOCLIENTE) REFERENCES USUARIO(ID)
);

CREATE TABLE INGREDIENTE 
(
  ID NUMBER NOT NULL,
  NOMBRE VARCHAR2(255 BYTE),
  DESCRIPCION VARCHAR2(255 BYTE), 
  TRADUCCION VARCHAR2(255 BYTE),
  ID_USUARIOCLIENTE NUMBER,
  CONSTRAINT INGREDIENTE_PK PRIMARY KEY (ID)
);

CREATE TABLE EVENTO 
(
  ID NUMBER NOT NULL,
  FECHA DATE,
  NUM_COMENSALES NUMBER, 
  ID_ZONA NUMBER,
  ID_USUARIOCLIENTE NUMBER,
  CONSTRAINT EVENTO_PK PRIMARY KEY (ID),
  CONSTRAINT FK_ID_ZONA FOREIGN KEY (ID_ZONA) REFERENCES ZONA(ID),
  CONSTRAINT FK_USUARIOCLIENTE FOREIGN KEY (ID_USUARIOCLIENTE) REFERENCES USUARIO(ID)
);

INSERT into EVENTO (FECHA,ID,NUM_COMENSALES,ID_ZONA,ID_USUARIOCLIENTE) values (to_date('01/03/17','DD/MM/RR'),'1','90','1','1');
INSERT into EVENTO (FECHA,ID,NUM_COMENSALES,ID_ZONA,ID_USUARIOCLIENTE) values (to_date('01/04/17','DD/MM/RR'),'2','40','2','2');
INSERT into EVENTO (FECHA,ID,NUM_COMENSALES,ID_ZONA,ID_USUARIOCLIENTE) values (to_date('09/03/17','DD/MM/RR'),'3','80','4','3');
INSERT into EVENTO (FECHA,ID,NUM_COMENSALES,ID_ZONA,ID_USUARIOCLIENTE) values (to_date('11/03/17','DD/MM/RR'),'4','20','3','4');

INSERT into RESTAURANTE (ID,NOMBRE,REPRESENTANTE,TIPOCOMIDA,ID_ZONA,ID_PAGINAWEB) values ('4','El Corral','Paula','Comida Rapida','4','1');
INSERT into RESTAURANTE (ID,NOMBRE,REPRESENTANTE,TIPOCOMIDA,ID_ZONA,ID_PAGINAWEB) values ('1','McDonalds','Pedro','Comida Rapida','1','1');
INSERT into RESTAURANTE (ID,NOMBRE,REPRESENTANTE,TIPOCOMIDA,ID_ZONA,ID_PAGINAWEB) values ('2','Spoleto','Juan','Pastas','2','2');
INSERT into RESTAURANTE (ID,NOMBRE,REPRESENTANTE,TIPOCOMIDA,ID_ZONA,ID_PAGINAWEB) values ('3','Popsy','Daniela','Helados','3','3');



COMMIT;


