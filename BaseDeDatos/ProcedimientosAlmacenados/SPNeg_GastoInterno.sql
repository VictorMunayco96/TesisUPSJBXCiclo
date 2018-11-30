Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Neg_GastoInterno 
(
in _IdGastoInterno  int(11) ,
in _Fecha datetime ,
in _Asunto varchar(45) ,
in _Descripcion varchar(150) ,
in _MontoTotal decimal(7,2) ,
in _IdSucursal  int(11) ,
in _IdUsuario  int(11) ,



in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
insert into neg_gastointerno (Fecha,Asunto,Descripcion,MontoTotal,IdSucursal ,IdUsuario ) values((SELECT CURDATE()),_Asunto,_Descripcion,_MontoTotal,_IdSucursal ,_IdUsuario);




   End IF;
   if _Opcion='U' then

update neg_gastointerno set Asunto=_Asunto,Descripcion=_Descripcion,MontoTotal=_MontoTotal  where IdGastoInterno =_IdGastoInterno ;




   End If;
    if _Opcion='D' then

Delete from neg_gastointerno where IdGastoInterno =_IdGastoInterno ;




   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Neg_GastoInterno  (
 in _Fecha date,
 in _Fecha2 date,
 in _IdSucursal  int(11) ,
 in _Opcion varchar(45)
 )
BEGIN

/*D= del dia
  A= Todas las Sedes	*/

 if _Opcion='D' then

select * from Neg_GastoInterno where IdSucursal=_IdSucursal and Fecha=(SELECT CURDATE()) order by IdGastoInterno;

   End IF;
   
    if _Opcion='T' then

select * from Neg_GastoInterno where IdSucursal=_IdSucursal and Fecha<=_Fecha2 and Fecha>=_Fecha order by IdGastoInterno ;

   End IF;

if _Opcion='A' then

select * from Neg_GastoInterno where  Fecha<=_Fecha2 and Fecha>=_Fecha order by IdGastoInterno ;

   End IF;

   END
   $$
