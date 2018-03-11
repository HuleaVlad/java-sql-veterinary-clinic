USE [BD]
GO

/****** Object:  StoredProcedure [dbo].[AnimaleUPD]    Script Date: 19-Jan-18 2:34:14 AM ******/
DROP PROCEDURE IF EXISTS [dbo].[AnimaleUPD]
GO

/****** Object:  StoredProcedure [dbo].[AnimaleUPD]    Script Date: 19-Jan-18 2:34:14 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[AnimaleUPD]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[AnimaleUPD] AS' 
END
GO


-- =============================================
-- Author:		Vlad HULEA
-- Create date: 13/01/2018
-- Description:	Create update stored procedure
-- =============================================
ALTER PROCEDURE [dbo].[AnimaleUPD] 
(
	@id_animal int 
    ,@nume_animal nchar(10)
    ,@greutate int
    ,@sex char(1)
    ,@descriere text
    ,@data_nasterii date
    ,@tip_hrana nchar(10)
    ,@nume_proprietar nchar(10)
	,@prenume_proprietar nchar(10)
)
AS
BEGIN
	SET NOCOUNT ON;
	
	DECLARE @id_proprietar int 
	SELECT @id_proprietar=P.id_proprietar
	FROM Proprietar AS P
	WHERE P.nume_proprietar =@nume_proprietar
	AND P.prenume_proprietar =@prenume_proprietar

	DECLARE @id_tip_animal int
	SELECT @id_tip_animal=T.id_tip_animal
	FROM [Tip Animal] AS T
	WHERE T.nume_animal=@nume_animal

	DECLARE @id_hrana int
	SELECT @id_hrana = id_hrana
	FROM Hrana AS H
	WHERE H.tip_hrana=@tip_hrana

    UPDATE [dbo].[Animale]
   SET [id_animal] = @id_animal
      ,[id_tip_animal] = @id_tip_animal
      ,[greutate] = @greutate
      ,[sex] = @sex
      ,[descriere] = @descriere
      ,[data_nasterii] = @data_nasterii
      ,[id_hrana] = @id_hrana
      ,[id_proprietar] = @id_proprietar
	 WHERE [dbo].[Animale].[id_animal] = @id_animal
		
END
GO


