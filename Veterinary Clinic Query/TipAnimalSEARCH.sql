USE [BD]
GO
/****** Object:  StoredProcedure [dbo].[TipAnimalSEARCH]    Script Date: 17-Jan-18 5:46:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipAnimalSEARCH]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'-- =============================================
-- Author:		Vlad Hulea
-- Create date: 16.01.2018
-- Description:	
-- =============================================
ALTER PROCEDURE [dbo].[TipAnimalSEARCH] 
	-- Add the parameters for the stored procedure here

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [Tip Animal].id_tip_animal
			,[Tip Animal].nume_animal
			,[Tip Animal].descriere_animal
			
	FROM [Tip Animal]
	INNER JOIN Animale ON ([Tip Animal].id_tip_animal=Animale.id_tip_animal)
END
' 
END