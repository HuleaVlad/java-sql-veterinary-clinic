USE [BD]
GO
/****** Object:  StoredProcedure [dbo].[ConsultatiiTabConsultatieSEARCH]    Script Date: 17-Jan-18 11:05:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ConsultatiiTabConsultatieSEARCH]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'-- =============================================
-- Author:		Vlad Hulea
-- Create date: 16.01.2018
-- Description:	
-- =============================================
ALTER PROCEDURE [dbo].[ConsultatiiTabConsultatieSEARCH] 
	-- Add the parameters for the stored procedure here
	@data_consultatie date
	,@id_veterinar int
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
							 WHERE t.id_tratament = c.id_tratament)
	FROM Consultatii AS C
	INNER JOIN Veterinari AS V ON (C.id_veterinar=V.id_veterinar)
	WHERE C.data_consultatie=@data_consultatie AND C.id_veterinar=@id_veterinar
END
' 
END