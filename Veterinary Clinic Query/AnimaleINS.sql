USE [BD]
GO

/****** Object:  StoredProcedure [dbo].[AnimaleINS]    Script Date: 18-Jan-18 11:22:46 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[AnimaleINS]
GO

/****** Object:  StoredProcedure [dbo].[AnimaleINS]    Script Date: 18-Jan-18 11:22:46 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[AnimaleINS]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[AnimaleINS] AS' 
END
GO




-- =============================================
-- Author:		Vlad HULEA
-- Create date: 13/01/2018
-- Description:	Create insert stored procedure
-- =============================================
ALTER PROCEDURE [dbo].[AnimaleINS] 
(
	@id_animal int OUTPUT
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

	SELECT @id_animal = MAX([dbo].[Animale].[id_animal]) + 1
	FROM [dbo].[Animale]

	IF (@id_animal IS NULL)
	BEGIN
		SET @id_animal = 1;
	END

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
	SELECT @id_hrana
	FROM Hrana AS H
	WHERE H.tip_hrana=@tip_hrana

    INSERT INTO [dbo].[Animale]
           ([id_animal]
           ,[id_tip_animal]
           ,[greutate]
           ,[sex]
           ,[descriere]
           ,[data_nasterii]
           ,[id_hrana]
		   ,[id_proprietar])
     VALUES
           (@id_animal
           ,@id_tip_animal
           ,@greutate
           ,@sex
           ,@descriere
           ,@data_nasterii
           ,@id_hrana
           ,@id_proprietar)
		
END
GO


