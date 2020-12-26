from django.conf import settings
from django.conf.urls.static import static
from django.contrib import admin
from django.urls import path, include
from products.api.routes import router as products_router


api_urlpatterns = [
    path("api/products/", include(products_router.urls))
]

urlpatterns = [
    path('admin/', admin.site.urls),
    path('products/', include('products.urls'))
] + api_urlpatterns + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
