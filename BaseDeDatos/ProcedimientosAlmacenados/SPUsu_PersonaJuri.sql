Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Usu_Personajuri 
(
in _Ruc  char(11) ,
in _Descripcion varchar(100) ,
in _Direccion varchar(100) ,



in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
insert into usu_personajuri  (Ruc,Descripcion,Direccion) values(_Ruc,_Descripcion,_Direccion);

   End IF;
   if _Opcion='U' then

update usu_personajuri  set Descripcion=_Descripcion,Direccion=_Direccion where Ruc =_Ruc ;


   End If;
    if _Opcion='D' then

Delete from usu_personajuri  where Ruc =_Ruc ;


   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Usu_Personajuri (
in _Ruc  char(11) ,
     in _Opcion varchar(45)
 )
BEGIN

 if _Opcion='L' then

Select * from usu_personajuri where Ruc=_Ruc;

   End IF;

   END
   $$
