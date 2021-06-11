package com.qm.reach.mock_server

//MARK:- MockServer @Docs
object MockServer {
  //MARK:- offers and games mock response
  const val failOffersJson = "{[]}"
  const val sucessOffersJson = "{\n" +
    "    \"data\": {\n" +
    "        \"games\": {\n" +
    "            \"data\": [],\n" +
    "            \"meta\": {\n" +
    "                \"include\": [],\n" +
    "                \"custom\": []\n" +
    "            }\n" +
    "        },\n" +
    "        \"offers\": {\n" +
    "            \"data\": [\n" +
    "                {\n" +
    "                    \"id\": 189,\n" +
    "                    \"title\": \"fatma_busniess\",\n" +
    "                    \"cover_image\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/offers/142974/b13ab615696732e2b7e2ab843a136fd87f1f0410.jpeg?v=1611841382\",\n" +
    "                    \"banner_image\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/offers/banners/142974/b13ab615696732e2b7e2ab843a136fd87f1f0410.jpeg?v=1611841382\",\n" +
    "                    \"cta\": \"Offer1\",\n" +
    "                    \"cta_url\": \"https://www.facebook.com\",\n" +
    "                    \"cta_text_color\": \"#d7bcbc\",\n" +
    "                    \"cta_background_color\": \"#374d52\",\n" +
    "                    \"due_date\": \"2021-07-29 00:00:00\",\n" +
    "                    \"user\": {\n" +
    "                        \"object\": \"User\",\n" +
    "                        \"id\": 142974,\n" +
    "                        \"username\": \"fatma_busniess\",\n" +
    "                        \"name\": \"fatma_busniess\",\n" +
    "                        \"profile_picture\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/thumbs/142974.jpg?v=1611480706\",\n" +
    "                        \"cover_photo\": null,\n" +
    "                        \"background_image\": null,\n" +
    "                        \"phone_background\": null\n" +
    "                    },\n" +
    "                    \"categories\": [\n" +
    "                        {\n" +
    "                            \"id\": 1,\n" +
    "                            \"slug\": \"perfumes\",\n" +
    "                            \"name\": \"Perfumes\"\n" +
    "                        },\n" +
    "                        {\n" +
    "                            \"id\": 5,\n" +
    "                            \"slug\": \"cafe\",\n" +
    "                            \"name\": \"Cafe\"\n" +
    "                        },\n" +
    "                        {\n" +
    "                            \"id\": 20,\n" +
    "                            \"slug\": \"social\",\n" +
    "                            \"name\": \"Social\"\n" +
    "                        }\n" +
    "                    ]\n" +
    "                },\n" +
    "                {\n" +
    "                    \"id\": 206,\n" +
    "                    \"title\": \"fatma_busniess\",\n" +
    "                    \"cover_image\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/offers/142974/a5fd8ffc48843469e38245d3eba3a5f17cedf39e.jpeg?v=1612187476\",\n" +
    "                    \"banner_image\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/offers/banners/142974/a5fd8ffc48843469e38245d3eba3a5f17cedf39e.jpeg?v=1612187476\",\n" +
    "                    \"cta\": \"offer 234\",\n" +
    "                    \"cta_url\": \"https://www.facebook.com\",\n" +
    "                    \"cta_text_color\": \"#311717\",\n" +
    "                    \"cta_background_color\": \"#624949\",\n" +
    "                    \"due_date\": \"2021-06-24 00:00:00\",\n" +
    "                    \"user\": {\n" +
    "                        \"object\": \"User\",\n" +
    "                        \"id\": 142974,\n" +
    "                        \"username\": \"fatma_busniess\",\n" +
    "                        \"name\": \"fatma_busniess\",\n" +
    "                        \"profile_picture\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/thumbs/142974.jpg?v=1611480706\",\n" +
    "                        \"cover_photo\": null,\n" +
    "                        \"background_image\": null,\n" +
    "                        \"phone_background\": null\n" +
    "                    },\n" +
    "                    \"categories\": [\n" +
    "                        {\n" +
    "                            \"id\": 1,\n" +
    "                            \"slug\": \"perfumes\",\n" +
    "                            \"name\": \"Perfumes\"\n" +
    "                        },\n" +
    "                        {\n" +
    "                            \"id\": 5,\n" +
    "                            \"slug\": \"cafe\",\n" +
    "                            \"name\": \"Cafe\"\n" +
    "                        },\n" +
    "                        {\n" +
    "                            \"id\": 20,\n" +
    "                            \"slug\": \"social\",\n" +
    "                            \"name\": \"Social\"\n" +
    "                        }\n" +
    "                    ]\n" +
    "                }\n" +
    "            ],\n" +
    "            \"meta\": {\n" +
    "                \"include\": [],\n" +
    "                \"custom\": []\n" +
    "            }\n" +
    "        }\n" +
    "    }\n" +
    "}"

