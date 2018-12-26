Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Neg_DetalleVenta
(

in _IdDetalleVenta  int(11),
in _IdVenta  int(11) ,
in _IdProducto  int(11) ,
in _Cantidad decimal(7,2) ,
in _Monto decimal(7,2) ,
in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
 
insert into Neg_DetalleVenta (IdVenta ,IdProducto ,Cantidad,Monto) values(_IdVenta ,_IdProducto ,_Cantidad,_Monto);







   End IF;
 
    if _Opcion='D' then

Delete from Neg_DetalleVenta where IdDetalleVenta =_IdDetalleVenta ;






   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Neg_DetalleVenta  (
 

in _IdVenta int,

 in _Opcion varchar(45)
 
 )
BEGIN

/*D= del dia
  A= Todas las Sedes	*/

 if _Opcion='B' then

SELECT        docassion.neg_detalleventa.IdDetalleVenta, docassion.neg_detalleventa.IdVenta, docassion.neg_detalleventa.IdProducto, docassion.neg_producto.Nombre, docassion.neg_producto.Descripcion, 
                         docassion.neg_detalleventa.Cantidad, docassion.neg_detalleventa.Monto
FROM            docassion.neg_producto INNER JOIN
                         docassion.neg_detalleventa ON docassion.neg_producto.IdProducto = docassion.neg_detalleventa.IdProducto
                         
                         where docassion.neg_detalleventa.IdVenta =_IdVenta order by  docassion.neg_detalleventa.IdDetalleVenta desc;

   End IF;
   
  
   
    

   END
   $$
