USE [BD]
GO
/****** Object:  StoredProcedure [dbo].[ConsultatiiTabAnimaleSEARCH]    Script Date: 17-Jan-18 11:05:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ConsultatiiTabAnimaleSEARCH]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'-- =============================================
-- Author:		Vlad Hulea
-- Create date: 17/01/2018
-- Description:	
-- =============================================
ALTER PROCEDURE [dbo].[ConsultatiiTabAnimaleSEARCH]
	-- Add the parameters for the stored procedure here
	@nume_animal nchar
	,@id_tratament nchar
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT C.id_consultatie
			,C.data_consultatie
			,V.nume_v
			,V.prenume_v 
			,(SELECT  T.nume_medicament
							 FROM Tratament AS T
							 WHERE T.id_tratament = @id_tratament)
	FROM Consultatii AS C 
	INNER JOIN Veterinari AS V ON (C.id_veterinar=V.id_veterinar)
	WHERE C.id_animal IN (SELECT A.id_animal
						  FROM Animale AS A 
						  WHERE A.id_tip_animal IN (SELECT TA.id_tip_animal
												  FROM [Tip Animal] AS TA
												  WHERE TA.nume_animal LIKE ''%'' + @nume_animal + ''%'')
						)
END
' 
END