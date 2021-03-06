USE [BD]
GO
/****** Object:  StoredProcedure [dbo].[ConsultatiiREFRESH]    Script Date: 17-Jan-18 11:06:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ConsultatiiREFRESH]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'-- =============================================
-- Author:		Vlad Hulea
-- Create date: 17.01.2018
-- Description:	
-- =============================================
ALTER PROCEDURE [dbo].[ConsultatiiREFRESH] 
	-- Add the parameters for the stored procedure here
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
			,T.nume_medicament
	FROM Consultatii AS C 
	INNER JOIN Veterinari AS V ON (C.id_veterinar=V.id_veterinar)
	INNER JOIN Tratament AS T ON (C.id_tratament=T.id_tratament)
END
' 
END