  //MARK:- category mock response
  const val failCategoryJson = "{[]}"
  const val sucessCategoryJson = "{\n" +
    "    \"data\": [\n" +
    "        {\n" +
    "            \"id\": 14,\n" +
    "            \"slug\": \"shopping\",\n" +
    "            \"name\": \"Shopping\",\n" +
    "            \"users\": {\n" +
    "                \"data\": [\n" +
    "                    {\n" +
    "                        \"object\": \"User\",\n" +
    "                        \"id\": 18508,\n" +
    "                        \"username\": \"boutiqaat\",\n" +
    "                        \"name\": \"Health/Beauty\",\n" +
    "                        \"bio\": \"Welcome to the official Reach account of boutiqaat\",\n" +
    "                        \"profile_picture\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/thumbs/18508.jpg?v=1578504309\",\n" +
    "                        \"cover_photo\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/thumbs/18508?v=1578504309\",\n" +
    "                        \"background_image\": null,\n" +
    "                        \"phone_background\": null\n" +
    "                    },\n" +
    "                    {\n" +
    "                        \"object\": \"User\",\n" +
    "                        \"id\": 105397,\n" +
    "                        \"username\": \"thesetupkw\",\n" +
    "                        \"name\": \"TheSetupkw\",\n" +
    "                        \"bio\": null,\n" +
    "                        \"profile_picture\": \"https://reachnetwork.s3.eu-central-1.amazonaws.com/thumbs/105397.jpg?v=1552996027\",\n" +
    "                        \"cover_photo\": null,\n" +
    "                        \"background_image\": null,\n" +
    "                        \"phone_background\": null\n" +
    "                    },\n" +
    "                    {\n" +
    "                        \"object\": \"User\",\n" +
    "                        \"id\": 50872,\n" +
    "                        \"username\": \"jollychic\",\n" +
    "                        \"name\": \"JollyChic\",\n" +
    "                        \"bio\": \"Live with a style\",\n" +
    "                        \"profile_picture\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/thumbs/50872.jpg?v=1564358949\",\n" +
    "                        \"cover_photo\": null,\n" +
    "                        \"background_image\": null,\n" +
    "                        \"phone_background\": null\n" +
    "                    },\n" +
    "                    {\n" +
    "                        \"object\": \"User\",\n" +
    "                        \"id\": 61368,\n" +
    "                        \"username\": \"Nalbes\",\n" +
    "                        \"name\": null,\n" +
    "                        \"bio\": \"Welcome to official page of Nalbes\",\n" +
    "                        \"profile_picture\": \"https://development-stack-ecs-1n6wwy02i0z-containerbucket-4owki1hh2b8w.s3.eu-central-1.amazonaws.com/thumbs/61368.jpg?v=1555445535\",\n" +
    "                        \"cover_photo\": null,\n" +
    "                        \"background_image\": null,\n" +
    "                        \"phone_background\": null\n" +
    "                    },\n" +
    "                    {\n" +
    "                        \"object\": \"User\",\n" +
    "                        \"id\": 55794,\n" +
    "                        \"username\": \"brandattcom-brandat\",\n" +
    "                        \"name\": \"Brandatt.com - براندات\",\n" +
    "                        \"bio\": \"Let the Beauty of what you love be what you are \uD83D\uDC84\\nThe premier online beauty retailer\",\n" +
    "                        \"profile_picture\": \"http://pbs.twimg.com/profile_images/949926234674184192/a-_76MwC.jpg\",\n" +
    "                        \"cover_photo\": null,\n" +
    "                        \"background_image\": null,\n" +
    "                        \"phone_background\": null\n" +
    "                    }\n" +
    "                ]\n" +
    "            }\n" +
    "        }\n]\n}"
}