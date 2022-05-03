select 
            m.menuName
            ,m.g01
            ,m.g04
            ,m.g05
            ,m.g06
            ,m.g07
            ,m.g08
            ,m.g09
            ,m.g10
            ,m.g11
            ,m.g12
            ,m.g13
            ,m.dbalias
            ,d.aliasName
            ,d.Grid_Columns_Title
            ,d.SortElement
            ,d.Grid_FormGroup
            ,d.Grid_Columns_Width
            ,d.Grid_Align
            ,d.Grid_Orderby
            ,d.Grid_MaxLength
            ,d.Grid_Default
            ,d.Grid_Select_Tname
            ,case when d.Grid_Select_Tname<>'' and isnumeric(left(d.Grid_Select_Field,1))=1 then '['+d.Grid_Select_Field+']' else d.Grid_Select_Field end as Grid_Select_Field
            ,d.Grid_GroupCompute
            ,d.Grid_CtlName 
            ,d.Grid_IsHandle
            ,d.Grid_Schema_Validation
            ,d.Grid_PrimeKey
            ,d.Grid_Alim
            ,d.Grid_Pil
            ,d.Grid_Schema_Type
            from MisMenuList_Detail d
            left outer join MisMenuList m on m.RealPid=d.RealPid
            where (d.sortelement<>999 or d.Grid_Select_Field!="") and d.aliasName<>'' and d.RealPid='$logicPid'  
            order by sortelement;