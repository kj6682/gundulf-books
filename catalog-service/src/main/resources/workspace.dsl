workspace {

    model {
        user = person "User" "A user of the Gundulf Books system."
        gundulfSystem = softwareSystem "Gundulf Books" "My magical library"{
            catalog_service = container "Catalog Service" {
                technology "spring boot"
                description  "It will be responsible for managing the catalog of books in the Polar Bookshop system."
            }
        }

        user -> gundulfSystem "Uses"
        user -> catalog_service "uses" "REST/HTTP"
    }

    views {
        systemContext gundulfSystem "SystemContext" {
            include *
            autoLayout
        }

        container gundulfSystem {
            include *
            autolayout
        } 
        
        styles {
            element "Software System" {
                background #1168bd
                color #ffffff
            }
            element "Person" {
                shape person
                background #08427b
                color #ffffff
            }
        }
    }
    
}