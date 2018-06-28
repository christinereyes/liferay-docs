# Getting Started with @commerce@ [](id=getting-started)

@commerce@ is a digital commerce platform for midmarket enterprises. While
highly customizable, it is not just a collection of tools for hacking together
your own custom commerce system (though it could certainly be used for that).
@commerce@ is a full-service commerce solution that offers out-of-the-box
functionality.

@commerce@ is built on top of @product@, and as such is integrated with
@product@'s content and user management systems. Any website built with
@product-ver@ can be integrated seamlessly with a store built with @commerce@.

## Overview

@commerce@ is equipped with a 
[catalog management](/web/liferay-emporio/documentation/-/knowledge_base/1-0/catalog-management)
system that supports both physical and virtual products. The catalog stores
a wide range of product data---product variations, pricing, images,
specifications---and makes it readily available to the store's customer-facing
pages.

![Figure 1: The catalog stores inventory levels, category assignments, and other product information.](../images/catalog.png)

Those customer-facing pages can be constructed with the methods that have
already been proven by long-time users of @product@. Setting up a 
[storefront](/web/liferay-emporio/documentation/-/knowledge_base/1-0/setting-up-a-storefront)
is facilitated by a wide range of tools that @commerce@ provides
specifically for the purpose. New search tools, for instance, are geared
specifically for surfing the contents of the catalog, while customizable
widgets make it easy to add common UI elements---such as *Checkout* and *View
Cart*---to a page.

![Figure 2: Product pages are ready to go out-of-the-box, but can be customized extensively.](../images/product-detail.png)

@commerce@ is optimized for business-to-business transactions, with an eye
toward making B2B more user-friendly than it sometimes tends to be. 
[Customer Portal](/web/liferay-emporio/documentation/-/knowledge_base/1-0/customer-portal)
is designed to serve the needs of buyers who have an approval process to observe
before making purchases. When a buyer places an order, @commerce@ can send an
automated email to his manager (or managers), prompting her to approve the order
so that it can be processed. The customer portal gives customer organizations
the ability to manage their own accounts, allowing them to designate their own
buyers, order managers, and account managers.

In addition, @commerce@ features a user control system that is integrated with
@product@'s roles and permissions functionality. 
[User segmentation](/web/liferay-emporio/documentation/-/knowledge_base/1-0/user-segmentation)
allows pricing, catalog visibility, and other features to be precisely targeted
to certain customers. This functionality is available to stores that do not use
the customer portal model as well as those that do.

[Pricing](/web/liferay-emporio/documentation/-/knowledge_base/1-0/pricing) and
[Tax](/web/liferay-emporio/documentation/-/knowledge_base/1-0/taxes) features
allow almost unlimited flexibility, allowing almost any kind of discount
imaginable to be applied and permitting transactions in any currency, or in
multiple currencies. Meanwhile
[payments](/web/liferay-emporio/documentation/-/knowledge_base/1-0/payment-methods)
can be handled through integration with a third-party payment processor, through
a service such as Paypal, or completely in-house.

![Figure 3: Any number of different payment methods can be added.](../images/payment-methods.png)

Products can be shipped by any number of different
[methods](/web/liferay-emporio/documentation/-/knowledge_base/1-0/shipping-methods):
sellers can impose a flat rate, calculate costs on the basis of weight, or
integrate their systems closely with the rates of a shipping service, allowing
buyers to choose directly from the services offered by---say---FedEx or UPS.
The
[Warehouses](/web/liferay-emporio/documentation/-/knowledge_base/1-0/warehouses)
feature allows @commerce@ to track inventories at different warehouses
separately and automatically. When an order is placed, @commerce@ will determine
which warehouse is closest to the delivery point and process the order
accordingly.

## Site Initializers

The quickest way to get going with @commerce@ is to use a site initializer.
A site initializer is a type of 
[site template]( /discover/portal/-/knowledge_base/7-1/building-sites-from-templates)
that does much of the initial work of setting up a store. Creating a site with
a site initializer is an easy way to see what commerce can do, and can be used
to get a head start on a live store: modify the theme to suit your purposes,
replace the dummy catalog with your own data, and you're well on your way.

At the time of this writing, @commerce@ ships with one site initializer, called
Beryl. It includes a theme, a complete user interface oriented towards B2B
selling, and a catalog populated with sample products. See [Customer
Portal](/web/liferay-emporio/documentation/-/knowledge_base/1-0/customer-portal)
for for information.
