Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Neg_DetalleCompra
(

in _IdDetalleCompra  int(11),
in _IdProducto  int(11) ,
in _Cantidad int(11) ,
in _PrecioUnitario decimal(7,2) ,
in _Monto decimal(7,2) ,
in _IdCompra  int(11) ,

in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
 
insert into Neg_DetalleCompra (IdProducto ,Cantidad,PrecioUnitario,Monto,IdCompra) values(_IdProducto ,_Cantidad,_PrecioUnitario,_Monto,_IdCompra);



   End IF;

 

 
    if _Opcion='D' then

Delete from Neg_DetalleCompra where IdDetalleCompra =_IdDetalleCompra ;







   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Neg_DetalleCompra  (
 
in _IdCompra int,

 in _Opcion varchar(45)
 
 )
BEGIN

/*D= del dia
  A= Todas las Sedes	*/

 if _Opcion='B' then

SELECT        docassion.neg_detallecompra.IdDetalleCompra, docassion.neg_detallecompra.IdProducto, docassion.neg_producto.Nombre, docassion.neg_producto.Descripcion, docassion.neg_detallecompra.Cantidad, 
                         docassion.neg_detallecompra.PrecioUnitario, docassion.neg_detallecompra.Monto, docassion.neg_detallecompra.IdCompra
FROM            docassion.neg_producto INNER JOIN
                         docassion.neg_detallecompra ON docassion.neg_producto.IdProducto = docassion.neg_detallecompra.IdProducto

 where docassion.neg_detallecompra.IdCompra =_IdCompra  order by    docassion.neg_detallecompra.IdDetalleCompra desc;

   End IF;
   
  
   
    

   END
   $$
