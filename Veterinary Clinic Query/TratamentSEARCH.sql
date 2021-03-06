USE [BD]
GO
/****** Object:  StoredProcedure [dbo].[TratamentSEARCH]    Script Date: 17-Jan-18 5:48:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TratamentSEARCH]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'-- =============================================
-- Author:		Vlad Hulea
-- Create date: 16/10/2018
-- Description:	
-- =============================================
ALTER PROCEDURE [dbo].[TratamentSEARCH] 
	-- Add the parameters for the stored procedure here
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT Tratament.id_tratament
			,Tratament.nume_medicament
			,Tratament.folosire_medicament
	FROM Tratament 
	INNER JOIN Consultatii ON (Tratament.id_tratament=Consultatii.id_tratament)
END
' 
END