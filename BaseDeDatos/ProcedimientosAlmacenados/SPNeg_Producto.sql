Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Neg_Producto
(
in _IdProducto  int(11) ,
in _CodBarra varchar(45) ,
in _Nombre varchar(45) ,
in _Descripcion varchar(100) ,
in _Categoria varchar(45) ,
in _PrecioVenta decimal(7,2) ,
in _PrecioDescuento decimal(7,2) ,
in _Popularidad int(11) ,
in _Estado varchar(1) ,



in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
insert into neg_producto  (CodBarra,Nombre,Descripcion,Categoria,PrecioVenta,PrecioDescuento,Popularidad,Estado) 
values(_CodBarra,_Nombre,_Descripcion,_Categoria,_PrecioVenta,_PrecioDescuento,_Popularidad,_Estado);





   End IF;
   if _Opcion='U' then

update neg_producto  set CodBarra=_CodBarra,Nombre=_Nombre,Descripcion=_Descripcion,Categoria=_Categoria,PrecioVenta=_PrecioVenta,PrecioDescuento=_PrecioDescuento,Popularidad=_Popularidad,Estado=_Estado where IdProducto =_IdProducto ;





   End If;
    if _Opcion='D' then

update neg_producto  set Estado='I' where IdProducto =_IdProducto ;


   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Neg_Producto  (
 
 in _Nombre varchar(45) ,
in _Categoria varchar(45) ,

 in _Opcion varchar(45)
 
 )
BEGIN

/*D= del dia
  A= Todas las Sedes	*/

 if _Opcion='N' then

select * from neg_producto where Nombre like concat('%',_Nombre,'%') order by Popularidad desc;

   End IF;
   
    if _Opcion='R' then

select * from neg_producto where Nombre like concat('%',_Nombre,'%') order by IdProducto desc ;

   End IF;

if _Opcion='C' then

select * from neg_producto where Categoria like concat('%',_Nombre,'%') order by Popularidad desc;

   End IF;

   END
   $$
