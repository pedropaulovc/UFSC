#ifndef ELEMENTO_H_
#define ELEMENTO_H_

template<class T> class Elemento {
	Elemento<T>* proximo;
	T* info;

public:
	Elemento(T* infoElemento, Elemento<T>* proximoElemento){
		proximo = proximoElemento;
		info = infoElemento;
	}

	virtual ~Elemento(){
		// FAZ NADA MANOLO
	}

	T *getInfo() {
		return info;
	}

	Elemento<T>* getProximo() {
		return proximo;
	}

	void setProximo(Elemento<T>* proximo) {
		this->proximo = proximo;
	}

	bool maior(Elemento<T>* elemento){
		return *info > *elemento;
	}

	bool menor(Elemento<T>* elemento){
		return *info < *elemento;
	}

	bool igual(Elemento<T>* elemento){
		return *info == *elemento;
	}
};

#endif /* ELEMENTO_H_ */
