USE [BD]
GO

/****** Object:  StoredProcedure [dbo].[ConsultatiiDEL]    Script Date: 16-Jan-18 4:28:29 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[ConsultatiiDEL]
GO

/****** Object:  StoredProcedure [dbo].[ConsultatiiDEL]    Script Date: 16-Jan-18 4:28:29 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ConsultatiiDEL]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[ConsultatiiDEL] AS' 
END
GO
 

-- =============================================
-- Author:		Vlad HULEA
-- Create date: 13/01/2018
-- Description:	Create delete stored procedure
-- =============================================
ALTER PROCEDURE [dbo].[ConsultatiiDEL] 
(
	@id_consultatie		[INT]
)
AS
BEGIN
	SET NOCOUNT ON;
  
    DELETE FROM [dbo].[Consultatii]
		WHERE [dbo].[Consultatii].[id_consultatie] = @id_consultatie
		
END
GO


