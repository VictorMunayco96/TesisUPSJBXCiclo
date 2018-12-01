Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Neg_Stock
(
in _IdStock  int(11),
in _Cantidad int(11) ,
in _IdSucursal  int(11) ,
in _IdProducto  int(11) ,
in _EstadoRegistro varchar(1) ,




in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
 
insert into Neg_Stock (Fecha,Hora,Cantidad,IdSucursal ,IdProducto ,EstadoRegistro) values((SELECT CURDATE()),(SELECT DATE_FORMAT(NOW( ), "%H:%i:%S" )),_Cantidad,_IdSucursal ,_IdProducto ,_EstadoRegistro);






   End IF;
   if _Opcion='U' then

update Neg_Stock set Cantidad=_Cantidad  ,EstadoRegistro=_EstadoRegistro where IdStock =_IdStock ;






   End If;
    if _Opcion='D' then

Delete from Neg_Stock where IdStock =_IdStock ;




   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Neg_Stock  (
 
 in _IdProducto int ,
 in _IdSucursal int,

 in _Opcion varchar(45)
 
 )
BEGIN

/*D= del dia
  A= Todas las Sedes	*/

 if _Opcion='N' then

select * from neg_stock where IdProducto= _IdProducto order by IdStock desc;

   End IF;
   
    

   END
   $$
