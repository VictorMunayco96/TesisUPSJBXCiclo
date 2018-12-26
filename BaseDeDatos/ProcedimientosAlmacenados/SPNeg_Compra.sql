Use docassion	;

DELIMITER $$
 CREATE PROCEDURE PA_Set_Neg_Compra
(

in _IdCompra  int(11) ,
in _IdUsuario  int(11) ,
in _Asunto varchar(50) ,
in _Descripcion varchar(150) ,
in _MontoTotal decimal(7,2) ,

in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='I' then
 
insert into Neg_Compra (IdUsuario ,Fecha,Asunto,Descripcion,MontoTotal) values(_IdUsuario ,(Select curdate()),_Asunto,_Descripcion,_MontoTotal);


   End IF;

 if _Opcion='U' then

update Neg_Compra set Asunto=_Asunto,Descripcion=_Descripcion,MontoTotal=_MontoTotal where IdCompra =_IdCompra ;






   End If;

 
    if _Opcion='D' then

Delete from Neg_Compra where IdCompra =_IdCompra ;







   End If;
   END
   $$

DELIMITER $$
 CREATE PROCEDURE PA_Get_Neg_Compra  (
 


 in _Opcion varchar(45)
 
 )
BEGIN

/*D= del dia
  A= Todas las Sedes	*/

 if _Opcion='B' then

SELECT        * from neg_compra     order by  IdCompra desc;

   End IF;
   
  
   
    

   END
   $$
