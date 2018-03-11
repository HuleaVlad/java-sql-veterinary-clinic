USE [BD]
GO

/****** Object:  StoredProcedure [dbo].[AnimaleREFRESH]    Script Date: 19-Jan-18 3:02:55 AM ******/
DROP PROCEDURE IF EXISTS [dbo].[AnimaleREFRESH]
GO

/****** Object:  StoredProcedure [dbo].[AnimaleREFRESH]    Script Date: 19-Jan-18 3:02:55 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[AnimaleREFRESH]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[AnimaleREFRESH] AS' 
END
GO



-- =============================================
-- Author:		Vlad Hulea
-- Create date: 17.01.2018
-- Description:	
-- =============================================
ALTER PROCEDURE [dbo].[AnimaleREFRESH] 
	-- Add the parameters for the stored procedure here
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT A.id_animal
			,A.greutate
			,A.sex
			,A.data_nasterii
			,H.tip_hrana
			,P.nume_proprietar
			,P.prenume_proprietar
			,TA.nume_animal
	FROM Animale AS A 
	LEFT JOIN [Link Animale_Hrana] AS AH ON (A.id_animal=AH.id_animal)
	LEFT JOIN Hrana AS H ON (AH.id_hrana=H.id_hrana)
	INNER JOIN Proprietar AS P ON (A.id_proprietar=P.id_proprietar)
	INNER JOIN [Tip Animal] AS TA ON (A.id_tip_animal=TA.id_tip_animal)
END
GO


