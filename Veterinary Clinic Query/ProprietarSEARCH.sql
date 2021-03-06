USE [BD]
GO
/****** Object:  StoredProcedure [dbo].[ProprietarSEARCH]    Script Date: 18-Jan-18 6:24:05 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ProprietarSEARCH]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'-- =============================================
-- Author:		Vlad Hulea
-- Create date: 16.01.2018
-- Description:	
-- =============================================
ALTER PROCEDURE [dbo].[ProprietarSEARCH] 
	-- Add the parameters for the stored procedure here
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT Proprietar.id_proprietar
			,Proprietar.nume_proprietar
			,Proprietar.prenume_proprietar
			,Proprietar.mail_proprietar
			,Proprietar.telefon_proprietar

	FROM Proprietar
	INNER JOIN Animale ON (Animale.id_proprietar=Proprietar.id_proprietar)
END
' 
END