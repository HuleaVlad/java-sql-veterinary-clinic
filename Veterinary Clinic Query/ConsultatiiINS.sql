USE [BD]
GO
/****** Object:  StoredProcedure [dbo].[ConsultatiiINS]    Script Date: 17-Jan-18 3:57:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ConsultatiiINS]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'



-- =============================================
-- Author:		Vlad HULEA
-- Create date: 13/01/2018
-- Description:	Create insert stored procedure
-- =============================================
ALTER PROCEDURE [dbo].[ConsultatiiINS] 
(
	@id_consultatie int OUTPUT
    ,@data_consultatie date
    ,@diagnostic text
    ,@id_tratament int
    ,@id_animal int
    ,@id_veterinar int
)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT @id_consultatie = MAX([dbo].[Consultatii].[id_consultatie]) + 1
	FROM [dbo].[Consultatii]

	IF (@id_consultatie IS NULL)
	BEGIN
		SET @id_consultatie = 1;
	END

    INSERT INTO [dbo].[Consultatii]
           ([id_consultatie]
           ,[data_consultatie]
           ,[diagnostic]
           ,[id_tratament]
           ,[id_animal]
           ,[id_veterinar])
     VALUES
           (@id_consultatie
           ,@data_consultatie
           ,@diagnostic
           ,@id_tratament
           ,@id_animal
           ,@id_veterinar)
		
END

' 
END