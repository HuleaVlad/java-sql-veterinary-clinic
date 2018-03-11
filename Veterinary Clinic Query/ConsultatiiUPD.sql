USE [BD]
GO

/****** Object:  StoredProcedure [dbo].[ConsultatiiUPD]    Script Date: 16-Jan-18 4:34:33 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ConsultatiiUPD]
GO

/****** Object:  StoredProcedure [dbo].[ConsultatiiUPD]    Script Date: 16-Jan-18 4:34:33 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ConsultatiiUPD]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[ConsultatiiUPD] AS' 
END
GO

      
-- =============================================
-- Author:		Vlad HULEA
-- Create date: 16/01/2018
-- Description:	Create update stored procedure
-- =============================================
ALTER PROCEDURE [dbo].[ConsultatiiUPD] 
(
	@id_consultatie int
    ,@data_consultatie date
    ,@diagnostic text
    ,@id_tratament int
    ,@id_animal int
    ,@id_veterinar int
)
AS
BEGIN
	SET NOCOUNT ON;

    UPDATE [dbo].[Consultatii]
   SET		[id_consultatie]=@id_consultatie
           ,[data_consultatie]=@data_consultatie
           ,[diagnostic]=@diagnostic
           ,[id_tratament]=@id_tratament
           ,[id_animal]=@id_animal
           ,[id_veterinar]=@id_veterinar
	 WHERE [dbo].[Consultatii].[id_consultatie] = @id_consultatie
		
END
GO


