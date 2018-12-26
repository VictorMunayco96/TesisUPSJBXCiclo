Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Neg_Venta
(
in _IdVenta  int(11) ,
in _IdUsuario  int(11) ,
in _IGV decimal(7,2) ,
in _MontoTotal decimal(7,2) ,
in _CuantoDio decimal(7,2) ,
in _Vuelto decimal(7,2) ,
in _TipoRecibo varchar(10) ,
in _TipoPago varchar(10) ,
in _IdSucursal  int(11) ,
in _Estado varchar(45) ,
in _Ruc  char(11) ,
in _DNI  int(11) ,

in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
 
insert into Neg_Venta (IdUsuario ,Fecha,Hora,IGV,MontoTotal,CuantoDio,Vuelto,TipoRecibo,TipoPago,IdSucursal ,Estado,Ruc ,DNI ) values(_IdUsuario ,(Select curdate()),(SELECT DATE_FORMAT(NOW( ), "%H:%i:%S" )),_IGV,_MontoTotal,_CuantoDio,_Vuelto,_TipoRecibo,_TipoPago,_IdSucursal ,_Estado,_Ruc ,_DNI);







   End IF;
   if _Opcion='U' then

update Neg_Venta set IdUsuario =_IdUsuario ,IGV=_IGV,MontoTotal=_MontoTotal,CuantoDio=_CuantoDio,Vuelto=_Vuelto,TipoRecibo=_TipoRecibo,TipoPago=_TipoPago,IdSucursal =_IdSucursal ,Estado=_Estado,Ruc =_Ruc ,DNI =_DNI where IdVenta =_IdVenta ;







   End If;
    if _Opcion='D' then

update Neg_Venta set Estado='ANULADA' where IdVenta =_IdVenta ;





   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Neg_Venta  (
 

in _IdSucursal int,
in _IdVenta int,
 in _Opcion varchar(45)
 
 )
BEGIN

/*D= del dia
  A= Todas las Sedes	*/

 if _Opcion='B' then

select * from neg_Venta where IdVenta= _IdVenta and IdSucursal=_IdSucursal ;

   End IF;
   
   if _Opcion='T' then

select * from neg_Venta where IdSucursal=_IdSucursal order by IdVenta desc limit 50;

   End IF;
   
    

   END
   $$
