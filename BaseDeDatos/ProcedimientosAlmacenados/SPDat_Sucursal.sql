Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Dat_Sucursal 
(
in _IdSucursal  int(11) ,
in _Ubicacion varchar(45) ,
in _Telefono varchar(45) ,
in _Estado varchar(1) ,


in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
insert into dat_Sucursal (Ubicacion,Telefono,Estado) values(_Ubicacion,_Telefono,_Estado);


   End IF;
   if _Opcion='U' then

update dat_Sucursal set Ubicacion=_Ubicacion,Telefono=_Telefono,Estado=_Estado where IdSucursal =_IdSucursal ;



   End If;
    if _Opcion='D' then

update dat_Sucursal set Estado='I' where IdSucursal =_IdSucursal ;



   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Dat_Sucursal  (
     in _Opcion varchar(45)
 )
BEGIN

 if _Opcion='A' then

select * from dat_Sucursal where Estado='A' order by IdSucursal desc;

   End IF;
   
    if _Opcion='T' then

select * from dat_Sucursal order by IdSucursal desc;

   End IF;


   END
   $$
